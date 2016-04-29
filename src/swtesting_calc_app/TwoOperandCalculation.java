
package swtesting_calc_app;

import java.text.DecimalFormat;

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
     * @return 0 is calculation went successful, -1 if an error occurs.
     */
    public int execute(){
        
        int status = -1;
        
        switch( operator ){
            case "+":   answer = firstOperand + secondOperand;
                        status = 0;
                        break;
            case "-":   answer = firstOperand - secondOperand;
                        status = 0;
                        break;
            case ".":   answer = firstOperand * secondOperand;
                        status = 0;
                        break;
            case "/":   
                        if( secondOperand != 0.0 ){
                            answer = firstOperand / secondOperand;
                            status = 0;
                        } else {
                            status = -1;
                            error = "Divide by zero.";
                        }
                        break;
            case "^":   answer = Math.pow( firstOperand, secondOperand );
                        status = 0;
                        if( Double.isNaN( answer ) ){
                            status = -1;
                            error = "One operand is 'NaN' or another invalid condition Math.pow() applies.";
                        } else if( secondOperand <= 0.0 && firstOperand == 0.0 ){
                            status = -1;
                            error = "Trying to raise 0 to a negative power, this leads to a Division by zero!";
                        }
                        break;
            case "V":
            case "\u221A":  //Unicode character for square root
                            if( secondOperand == 2.0 ){
                                answer = Math.sqrt( firstOperand );
                                status = 0;
                            }else if( secondOperand == 3.0 ){
                                answer = Math.cbrt( firstOperand );
                                status = 0;
                            } else{
                                answer = Math.pow( firstOperand, 1/secondOperand);
                                status = 0;
                            }
                            
                            if( Double.isNaN( answer ) ){
                                error = "First operand was NaN.";
                                status = -1;
                            } else if( Double.isInfinite( answer ) ){
                                error = "First operand is Inf.";
                                status = -1;
                            }
                            
                            break;
            case "log": answer = Math.log( firstOperand ) / Math.log( secondOperand ); //change of base formula
                        status = 0;
                        break;
            case "mod": 
                        try{
                            answer = firstOperand % secondOperand;
                            status = 0;
                        } catch ( ArithmeticException ae ){
                            error = "You probably tried 'n mod 0'.";
                            status = -1;
                        }
                        break;
            default:    status = -1;
                        error = "Operator was not recognized by Calculation object.";
                        break;
        }                                                    
        
        return status;
    }
    
        public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append( firstOperand );
        sb.append( " ");
        sb.append( operator );
        sb.append( " " );
        sb.append( secondOperand );
        
        return sb.toString();        
    }
    
}//end of class
