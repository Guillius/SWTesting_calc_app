
package swtesting_calc_app;

import java.io.*;
import java.text.DecimalFormat;
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
       BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
       String input = "";
       DecimalFormat answerFormat = new DecimalFormat( "0.##" );
       
       System.out.println("Welcome to this simple calculator application.");
       System.out.println("Before you start your calculations, here's how to format your problems so the application can interpret them:");
       System.out.println("\t" + "1.ALWAYS use a space to separate an operator from one or more operands.");
       System.out.println("\t" + "2.NEVER use spaces ANYWHERE ELSE in your input.");
       System.out.println("\t" + "3. use \"v(x,y,z)\" to specify a vector with elements x,y and z as an operand.");
       System.out.println("Some example inputs:");
       int result = parser.parseInputString( "5.2 + 13" );
       System.out.println("\t" + "5.2 + 3" + "\t" + "= " + answerFormat.format( parser.getLastAnswer() ) );
       result = parser.parseInputString( "15 mod 4" );
       System.out.println("\t" + "15 mod 4" + "\t" + "= " + answerFormat.format( parser.getLastAnswer() ) );
       result = parser.parseInputString( "v(1,2,-3) . 5" );
       System.out.println("\t" + "v(1,2,-3) . 5" + "\t" + "= " + cli.formatVector(parser.getLastVectorAnswer() ) );
       System.out.println("Use \"h\" to recall the previous calculation(s).\nTry it yourself! If you want to exit the application, use \"exit\".");
       
       int counter = 0;
       
       while( true ){
        try{
            input = reader.readLine();
        } catch( Exception e ){
            e.printStackTrace();
       }
        
        if( input.equals( "exit" ) ) break;
        
        if( input.equals( "h" ) ) {
            counter++;
            Calculation history = cli.getPreviousHistoryEntry( counter );
            if( history == null ){
                System.out.println( "History ended." );
            }
            else{
                System.out.println( history.toString() );
                System.out.print( "= " );
                result = history.execute();
                if( result == 0 ) System.out.println( answerFormat.format( history.getAnswer() ) );
                if( result == 1 ) System.out.println( cli.formatVector( history.getAnswerVector() ) );
            }
        }
        else {
            counter = 0;
            result = parser.parseInputString( input );
            if( result < 0 ) System.out.println( "ERROR:\n\t" + parser.getErrorMessage() );
            else if( result == 0 ) System.out.println( "= " + answerFormat.format(parser.getLastAnswer() ) );
            else if( result == 1 ) System.out.println( "= " + cli.formatVector( parser.getLastVectorAnswer() ) );
        }
     }
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
    
    public Calculation getPreviousHistoryEntry( int counter ){
        if( counter > history.size() ) return null;
        return history.get( history.size()-counter );
    }
    
//    public void getNextHistoryEntry(){
//        /* @todo implement this */
//    }
    
    private String formatVector( double[] vector ){
        StringBuilder sb = new StringBuilder("[");
        DecimalFormat answerFormat = new DecimalFormat( "0.##" );
        
        for( int i=0; i<vector.length; i++){
            sb.append( answerFormat.format(vector[i]) );
            if(i != vector.length-1) sb.append(";");
            else sb.append("]");
        }
        
        return sb.toString();
    }
    
}
