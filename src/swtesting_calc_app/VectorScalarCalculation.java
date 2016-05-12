
package swtesting_calc_app;

import java.text.DecimalFormat;

/**
 *
 * @author Guillaume
 */

public class VectorScalarCalculation extends Calculation {
    
    private final double scalar;
    private final double[] vector;
    private double[] answer;
    
    public VectorScalarCalculation( String operator, double[] vector, double scalar ){
        super( operator );
        this.vector = vector;
        this.scalar = scalar;
    }
    
    public double getAnswer(){
        return 0.0;
    }
    
    public double[] getAnswerVector(){
        return answer;
    }

    /**
     * @return the scalar
     */
    public double getScalar() {
        return scalar;
    }

    /**
     * @return the vector
     */
    public double[] getVector() {
        return vector;
    }
    
    /**
     * Executes the VectorScalar Calculation.
     * @return 0 is calculation went successful, -1 if an error of some kind occured, 1 if answer is a vector.
     */
    public int execute(){
        
        if( !operator.equals(".") && !operator.equals("*") ){
            error = "operator must be '.' or '*' for this type of Calculation.";
            return -1;
        }
        
        
        answer = new double[ vector.length ];  //to get rid of the "null" for answer + answer has the right length instantly
        
        for( int i=0; i<vector.length; i++ ){
            answer[i] = vector[i]*scalar;
        }
        
        return 1;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("v(");
        DecimalFormat answerFormat = new DecimalFormat( "0.##" );
        
        for( int i=0; i<vector.length; i++){
            sb.append( answerFormat.format( vector[i]) );
            if(i != vector.length-1) sb.append(";");
            else sb.append(") ");
        }
        
        sb.append( operator );
        sb.append( " " + scalar );
        
        return sb.toString();        
    }
    
}//end of class
