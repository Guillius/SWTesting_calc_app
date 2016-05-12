
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
    
    private TwoOperandCalculation plus;
    private TwoOperandCalculation minus;
    private TwoOperandCalculation multiply;
    private TwoOperandCalculation divide;
    private TwoOperandCalculation power;
    private TwoOperandCalculation root;
    private TwoOperandCalculation sqrt;
    private TwoOperandCalculation log;
    private TwoOperandCalculation mod;
    
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
        
        System.out.println( "TwoOperandCalc: constructor done, created test Objects." );
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
    public void testGetAnswer() {
        
        testExecute();  //first, execute all the Calculations
        
        assertEquals( 7.0 , plus.getAnswer(), 0.001 );
        assertEquals( 3.0 , minus.getAnswer(), 0.001 );
        assertEquals( 10.0 , multiply.getAnswer(), 0.001 );
        assertEquals( 2.5 , divide.getAnswer(), 0.001 );
        
        System.out.println( "TwoOperandCalcTest: testGetAnswer() method." );
    }

    /**
     * Test of getAnswerVector method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetAnswerVector() {
        
        assertEquals( null, multiply.getAnswerVector() );
        assertEquals( null, divide.getAnswerVector() );
        assertEquals( null, log.getAnswerVector() );
        
        System.out.println( "TwoOperandCalcTest: testGetAnswerVector() method." );
    }

    /**
     * Test of getFirstOperand method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetFirstOperand() {
        
        assertEquals( 5.0, minus.getFirstOperand(), 0.001 );
        assertEquals( 2.0, sqrt.getFirstOperand(), 0.001 );
        
        System.out.println( "TwoOperandCalcTest: testGetFirstOperand() method." );
    }

    /**
     * Test of getSecondOperand method, of class TwoOperandCalculation.
     */
    @Test
    public void testGetSecondOperand() {
        
        assertEquals( 2.0, plus.getSecondOperand(), 0.001 );
        assertEquals( 5.0, sqrt.getSecondOperand(), 0.001 );
        
        System.out.println( "TwoOperandCalcTest: testGetSecondOperand() method." );
    }

    /**
     * Test of execute method, of class TwoOperandCalculation.
     */
    @Test
    public void testExecute() {
            //  0 as return value means "executed normally"
        assertEquals( 0, plus.execute() );
        assertEquals( 0, minus.execute() );
        assertEquals( 0, multiply.execute() );
        assertEquals( 0, divide.execute() );
        assertEquals( 0, power.execute() );
        assertEquals( 0, root.execute() );
        assertEquals( 0, sqrt.execute() );
        assertEquals( 0, log.execute() );
        assertEquals( 0, mod.execute() );
        
            //  extra test cases to achieve more coverage
        TwoOperandCalculation divByZero = new TwoOperandCalculation( "/", SECOND, 0 );
        TwoOperandCalculation naNPow = new TwoOperandCalculation( "^", FIRST, Double.NaN );
        TwoOperandCalculation zeroToNegPow = new TwoOperandCalculation( "^", 0.0, -4 );
        TwoOperandCalculation cube = new TwoOperandCalculation( "V", FIRST, 3 );
        TwoOperandCalculation firstOpNaN = new TwoOperandCalculation( "V", Double.NaN, SECOND );
        TwoOperandCalculation firstOpInf = new TwoOperandCalculation( "V", Double.NEGATIVE_INFINITY, 0 );
        TwoOperandCalculation modZero = new TwoOperandCalculation( "mod", FIRST, 0 );
        TwoOperandCalculation invalid = new TwoOperandCalculation( "not valid", SECOND, FIRST );
        assertEquals( -1, divByZero.execute() );
        assertEquals( -1, naNPow.execute() );
        assertEquals( -1, zeroToNegPow.execute() );
        assertEquals( 0, cube.execute() );
        assertEquals( -1, firstOpNaN.execute() );
        assertEquals( -1, firstOpInf.execute() );
        assertEquals( -1, modZero.execute() );
        assertEquals( -1, invalid.execute() );
        
        System.out.println( "TwoOperandCalcTest: testExecute() method." );
    }

    /**
     * Test of toString method, of class TwoOperandCalculation.
     */
    @Test
    public void testToString() {
        
        assertEquals( "5.0 * 2.0", multiply.toString() );
        assertEquals( "5.0 log 2.0", log.toString() );
        assertEquals( "5.0 mod 2.0", mod.toString() );
        
        System.out.println( "TwoOperandCalcTest: testToString() method." );
    }
    
}
