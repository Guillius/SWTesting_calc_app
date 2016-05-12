
package swtesting_calc_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class CalculationTest {
   
    private final OneOperandCalculation testObject;
    
    public CalculationTest() {
        
        testObject = new OneOperandCalculation( "sin", 45.0 );
        
        System.out.println( "CalculationTest: constructor done, created test Object." );
    }
    
    /**
     * Test of getOperator method, of class Calculation.
     */
    @Test
    public void testGetOperator() {
        
        assertEquals( "sin", testObject.getOperator() );
        
        System.out.println( "CalculationTest: testGetOperator() method." );
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
