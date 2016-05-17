
package swtesting_calc_app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class ReqBasedVectorScalar {
    
    public ReqBasedVectorScalar(){
    
    }

    @Test
    public void testArrayDoubleAssert(){
    //mainly to use my extension of the Assert class
        double[] vector = {-2, 3, 0, -1.5};
        double[] answer = {(-2*-3.33), (3*-3.33), (0*-3.33), (-1.5*-3.33)};
        
        VectorScalarCalculation test = new VectorScalarCalculation(".", vector, -3.33 );
        assertEquals( 1, test.execute());
        assertArrayEquals( answer, test.getAnswerVector(), 0.001 );
        
    }
    
}//end of class
