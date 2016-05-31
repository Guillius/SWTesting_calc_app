
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
public class TwoOperandCalculationTest {
    
    private final TwoOperandCalculation plus;
    private final TwoOperandCalculation minus;
    private final TwoOperandCalculation multiply;
    private final TwoOperandCalculation divide;
    private final TwoOperandCalculation power;
    private final TwoOperandCalculation root;
    private final TwoOperandCalculation sqrt;
    private final TwoOperandCalculation log;
    private final TwoOperandCalculation mod;
    
    private final double FIRST = 5;
    private final double SECOND = 2;
    
    public TwoOperandCalculationTest() {
        
        plus = new TwoOperandCalculation( "+", FIRST, SECOND );
        minus = new TwoOperandCalculation( "-", FIRST, SECOND );
        multiply = new TwoOperandCalculation( "*", FIRST, SECOND );
        divide = new TwoOperandCalculation( "/", FIRST, SECOND );
        power = new TwoOperandCalculation( "^", FIRST, SECOND );
        root = new TwoOperandCalculation( "V", FIRST, SECOND );
        sqrt = new TwoOperandCalculation( "\u221A", SECOND, FIRST );
        log = new TwoOperandCalculation( "log", FIRST, SECOND );
        mod = new TwoOperandCalculation( "mod", FIRST, SECOND );
        
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
     * Test of getAnswer method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetAnswerPlus() {
        plus.execute();
        assertEquals( 7.0 , plus.getAnswer(), 0.001 );
    }

    @Test
    public void testGetAnswerMinus() {
        minus.execute();
        assertEquals( 3.0 , minus.getAnswer(), 0.001 );
    }

    @Test
    public void testGetAnswerMultiply() {
        multiply.execute();
        assertEquals( 10.0 , multiply.getAnswer(), 0.001 );
    }

    @Test
    public void testGetAnswerDivide() {
        divide.execute();
        assertEquals( 2.5 , divide.getAnswer(), 0.001 );
    }

    /**
     * Test of getAnswerVector method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        assertEquals( null, multiply.getAnswerVector() );
    }

    /**
     * Test of getFirstOperand method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetFirstOperand() {
        assertEquals( 5.0, minus.getFirstOperand(), 0.001 );
    }

    /**
     * Test of getSecondOperand method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetSecondOperand() {
        assertEquals( 2.0, plus.getSecondOperand(), 0.001 );
    }

    /**
     * Test of execute method, of class TwoOperandCalculation.
     * 0 as return value means "executed normally"
     */
    @Test
    public void testExecutePlus() {
        assertEquals( 0, plus.execute() );
    }

    @Test
    public void testExecuteMinus() {
        assertEquals( 0, minus.execute() );
    }

    @Test
    public void testExecuteMultiply() {
        assertEquals( 0, multiply.execute() );
    }

    @Test
    public void testExecuteDivide() {
        assertEquals( 0, divide.execute() );
    }

    @Test
    public void testExecutePower() {
        assertEquals( 0, power.execute() );
    }

    @Test
    public void testExecuteRoot() {
        assertEquals( 0, root.execute() );
    }

    @Test
    public void testExecuteSqrt() {
        assertEquals( 0, sqrt.execute() );
    }

    @Test
    public void testExecuteLog() {
        assertEquals( 0, log.execute() );
    }

    @Test
    public void testExecuteMod() {
        assertEquals( 0, mod.execute() );
    }

    /**
     * extra test cases to achieve more coverage
     */
    @Test
    public void divByZero() {
        TwoOperandCalculation divByZero = new TwoOperandCalculation( "/", SECOND, 0 );
        assertEquals( -1, divByZero.execute() );
    }

    @Test
    public void powerWithExponentNaN() {
        TwoOperandCalculation naNPow = new TwoOperandCalculation( "^", FIRST, Double.NaN );
        assertEquals( -1, naNPow.execute() );
    }

    @Test
    public void zeroToNegPower() {
        TwoOperandCalculation zeroToNegPow = new TwoOperandCalculation( "^", 0.0, -4 );
        assertEquals( -1, zeroToNegPow.execute() );
    }

    @Test
    public void cubeRoot() {
        TwoOperandCalculation cube = new TwoOperandCalculation( "V", FIRST, 3 );
        assertEquals( 0, cube.execute() );
    }

    @Test
    public void squareRootOfNaN() {
        TwoOperandCalculation firstOpNaN = new TwoOperandCalculation( "V", Double.NaN, SECOND );
        assertEquals( -1, firstOpNaN.execute() );
    }

    @Test
    public void squareRootOfNegativeInf() {
        TwoOperandCalculation firstOpInf = new TwoOperandCalculation( "V", Double.NEGATIVE_INFINITY, 0 );
        assertEquals( -1, firstOpInf.execute() );
    }

    @Test
    public void modZero() {
        TwoOperandCalculation modZero = new TwoOperandCalculation( "mod", FIRST, 0 );
        assertEquals( -1, modZero.execute() );
    }

    @Test
    public void invalidOperator() {
        TwoOperandCalculation invalid = new TwoOperandCalculation( "not valid", SECOND, FIRST );
        assertEquals( -1, invalid.execute() );
    }

    /**
     * Test of toString method, of class TwoOperandCalculation.
     */
    @Test
    public void multiplyToString() {
        assertEquals( "5.0 * 2.0", multiply.toString() );
    }

    @Test
    public void logToString() {
        assertEquals( "5.0 log 2.0", log.toString() );
    }

    @Test
    public void modToString() {
        assertEquals( "5.0 mod 2.0", mod.toString() );
    }
    
}
