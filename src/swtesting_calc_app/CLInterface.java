
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
}
