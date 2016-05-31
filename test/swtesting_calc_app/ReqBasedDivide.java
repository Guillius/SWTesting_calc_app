
package swtesting_calc_app;

import org.junit.Test;
import swtesting_calc_app.TwoOperandCalculation;
import static org.junit.Assert.*;
import static java.lang.Double.NaN;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

/**
 *
 * @author Guillaume
 */
public class ReqBasedDivide {
    
    public ReqBasedDivide(){
        
    }
    
    @Test
    public void testDivByZero(){
        TwoOperandCalculation divByZero = new TwoOperandCalculation( "/", 5, 0 );
        assertEquals( -1, divByZero.execute() );
        assertEquals( "Divide by zero.", divByZero.getError() );
        
    }
    
    @Test
    public void testDivByOnePrecision(){
        TwoOperandCalculation divByOne = new TwoOperandCalculation( "/", 5, 1 );
        assertEquals( 0, divByOne.execute() );
        assertEquals( 5, divByOne.getAnswer(), 0.001 );
        
    }

    /**
     * Test equivalence partitions.
     */
    @Test
    public void equivPartNegNeg() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", -6, -2 );
        assertEquals( 0, test.execute() );
        assertEquals( 3, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartNegPos() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", -5, 2 );
        assertEquals( 0, test.execute() );
        assertEquals( -2.5, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartPosNeg() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", 8, -2 );
        assertEquals( 0, test.execute() );
        assertEquals( -4, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartPosPos() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", 12, 2 );
        assertEquals( 0, test.execute() );
        assertEquals( 6, test.getAnswer(), 0.001 );
    }
    
    /**
     * Testing special cases.
     */
    @Test 
    public void divideWithNaN() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", 5, NaN );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void dividePosInfByPosInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", POSITIVE_INFINITY, POSITIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void divideNegInfByPosInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", NEGATIVE_INFINITY, POSITIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void dividePosInfByNegInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "/", POSITIVE_INFINITY, NEGATIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }
    
}//end of class
