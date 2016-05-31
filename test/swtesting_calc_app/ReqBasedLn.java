
package swtesting_calc_app;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class ReqBasedLn {
    
    public ReqBasedLn(){
    
    }
    
    /**
     * Test special cases.
     */
    @Test
    public void lnOfNaN() {
        OneOperandCalculation test = new OneOperandCalculation( "ln", NaN);
        assertEquals( -1, test.execute() );
        assertEquals( "Operand was NaN or less than zero.", test.getError() );
    }

    @Test
    public void lnOfPosInf() {
        OneOperandCalculation test = new OneOperandCalculation( "ln", POSITIVE_INFINITY);
        assertEquals( 0, test.execute() );
        assertEquals( POSITIVE_INFINITY, test.getAnswer(), 0.001 );
    }

    @Test
    public void lnOfOne() {
        OneOperandCalculation test = new OneOperandCalculation( "ln", 1);
        assertEquals( 0, test.execute() );
        assertEquals( 0, test.getAnswer(), 0.001 );
    }

    @Test
    public void lnOfNegativeNumber() {
        OneOperandCalculation test = new OneOperandCalculation( "ln", -5);
        assertEquals( -1, test.execute() );
        assertEquals( "Operand was NaN or less than zero.", test.getError() );
    }

    @Test
    public void lnOfZero() {
        OneOperandCalculation test = new OneOperandCalculation( "ln", 0 );
        assertEquals( 0, test.execute() );
        assertEquals( NEGATIVE_INFINITY, test.getAnswer(), 0.001 );
    }
    
}//end of class
