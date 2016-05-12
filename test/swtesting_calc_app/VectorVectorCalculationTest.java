
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
public class VectorVectorCalculationTest {
    
    private final VectorVectorCalculation dotCalc;
    private final VectorVectorCalculation crossCalc;
    private final double firstVector[] = { 2.0, -1.0, 3.0 };
    private final double secondVector[] = { -1.0, 2.0, -3.0 };
    
    public VectorVectorCalculationTest() {
      
        dotCalc = new VectorVectorCalculation( ".", firstVector, secondVector );
        crossCalc = new VectorVectorCalculation( "x", firstVector, secondVector );
        
        System.out.println( "VectorVectorCalcTest: constructor done, created test Objects." );
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
     * Test of getAnswer method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetAnswer() {
        
        testExecute();
        
        assertTrue( dotCalc.hasScalarAnswer() );
        assertEquals( -13.0, dotCalc.getAnswer(), 0.001 );
        
        System.out.println( "VectorVectorCalcTest: testGetAnswer() method." );
    }

    /**
     * Test of getAnswerVector method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        
        testExecute();
        
        assertNotNull( crossCalc.getAnswerVector() );
        
        double result[] = { -3.0, 3.0, 3.0 };
        
        assertEquals( result.length, crossCalc.getAnswerVector().length );
        
        for( int i=0; i<result.length; i++ ){
            assertEquals( result[i], crossCalc.getAnswerVector()[i], 0.001 );
        }
        
        System.out.println( "VectorVectorCalcTest: testGetAnswerVector() method." );
    }

    /**
     * Test of getFirstVectorOperand method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetFirstVectorOperand() {
        
        double result[] = { 2.0, -1.0, 3.0 };
        
        assertEquals( result.length, crossCalc.getFirstVectorOperand().length );
        
        for( int i=0; i<result.length; i++ ){
            assertEquals( result[i], crossCalc.getFirstVectorOperand()[i], 0.001 );
        }
        
        System.out.println( "VectorVectorCalcTest: testGetFirstOperand() method." );
    }

    /**
     * Test of getSecondVectorOperand method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetSecondVectorOperand() {
        
        double result[] = { -1.0, 2.0, -3.0 };
        
        assertEquals( result.length, dotCalc.getSecondVectorOperand().length );
        
        for( int i=0; i<result.length; i++ ){
            assertEquals( result[i], dotCalc.getSecondVectorOperand()[i], 0.001 );
        }
        
        System.out.println( "VectorVectorCalcTest: testGetSecondOperand() method." );
    }

    /**
     * Test of hasScalarAnswer method, of class VectorVectorCalculation.
     */
    @Test
    public void testHasScalarAnswer() {
     
        assertFalse( dotCalc.hasScalarAnswer() );
        assertFalse( crossCalc.hasScalarAnswer() );
        
        testExecute();
        
        assertTrue( dotCalc.hasScalarAnswer() );
        assertFalse( crossCalc.hasScalarAnswer() );
        
        System.out.println( "VectorVectorCalcTest: testHasScalarAnswer() method." );        
    }

    /**
     * Test of execute method, of class VectorVectorCalculation.
     */
    @Test
    public void testExecute() {
            // 0 as return value means "executed normally", 1 means "vector answer"
        assertEquals( 0, dotCalc.execute() );
        assertEquals( 1, crossCalc.execute() );
        
        //extra
        double fourElementVector[] = {1.0,1.0,1.0,1.0};
        assertEquals( -1, new VectorVectorCalculation( "+", firstVector, secondVector ).execute() );
        assertEquals( -1, new VectorVectorCalculation( "x",  firstVector, fourElementVector ).execute() );
        assertEquals( -1, new VectorVectorCalculation( ".",  firstVector, fourElementVector ).execute() );
                
        System.out.println( "VectorVectorCalcTest: testExecute() method." );
    }

    /**
     * Test of toString method, of class VectorVectorCalculation.
     */
    @Test
    public void testToString() {
        
        assertEquals( "v(2;-1;3) x v(-1;2;-3)", crossCalc.toString() );
        
        System.out.println( "VectorVectorCalcTest: testToString() method." );
    }
    
}
