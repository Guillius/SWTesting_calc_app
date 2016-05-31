
package swtesting_calc_app;

import org.junit.Test;
import swtesting_calc_app.OneOperandCalculation;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class ReqBasedSine {
    
    public ReqBasedSine(){
    
    }

    @Test
    public void testRoundandRoundTheCircle(){
        OneOperandCalculation roundTest = new OneOperandCalculation("sin", 33 );
        double answer;
        assertEquals( 0, roundTest.execute() );
        assertEquals( 0.544639035, answer = roundTest.getAnswer(), 0.001 );
        roundTest = new OneOperandCalculation( "sin", 180-33 );
        assertEquals( 0, roundTest.execute() );
        assertEquals( 0.544639035, roundTest.getAnswer(), 0.001 );
        
        double value;
        for( int k=0; k<155; k++ ){
            roundTest = new OneOperandCalculation("sin", value = 33+k*360 );
            assertEquals( 0, roundTest.execute() );
            assertEquals( answer, roundTest.getAnswer(), 0.001 );
            roundTest = new OneOperandCalculation( "sin", 180-value );
            assertEquals( 0, roundTest.execute() );
            assertEquals( answer, roundTest.getAnswer(), 0.001 );        
        } 
    }
    
    /**
     * Test Boundary Values.
     */
    @Test
    public void boundary_90() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 90 );
        assertEquals( 0, test.execute() );
        assertEquals( 1, test.getAnswer(), 0.001 );
    }

    @Test
    public void boundary_Neg90() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", -90 );
        assertEquals( 0, test.execute() );
        assertEquals( -1, test.getAnswer(), 0.001 );
    }

    @Test
    public void boundaryZero() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 0 );
        assertEquals( 0, test.execute() );
        assertEquals( 0, test.getAnswer(), 0.00000001 );
    }

    @Test
    public void boundary_Neg180() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", -180 );
        assertEquals( 0, test.execute() );
        assertEquals( 0, test.getAnswer(), 0.000001 );
    }

    @Test
    public void boundary_180() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 180 );
        assertEquals( 0, test.execute() );
        assertEquals( 0, test.getAnswer(), 0.000001 );
    }

    /**
     * Test ewuivalence Partitions.
     */
    @Test
    public void equivPartFirstQuadrant() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 45 );
        assertEquals( 0, test.execute() );
        assertEquals( 0.707106, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartFourthQuadrant() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", -45 );
        assertEquals( 0, test.execute() );
        assertEquals( -0.707106, test.getAnswer(), 0.001 );
    }
    @Test
    public void equivPartSecondQuadrant() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 110 );
        assertEquals( 0, test.execute() );
        assertEquals( 0.9396926, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartThirdQuadrantNegSide() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", -110 );
        assertEquals( 0, test.execute() );
        assertEquals( -0.9396926, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartSecondQuadrantNegSide() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", -250 );
        assertEquals( 0, test.execute() );
        assertEquals( 0.939626, test.getAnswer(), 0.001 );
    }

    @Test
    public void equivPartThirdQuadrant() {
        OneOperandCalculation test = new OneOperandCalculation( "sin", 250 );
        assertEquals( 0, test.execute() );
        assertEquals( -0.939626, test.getAnswer(), 0.001 );
    }
              
}//end of class
