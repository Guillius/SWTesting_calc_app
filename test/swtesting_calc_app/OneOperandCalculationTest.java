
package swtesting_calc_app;

import static java.lang.Double.NaN;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class OneOperandCalculationTest {
    
    private final OneOperandCalculation sin90;
    private final OneOperandCalculation cos90;
    private final OneOperandCalculation tan90;
    private final OneOperandCalculation ln5;
    private final OneOperandCalculation invalid;
    
    public OneOperandCalculationTest() {
        
        sin90 = new OneOperandCalculation( "sin", 90 );
        cos90 = new OneOperandCalculation( "cos", 90 );
        tan90 = new OneOperandCalculation( "tan", 90 );
        ln5 = new OneOperandCalculation( "ln", 5 );
        invalid = new OneOperandCalculation( "inv", 4 );
        
        System.out.println( "OneOperandCalcTest: constructor done, created test Objects." );
    }
    
    @BeforeClass
    public static void setUpClass() {
        //System.out.println( "OneOperandCalcTest: @BeforeClass method." );
    }
    
    @AfterClass
    public static void tearDownClass() {
        //System.out.println( "OneOperandCalcTest: @AfterClass method." );
    }
    
    @Before
    public void setUp() {
        //System.out.println( "OneOperandCalcTest: @Before method." );
    }
    
    @After
    public void tearDown() {
        //System.out.println( "OneOperandCalcTest: @After method." );
    }

    /**
     * Test of getAnswer method, of class OneOperandCalculation.
     */
    @Test
    public void testGetAnswerOrError() {
        
        testExecute();  //first, execute all the Calculations
        
        assertEquals( 1.0, sin90.getAnswer(), 0.001 );
        assertEquals( 0.0, cos90.getAnswer(), 0.001 );
        //assertEquals( 1.0, tan90.getAnswer(), 0.001 );
        assertEquals( 1.6094, ln5.getAnswer(), 0.001 );
        assertEquals( 0.0, invalid.getAnswer(), 0.001 );
        
        //special case: the invalid one
        assertEquals( "Operator was not recognized by Calculation object.", invalid.getError() );
        
        System.out.println( "OneOperandCalcTest: testGetAnswerOrError() method." );
    }

    /**
     * Test of getAnswerVector method, of class OneOperandCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        
        assertEquals( null, sin90.getAnswerVector() );
        assertEquals( null, cos90.getAnswerVector() );
        assertEquals( null, tan90.getAnswerVector() );
        assertEquals( null, ln5.getAnswerVector() );
        assertEquals( null, invalid.getAnswerVector() );
        
        System.out.println( "OneOperandCalcTest: testGetAnswerVector() method." );
    }

    /**
     * Test of getOperand method, of class OneOperandCalculation.
     */
    @Test
    public void testGetOperand() {
        
        assertEquals( 90, sin90.getOperand(), 0.001 );
        assertEquals( 90, cos90.getOperand(), 0.001 );
        assertEquals( 90, tan90.getOperand(), 0.001 );
        assertEquals( 5, ln5.getOperand(), 0.001 );
        assertEquals( 4, invalid.getOperand(), 0.001 );
        assertEquals( 0, sin90.execute() );
        assertEquals( 90, sin90.getOperand(), 0.001 );
        
        System.out.println( "OneOperandCalcTest: testGetOperand() method." );
    }

    /**
     * Test of execute method, of class OneOperandCalculation.
     */
    @Test
    public void testExecute() {
            // 0 as return value means "executed normally"
        assertEquals( 0, sin90.execute() );
        assertEquals( 0, cos90.execute() );
        assertEquals( 0, tan90.execute() );
        assertEquals( 0, ln5.execute() );
        assertEquals( -1, invalid.execute() );
            
            //  extra test cases to achieve more coverage
        OneOperandCalculation naNSin = new OneOperandCalculation( "sin", NaN );
        OneOperandCalculation negInfCos = new OneOperandCalculation( "cos", NEGATIVE_INFINITY );
        OneOperandCalculation posInfTan = new OneOperandCalculation( "tan", POSITIVE_INFINITY );
        OneOperandCalculation zeroLn = new OneOperandCalculation( "ln", 0 );
        OneOperandCalculation negativeLn = new OneOperandCalculation( "ln", -1 );
        assertEquals( -1, naNSin.execute() );
        assertEquals( -1, negInfCos.execute() );
        assertEquals( -1, posInfTan.execute() );
        assertEquals( -1, zeroLn.execute() );
        assertEquals( -1, negativeLn.execute() );
        
        System.out.println( "OneOperandCalcTest: testExecute() method." );
    }

    /**
     * Test of toString method, of class OneOperandCalculation.
     */
    @Test
    public void testToString() {
        
        assertEquals( "sin 90.0", sin90.toString() );
        assertEquals( "cos 90.0", cos90.toString() );
//        assertEquals( "tan 90.0", tan90.toString() );
//        assertEquals( "ln 5.0", ln5.toString() );
        assertEquals( "inv 4.0", invalid.toString() );
        
        System.out.println( "OneOperandCalcTest: testToString() method." );
    }
    
}
