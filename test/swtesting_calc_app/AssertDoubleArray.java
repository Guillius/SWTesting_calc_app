
package swtesting_calc_app;

import org.junit.Assert;

/**
 *
 * @author Guillaume
 */
public class AssertDoubleArray extends Assert{
    
    public static void assertArrayEquals( double[] expecteds, double[] actuals, double delta ){
        
        assertEquals( expecteds.length, actuals.length);
        
        for( int i=0; i<expecteds.length; i++ ){
            assertEquals( expecteds[i], actuals[i], delta );
        }
    
    }

}//end of class
