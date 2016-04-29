
package swtesting_calc_app;

import java.util.ArrayList;

/**
 *
 * @author Guillaume
 */

public class CLInterface {
    
    private static ArrayList<Calculation> history;
    private static Parser parser;


    public static void main(String[] args) {
        
       CLInterface cli = new CLInterface();
        
    }
    
    public CLInterface(){
        this.parser = new Parser( this );
        this.history = new ArrayList<Calculation>();
    }
    
    /**
     * Adds the Calculation object to the end of the history ArrayList.
     * @param calculationObj the object to append
     */
    public void addToHistory( Calculation calculationObj ){
        history.add( calculationObj );
    }
    
    public void getPreviousHistoryEntry(){
        /* @todo implement this */
    }
    
    public void getNextHistoryEntry(){
        /* @todo implement this */
    }
}
