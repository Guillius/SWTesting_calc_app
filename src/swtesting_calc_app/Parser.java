
package swtesting_calc_app;

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
    public int parseInputString(String calcEntry){
        //NOT YET IMPLEMENTED
        return -1;
        
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

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}//end of class
