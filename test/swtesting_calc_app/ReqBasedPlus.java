
package swtesting_calc_app;

import static java.lang.Double.NaN;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import org.junit.Test;
import swtesting_calc_app.TwoOperandCalculation;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class ReqBasedPlus {
    
    public ReqBasedPlus(){
        
    }
    
    /**
     * Test special cases.
     */
    @Test 
    public void negInfPlusNegInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", NEGATIVE_INFINITY, NEGATIVE_INFINITY);
        assertEquals( 0, test.execute() );
        assertEquals( NEGATIVE_INFINITY, test.getAnswer(), 0.001 );
    }

    @Test 
    public void negInfPlusNegNumber() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", NEGATIVE_INFINITY, -5 );
        assertEquals( 0, test.execute() );
        assertEquals( NEGATIVE_INFINITY, test.getAnswer(), 0.001 );
    }

    @Test
    public void posInfPlusPosInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", POSITIVE_INFINITY, POSITIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( POSITIVE_INFINITY, test.getAnswer(), 0.001 );
    }

    @Test
    public void posInfPlusNegInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", POSITIVE_INFINITY, NEGATIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void posInfPlusNumber() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", POSITIVE_INFINITY, 13 );
        assertEquals( 0, test.execute() );
        assertEquals( POSITIVE_INFINITY, test.getAnswer(), 0.001 );
    }

    @Test
    public void naNPlusNumber() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", NaN, 3 );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void naNPlusNegNumber() {
        TwoOperandCalculation  test = new TwoOperandCalculation( "+", NaN, -3 );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void naNPlusPosInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", NaN, POSITIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }

    @Test
    public void naNPlusNegInf() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", NaN, NEGATIVE_INFINITY );
        assertEquals( 0, test.execute() );
        assertEquals( NaN, test.getAnswer(), 0.001 );
    }
    
    /**
     * Test equivalence partitions.
     */
    @Test
    public void equivPartNegNeg() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", -5, -27 );
        assertEquals( 0, test.execute() );
        assertEquals( -32, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartNegPos() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", -3, 5 );
        assertEquals( 0, test.execute() );
        assertEquals( 2, test.getAnswer(), 0.001 );
    }

    @Test
    public void equiPart_BoundValueZeroPlusZero() {
        //Boundary Value too
        TwoOperandCalculation test = new TwoOperandCalculation( "+", 0, 0 );
        assertEquals( 0, test.execute() );
        assertEquals( 0, test.getAnswer(), 0.0000001 );
    }

    @Test
    public void equivPartPosNeg() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", 5, -11 );
        assertEquals( 0, test.execute() );
        assertEquals( -6, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartPosPos() {
        TwoOperandCalculation test = new TwoOperandCalculation( "+", 7, 17 );
        assertEquals( 0, test.execute() );
        assertEquals( 24, test.getAnswer(), 0.001 );
    }

}//end of class
