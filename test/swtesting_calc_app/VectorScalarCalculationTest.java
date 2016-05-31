
package swtesting_calc_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swtesting_calc_app.VectorScalarCalculation;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class VectorScalarCalculationTest {
    
    private final VectorScalarCalculation test1Calc;
    private final VectorScalarCalculation test2Calc;

    private final double vector[] = {4.0, 5.5, 1.4, -2.1};
    
    public VectorScalarCalculationTest() {
        
        test1Calc = new VectorScalarCalculation( ".", vector , 4 );
        test2Calc = new VectorScalarCalculation( "*", vector, 2.0 );
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAnswer method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetAnswer_1() {
        test1Calc.execute();
        assertEquals( 0.0, test1Calc.getAnswer(), 0.001 );
    }

    @Test
    public void testGetAnswer_2() {
        test2Calc.execute();
        assertEquals( 0.0, test2Calc.getAnswer(), 0.001 );
    }

    /**
     * Test of getAnswerVector method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetAnswerVector_1() {
        test1Calc.execute();
        assertNotNull( test1Calc.getAnswerVector() );
        double result1[] = {16.0, 22.0, 5.6, -8.4 };
        assertArrayEquals( result1, test1Calc.getAnswerVector(), 0.001 );
    }

    @Test
    public void testGetAnswerVector_2() {
        test2Calc.execute();
        assertNotNull( test2Calc.getAnswerVector() );
        double result2[] = { 8.0, 11.0, 2.8, -4.2 };
        assertArrayEquals( result2, test2Calc.getAnswerVector(), 0.001 );
    }

    /**
     * Test of getScalar method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetScalar_1() {
        assertEquals( 4.0, test1Calc.getScalar(), 0.001 );
    }

    @Test
    public void testGetScalar_2() {
        assertEquals( 2.0, test2Calc.getScalar(), 0.001 );
    }

    /**
     * Test of getVector method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetVector_1() {
        assertNotNull( test1Calc.getVector() );
        assertArrayEquals( vector, test1Calc.getVector(), 0.001 );
    }

    @Test
    public void testGetVector_2() {
        assertNotNull( test2Calc.getVector() );
        assertArrayEquals( vector, test2Calc.getVector(), 0.001 );
    }

    /**
     * Test of execute method, of class VectorScalarCalculation.
     * 0 means "executed normally", 1 means "vector answer"
     */
    @Test
    public void testExecute_1() {
        assertEquals( 1, test1Calc.execute() );
    }

    @Test
    public void testExecute_2() {
        assertEquals( 1, test2Calc.execute() );
    }

    @Test
    public void testExecuteInvalidOperator() {
        double vect[] = {3, 4, 5};
        
        VectorScalarCalculation v = new VectorScalarCalculation( "+", vect, 2.0 );
        
        assertEquals( -1,  v.execute() );
    }

    /**
     * Test of toString method, of class VectorScalarCalculation.
     */
    @Test
    public void testToString() {
        assertEquals( "v(4;5,5;1,4;-2,1) . 4.0", test1Calc.toString() );
    }
    
}
