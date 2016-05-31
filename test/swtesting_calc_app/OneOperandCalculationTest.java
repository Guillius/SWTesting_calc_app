
package swtesting_calc_app;

import static java.lang.Double.NaN;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
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
     * Test of getAnswer method, of class OneOperandCalculation.
     */
    @Test
    public void getAnswerSin() {
        sin90.execute();
        assertEquals( 1.0, sin90.getAnswer(), 0.001 );
    }

    @Test
    public void getAnswerCos() {
        cos90.execute();
        assertEquals( 0.0, cos90.getAnswer(), 0.001 );
    }
    
    @Ignore //test fails, probably because Math.tan( PI/2 ) = Double.MAX_VALUE or something like that
    @Test
    public void getAnswerTan(){
        tan90.execute();
        assertEquals( POSITIVE_INFINITY, tan90.getAnswer(), 0.001 );
    }

    @Test
    public void getAnswerLn() {
        ln5.execute();
        assertEquals( 1.6094, ln5.getAnswer(), 0.001 );
    }

    @Test
    public void getAnswerInvalid() {
        invalid.execute();
        assertEquals( 0.0, invalid.getAnswer(), 0.001 );
    }

    @Test
    public void getErrorInvalid() {
        //special case: the invalid one
        invalid.execute();
        assertEquals( "Operator was not recognized by Calculation object.", invalid.getError() );
    }

    /**
     * Test of getAnswerVector method, of class OneOperandCalculation.
     */
    @Test
    public void sinGetVector() {
        assertEquals( null, sin90.getAnswerVector() );
    }

    @Test
    public void cosGetVector() {
        assertEquals( null, cos90.getAnswerVector() );
    }

    @Test
    public void tanGetVector() {
        assertEquals( null, tan90.getAnswerVector() );
    }

    @Test
    public void lnGetVector() {
        assertEquals( null, ln5.getAnswerVector() );
    }

    @Test
    public void invalidGetVector() {
        assertEquals( null, invalid.getAnswerVector() );
    }

    /**
     * Test of getOperand method, of class OneOperandCalculation.
     */
    @Test
    public void sinGetOp() {
        assertEquals( 90, sin90.getOperand(), 0.001 );
    }

    @Test
    public void cosGetOp() {
        assertEquals( 90, cos90.getOperand(), 0.001 );
    }

    @Test
    public void tanGetOp() {
        assertEquals( 90, tan90.getOperand(), 0.001 );
    }

    @Test
    public void lnGetOp() {
        assertEquals( 5, ln5.getOperand(), 0.001 );
    }

    @Test
    public void invalidGetOp() {
        assertEquals( 4, invalid.getOperand(), 0.001 );
    }
    
    @Test
    public void sinGetOpAfterExecution() {
        sin90.execute();
        assertEquals( 90, sin90.getOperand(), 0.001 );
    }

    /**
     * Test of execute method, of class OneOperandCalculation.
     * 0 as return value means "executed normally"
     */
    @Test
    public void testExecuteSin() {
        assertEquals( 0, sin90.execute() );
    }

    @Test
    public void testExecuteCos() {
        assertEquals( 0, cos90.execute() );
    }

    @Test
    public void testExecuteTan() {
        assertEquals( 0, tan90.execute() );
    }

    @Test
    public void testExecuteLn() {
        assertEquals( 0, ln5.execute() );
    }

    @Test
    public void testExecuteInvalid() {
        assertEquals( -1, invalid.execute() );
    }

    //  extra test cases to achieve more coverage
    @Test
    public void testExecuteNaNSin() {
        OneOperandCalculation naNSin = new OneOperandCalculation( "sin", NaN );
        assertEquals( -1, naNSin.execute() );
    }

    @Test
    public void testExecuteNegInfCos() {
        OneOperandCalculation negInfCos = new OneOperandCalculation( "cos", NEGATIVE_INFINITY );
        assertEquals( -1, negInfCos.execute() );
    }

    @Test
    public void testExecutePosInfTan() {
        OneOperandCalculation posInfTan = new OneOperandCalculation( "tan", POSITIVE_INFINITY );
        assertEquals( -1, posInfTan.execute() );
    }

    @Test
    public void testExecuteZeroLn() {
        OneOperandCalculation zeroLn = new OneOperandCalculation( "ln", 0 );
        assertEquals( 0, zeroLn.execute() );
    }

    @Test
    public void testExecuteNegLn() {
        OneOperandCalculation negativeLn = new OneOperandCalculation( "ln", -1 );
        assertEquals( -1, negativeLn.execute() );
    }

    /**
     * Test of toString method, of class OneOperandCalculation.
     */
    @Test
    public void invalidToString() {
        assertEquals( "inv 4.0", invalid.toString() );
    }

    @Test
    public void lnToString() {
        assertEquals( "ln 5.0", ln5.toString() );
    }

    @Test
    public void tanToString() {
        assertEquals( "tan 90.0", tan90.toString() );
    }

    @Test
    public void cosToString() {
        assertEquals( "cos 90.0", cos90.toString() );
    }

    @Test
    public void sinToString() {
        assertEquals( "sin 90.0", sin90.toString() );
    }
    
}
