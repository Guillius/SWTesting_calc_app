
package swtesting_calc_app;

/**
 *
 * @author Guillaume
 */

public class VectorVectorCalculation extends Calculation {

    private final double[] firstVectorOperand;
    private final double[] secondVectorOperand;
    private double scalarAnswer;
    private double[] vectorAnswer;
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
        //NOT YET IMPLEMENTED
        //  don't forget to set the flag!
        return -1;
    }
    
}//end of class
