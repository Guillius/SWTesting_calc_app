
package swtesting_calc_app;

import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;
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
    private CLInterface cli;

    public Parser(CLInterface mainProgram) {
        this.cli = mainProgram;
        this.errorMessage = "";
        this.lastAnswer = 0.0;
    }
    
    /**
     * @todo implement parsing the inputstring => regex/split...
     * @return returns 0 if successful, -1 in case of an error
     */
    public int parseInputString(String input){
        
        int status = -1;
        
        Calculation calculationObj;
        
        String parts[] = input.split( " " );
        
        /* Filters out empty Strings from parts[]
        in case the input has two spaces next to each other,
        which would lead to an empty String in the parts[] array.
        */
        List<String> list = new ArrayList<>();
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
        
        //execute the calculation object and deal with 0 of -1 as return value
            /* @todo implement this */
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
        /* @todo implement this
            NOT  YET IMPLEMENTED
            @todo still test the implementation for this method!
        */
        return null;
    }
    
}//end of class
