
package swtesting_calc_app;

import org.junit.Test;
import swtesting_calc_app.Calculation;
import swtesting_calc_app.OneOperandCalculation;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class CalculationTest {
   
    private final OneOperandCalculation testObject;
    
    public CalculationTest() {
        
        testObject = new OneOperandCalculation( "sin", 45.0 );
        
    }
    
    /**
     * Test of getOperator method, of class Calculation.
     */
    @Test
    public void testGetOperator() {
        
        assertEquals( "sin", testObject.getOperator() );
        
    }

    public class CalculationImpl extends Calculation {

        public CalculationImpl() {
            super("");
        }

        public int execute() {
            return 0;
        }

        public double getAnswer() {
            return 0.0;
        }

        public double[] getAnswerVector() {
            return null;
        }
    }
    
}
