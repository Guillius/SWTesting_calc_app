
package swtesting_calc_app;

/**
 *
 * @author Guillaume
 */

public class TwoOperandCalculation extends Calculation {

    private final double firstOperand;
    private final double secondOperand;
    private double answer;
    
    public TwoOperandCalculation( String operator, double firstOperand, double secondOperand ){
        super( operator );
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    
    public double getAnswer(){
        return answer;
    }
    
    public double[] getAnswerVector(){
        /* @todo check for null in Parser! */
        return null;
    }

    /**
     * @return the firstOperand
     */
    public double getFirstOperand() {
        return firstOperand;
    }

    /**
     * @return the secondOperand
     */
    public double getSecondOperand() {
        return secondOperand;
    }
    
    /*
     * Executes the calculation specified by the TwoOperandCalculation object.
     * @todo implement this
     * @return 0 is calculation went successful, -1 if an error occurs.
     */
    public int execute(){
        //NOT YET IMPLEMENTED
        //needs a switch statement based on operator
        return -1;
    }
    
}//end of class
