
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
public class VectorScalarCalculationTest {
    
    private final VectorScalarCalculation test1Calc;
    private final VectorScalarCalculation test2Calc;
    
    public VectorScalarCalculationTest() {
        
        double vector[] =  {4.0, 5.5, 1.4, -2.1};
        
        test1Calc = new VectorScalarCalculation( ".", vector , 4 );
        test2Calc = new VectorScalarCalculation( "*", vector, 2.0 );
        
        System.out.println( "VectorScalarCalcTest: constructor done, created test Objects." );
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
    public void testGetAnswer() {
        
        testExecute();
        
        assertEquals( 0.0, test1Calc.getAnswer(), 0.001 );
        assertEquals( 0.0, test2Calc.getAnswer(), 0.001 );
                
        System.out.println( "VectorScalarCalcTest: testGetAnswer() method." );
    }

    /**
     * Test of getAnswerVector method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        
        testExecute();
        
        assertNotNull( test1Calc.getAnswerVector() );
        assertNotNull( test2Calc.getAnswerVector() );
        
        double result1[] = {16.0, 22.0, 5.6, -8.4 };
        double result2[] = { 8.0, 11.0, 2.8, -4.2 };
        
    //there is no way to AssertArrayEquals with double arrays...
        assertEquals( result1.length, test1Calc.getAnswerVector().length);
        assertEquals( result2.length, test2Calc.getAnswerVector().length);
        
        assertEquals( result1.length, result2.length );
        
        for( int i=0; i<result1.length; i++ ){
            assertEquals( result1[i], test1Calc.getAnswerVector()[i], 0.001 );
            assertEquals( result2[i], test2Calc.getAnswerVector()[i], 0.001 );
        }
        
        System.out.println( "VectorScalarCalcTest: testGetAnswerVector() method." );
    }

    /**
     * Test of getScalar method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetScalar() {
        
        assertEquals( 4.0, test1Calc.getScalar(), 0.001 );
        assertEquals( 2.0, test2Calc.getScalar(), 0.001 );
                
        System.out.println( "VectorScalarCalcTest: testGetScalar() method." );
    }

    /**
     * Test of getVector method, of class VectorScalarCalculation.
     */
    @Test
    public void testGetVector() {
        
        assertNotNull( test1Calc.getVector() );
        assertNotNull( test2Calc.getVector() );
        
        double result[] = { 4.0, 5.5, 1.4, -2.1 };
        
        assertEquals( result.length, test1Calc.getVector().length );
        assertEquals(result.length, test2Calc.getVector().length );
        
        for( int i=0; i<result.length; i++ ){
            assertEquals( result[i], test1Calc.getVector()[i], 0.001 );
            assertEquals( result[i], test2Calc.getVector()[i], 0.001 );
        }
                
        System.out.println( "VectorScalarCalcTest: testGetVector() method." );
    }

    /**
     * Test of execute method, of class VectorScalarCalculation.
     */
    @Test
    public void testExecute() {
            //0 means "executed normally", 1 means "vector answer"
        assertEquals( 1, test1Calc.execute() );
        assertEquals( 1, test2Calc.execute() );
        
        double vect[] = {3, 4, 5};
        
        VectorScalarCalculation v = new VectorScalarCalculation( "+", vect, 2.0 );
        
        assertEquals( -1,  v.execute() );
        
        System.out.println( "VectorScalarCalcTest: testExecute() method." );
    }

    /**
     * Test of toString method, of class VectorScalarCalculation.
     */
    @Test
    public void testToString() {
        
        assertEquals( "v(4;5,5;1,4;-2,1) . 4.0", test1Calc.toString() );
        
        System.out.println( "VectorScalarCalcTest: testToString() method." );
    }
    
}
