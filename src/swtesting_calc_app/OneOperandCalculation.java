
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
     * @return 0 is calculation went successful, -1 if an error of some kind occured. 
     */
    public int execute(){
        
        int status = -1;
        
        switch( operator ){
            case "sin": answer = Math.sin( (operand/360.0)*2*Math.PI );
                        status = 0;
                        if( Double.isNaN( answer ) ){
                            status = -1;
                            error = "Operand was NaN or an infinity.";
                        }
                        break;
            case "cos": answer = Math.cos( (operand/360.0)*2*Math.PI );
                        status = 0;
                        if( Double.isNaN( answer ) ){
                            status = -1;
                            error = "Operand was NaN or an infinity.";
                        }
                        break;
            case "tan": answer = Math.tan( (operand/360.0)*2*Math.PI );
                        status = 0;
                        if( Double.isNaN( answer ) ){
                            status = -1;
                            error = "Operand was NaN or an infinity.";
                        }
                        break;
            case "ln":  answer = Math.log( operand );
                        status = 0;
                        if (Double.isNaN( answer ) ){
                            status = -1;
                            error = "Operand was NaN or less than zero.";
                        } else if ( Double.isInfinite( answer ) ){
                            status = -1;
                            error = "Operand was pos_Inf or zero.";
                        }
                        break;
            default:    status = -1;
                        error = "Operator was not recognized by Calculation object.";
                        break;
        }
        
        return status;
    }
    
}//end of class
