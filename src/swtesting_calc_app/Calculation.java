
package swtesting_calc_app;

/**
 *
 * @author Guillaume
 */

public abstract class Calculation {
    
    public abstract int execute();
    public abstract double getAnswer();
    public abstract double[] getAnswerVector();
    
//Only one of getAnswer or getAnswerVector should be truely implemented, the other one should throw an error or so...
    
    protected String operator;
    protected String error;
    
    public Calculation( String operator ){
        this.operator = operator;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }
    
    public String getError(){
        return error;
    }



}//end of class
