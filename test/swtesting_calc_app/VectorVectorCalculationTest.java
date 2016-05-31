
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
        
        dotCalc.execute();
        
        assertTrue( dotCalc.hasScalarAnswer() );
        assertEquals( -13.0, dotCalc.getAnswer(), 0.001 );
        
    }

    /**
     * Test of getAnswerVector method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        
        crossCalc.execute();
        
        assertNotNull( crossCalc.getAnswerVector() );
        
        double result[] = { -3.0, 3.0, 3.0 };
        
        assertArrayEquals( result, crossCalc.getAnswerVector(), 0.001 );
                
    }

    /**
     * Test of getFirstVectorOperand method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetFirstVectorOperand() {
        
        assertArrayEquals( firstVector, dotCalc.getFirstVectorOperand(), 0.001 );
        
    }

    /**
     * Test of getSecondVectorOperand method, of class VectorVectorCalculation.
     */
    @Test
    public void testGetSecondVectorOperand() {
                
        assertArrayEquals( secondVector, crossCalc.getSecondVectorOperand(), 0.001 );
        
    }

    /**
     * Test of hasScalarAnswer method, of class VectorVectorCalculation.
     */
    @Test
    public void testHasScalarAnswerCrossProduct(){
        assertFalse( crossCalc.hasScalarAnswer() );
        crossCalc.execute();
        assertFalse( crossCalc.hasScalarAnswer() );
    }
    
    @Test
    public void testHasScalarAnswerDotProduct(){
        assertFalse( dotCalc.hasScalarAnswer() );
        dotCalc.execute();
        assertTrue( dotCalc.hasScalarAnswer() );
    }

    /**
     * Test of execute method, of class VectorVectorCalculation.
     * 0 as return value means "executed normally", 1 means "vector answer"
     */
    @Test
    public void testExecuteDotProduct() {
        assertEquals( 0, dotCalc.execute() );
    }

    @Test
    public void testExecuteCrossProduct() {
        assertEquals( 1, crossCalc.execute() );
    }
/**
 * Extra...
 */
    @Test
    public void testExecutePlusVectors() {
        assertEquals( -1, new VectorVectorCalculation( "+", firstVector, secondVector ).execute() );
    }

    @Test
    public void testExecuteCrossFourElementVector() {
        double fourElementVector[] = {1.0,1.0,1.0,1.0};
        assertEquals( -1, new VectorVectorCalculation( "x",  firstVector, fourElementVector ).execute() );
    }

    @Test
    public void testExecuteDotFourElementVector() {
        double fourElementVector[] = {1.0,1.0,1.0,1.0};
        assertEquals( -1, new VectorVectorCalculation( ".",  firstVector, fourElementVector ).execute() );
    }

    /**
     * Test of toString method, of class VectorVectorCalculation.
     */
    @Test
    public void testToString() {
        
        assertEquals( "v(2;-1;3) x v(-1;2;-3)", crossCalc.toString() );
        
    }
    
}
