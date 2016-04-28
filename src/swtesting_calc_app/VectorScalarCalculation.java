
package swtesting_calc_app;

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
     * @todo implement this
     * @return 0 is calculation went successful, -1 if an error of some kind occured.
     */
    public int execute(){
        
        for( int i=0; i<vector.length; i++ ){
            answer[i] = vector[i]*scalar;
        }
        
        return 0;
    }
    
}//end of class
