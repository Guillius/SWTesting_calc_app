
package swtesting_calc_app;

/**
 *
 * @author Guillaume
 */

public class OneOperandCalculation extends Calculation {

    private final double operand;
    private double answer;
    
    public OneOperandCalculation( String operator, double operand  ){
        super( operator );
        this.operand = operand;
    }
    
    public double getAnswer(){
        return answer;
    }
    
    public double[] getAnswerVector(){
        /* @todo check for null in Parser! */
        return null;
    }
    
    /**
     * 
     * @return the operand
     */
    public double getOperand(){
        return operand;
    }
    
    /**
     * Executes the calculation specified by this OneOperandCalculation object.
     * @todo implement this
     * @return 0 is calculation went successful, -1 if an error of some kind occured. 
     */
    public int execute(){
        //NOT YET IMPLEMENTED
        //needs a switch statement based on operator
        return -1;
    }
    
}//end of class
