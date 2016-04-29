
package swtesting_calc_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Guillaume
 */

public class Parser {
    
    private String errorMessage;
    private double lastAnswer;
    private double[] lastVectorAnswer;
    private boolean flagVectorAnswer;
    private CLInterface cli;

    public Parser(CLInterface mainProgram) {
        this.cli = mainProgram;
        this.errorMessage = "";
        this.lastAnswer = 0.0;
        this.lastVectorAnswer = null;
        this.flagVectorAnswer = false;
    }
    
    /**
     * Parses the input String, creates the corresponding Calculation object and calls it's execute() method.
     * @param input the String as used by the user to specify the calculation
     * @return returns 0 if successful, -1 in case of an error, 1 if answer is a vector.
     */
    public int parseInputString(String input){
        
        int status = -1;
        
        Calculation calculationObj;
        
        String parts[] = input.split( " " );
        
        /* Filters out empty Strings from parts[]
        in case the input has two spaces next to each other,
        which would lead to an empty String in the parts[] array.
        */
        List<String> list = new ArrayList<String>();
        Collections.addAll( list, parts );
        list.removeAll( Arrays.asList( "" ) );
        parts = list.toArray( new String[list.size()] );
        
        if( parts.length < 2 ){
            errorMessage = "Too little elements to parse as a calculation.";
            return -1;
        } else if( parts.length == 2 ){
            calculationObj = new OneOperandCalculation( parts[0], Double.parseDouble( parts[1] ) );
            status = 0;
        } else if( parts.length == 3 ){
            if( parts[0].contains( "v" ) || parts[2].contains( "v" ) ){
                if( parts[0].contains("v") && parts[2].contains( "v" ) ){
                    calculationObj = new VectorVectorCalculation( parts[1], createVectorFromString( parts[0] ), createVectorFromString( parts[2] ) );
                    status = 0;
                } else{
                    if( parts[0].contains( "v" ) ){
                        calculationObj = new VectorScalarCalculation( parts[1], createVectorFromString( parts[0] ), Double.parseDouble( parts[2] ) );
                        status = 0;
                    } else {
                        calculationObj = new VectorScalarCalculation( parts[1], createVectorFromString( parts[2] ), Double.parseDouble( parts[0] ) );
                        status = 0;
                    }
                }
            } else if( parts[0].contains( "V" ) || parts[2].contains( "V" ) ){
                errorMessage = "Vectors are defined with a small 'v'!";
                return -1;
            } else {
                calculationObj = new TwoOperandCalculation( parts[1], Double.parseDouble( parts[0] ), Double.parseDouble( parts[2] ) );
                status = 0;
            }
        } else {
            errorMessage = "Too many elements to parse as a calculation.";
            return -1;
        }
        
        //execute the calculation object and deal with 0, 1 or -1 as return value
        
        if( status == 0 ){   //only execute if everything up until this line went OK
            int result = calculationObj.execute();
            if( result == 0 ){
                lastAnswer = calculationObj.getAnswer();
                status = result;
                flagVectorAnswer = false;
            } else if( result == 1 ) {
                lastVectorAnswer = calculationObj.getAnswerVector();
                status = result;
                if( lastVectorAnswer == null ){
                    errorMessage = "Returned null for an answer.";
                    status = -1;
                }
                flagVectorAnswer = true;
            } else if( result == -1 ){
                errorMessage = calculationObj.getError();
                status = result;
            }
        }
        
        if( status >= 0 ){
            cli.addToHistory( calculationObj );
        }
        
        return status;
    }

    /**
     * @return the lastAnswer
     */
    public double getLastAnswer() {
        return lastAnswer;
    }

    /**
     * @param lastAnswer the lastAnswer to set
     */
    public void setLastAnswer(double lastAnswer) {
        this.lastAnswer = lastAnswer;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
    private double[] createVectorFromString( String vectorString ){
        /* @todo even though it is a private method, still test the implementation for this method! */
        
        /* because index of "v(" and ")" are known */
        String numericPart = vectorString.substring( 2, vectorString.length()-1 );
        
        String[] parts = numericPart.split( "," );
        int elementCount = parts.length;
        double[] result = new double[elementCount];
                
        for(int i=0; i<elementCount; i++){
            result[i] = Double.parseDouble( parts[i] );
        }
        
        return result;
    }
    
}//end of class
