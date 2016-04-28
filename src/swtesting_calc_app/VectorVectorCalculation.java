
package swtesting_calc_app;

/**
 *
 * @author Guillaume
 */

public class VectorVectorCalculation extends Calculation {

    private final double[] firstVectorOperand;
    private final double[] secondVectorOperand;
    private double scalarAnswer;
    private double[] vectorAnswer = new double[3];
    private boolean flagScalarAnswer;
    
    public VectorVectorCalculation( String operator, double[] firstVector, double[] secondVector ){
        super( operator );
        this.firstVectorOperand = firstVector;
        this.secondVectorOperand = secondVector;
    }

    public double getAnswer(){
        return scalarAnswer;
    }
    
    public double[] getAnswerVector(){
        return vectorAnswer;
    }    
    
    /**
     * @return the firstVectorOperand
     */
    public double[] getFirstVectorOperand() {
        return firstVectorOperand;
    }

    /**
     * @return the secondVectorOperand
     */
    public double[] getSecondVectorOperand() {
        return secondVectorOperand;
    }

    /**
     * @return the flagScalarAnswer
     */
    public boolean hasScalarAnswer() {
        return flagScalarAnswer;
    }
    
    /**
     * Executes the calculation as specified by this VectorVectorCalculation object
     * @todo implement this
     * @return 0 is calculation went successful, -1 if an error of some kind occured.
     */
    public int execute(){
        //flag is set in the private methods if they execute successfully
        int status = -1;
        
        switch( operator ){
            case ".":   status = dotProduct();
                        break;
            case "x":   status = crossProduct();
                        break;
            default:    status = -1;
                        error = "Operator was not recognized by Calculation object.";
                        break;
        }
        
        return status;        
    }
    
    /**
     * Implements a dot product calculation according to the algebraic definition.
     * @return 0 if successful, -1 if unsuccessful
     */
    private int dotProduct(){
        //don't forget to set the flag!
        
        if( firstVectorOperand.length != secondVectorOperand.length ){
            error = "Size of the vectors must be equal to perform dot product calculation.";
            return -1;
        } else{
            double temp = 0.0;
            
            for( int i=0; i<firstVectorOperand.length; i++){
                temp += firstVectorOperand[i]*secondVectorOperand[i];
            }
            scalarAnswer = temp;
            flagScalarAnswer = true;
        }
        return 0;
    }
    
    /**
     * Implements the cross product calculation.
     * @return 0 if successful, -1 if unsuccessful
     */
    private int crossProduct(){
        //don't forget to set the flag!
        
        if( firstVectorOperand.length == secondVectorOperand.length && firstVectorOperand.length == 3 ){
            error = "Size of the vectors must be exactly 3 for each one.";
            return -1;
        } else{
            double[] tempVector = new double[3];
            int n1, n2;
            
            for( int i=0; i<3; i++){
                n1 = (i+1) % 3;
                n2 = (i+2) % 3;
                tempVector[i] = firstVectorOperand[n1]*secondVectorOperand[n2] - firstVectorOperand[n2]*secondVectorOperand[n1];
            }
            vectorAnswer = tempVector;
            flagScalarAnswer = false;
            return 0;
        }
    }
    
}//end of class
