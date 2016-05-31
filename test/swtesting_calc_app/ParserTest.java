
package swtesting_calc_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swtesting_calc_app.CLInterface;
import swtesting_calc_app.Parser;
import static org.junit.Assert.*;

/**
 *
 * @author Guillaume
 */
public class ParserTest {
    
    private Parser parser;
    
    public ParserTest() {
        
        parser = new Parser( new CLInterface() );
        
    }
    
    public Parser getParserTestObject(){
        return parser;
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
     * Test of parseInputString method, of class Parser.
     */
    @Test
    public void parseNullString() {
        assertEquals( -1, parser.parseInputString( null ) );
    }

    @Test
    public void parseZeroToNegativePower() {
        assertEquals( -1, parser.parseInputString( "0 ^ -1" ) );
    }

    @Test
    public void parseOneOperand() {
        assertEquals( 0, parser.parseInputString( "ln 5" ) );
    }

    @Test
    public void parseDecimalOperand() {
        assertEquals( 0, parser.parseInputString( "3.0 + 1") );
    }

    @Test
    public void parseInvalidOperand() {
        assertEquals( -1, parser.parseInputString( "3 r 5" ) );
    }

    @Test
    public void parseTwoOperandSum() {
        assertEquals( 0, parser.parseInputString( "3 + 5" ) );
    }

    @Test
    public void parseNoSpaces() {
        assertEquals( -1, parser.parseInputString( "1+2" ) );
    }

    @Test
    public void parseTripleSum() {
        assertEquals( -1, parser.parseInputString( "1 + 2 + 3") );
    }

    @Test
    public void parseVectorScalar() {
        assertEquals( 1, parser.parseInputString( "v(1,2,3) . 3" ) );
    }

    @Test
    public void parseVectorVector() {
        assertEquals( 0, parser.parseInputString( "v(1,2,3) . v(1,2,3)" ) );
    }

    @Test( expected = NumberFormatException.class )
    public void parseInputIllegalNumber() {
        //Exception NumberFormatException
        assertEquals( -1, parser.parseInputString( "3..0 + 3" ) );
    }

    @Test( expected = NumberFormatException.class )
    public void parseInputBigVectorV() {
        //Exception NumberFormatException
        assertEquals( -1, parser.parseInputString( "V(3,2,1) x v(1,2,3)" ) );
    }

    /**
     * Test of getLastAnswer method, of class Parser.
     */
    @Test
    public void testGetLastAnswer() {
        
        parser.parseInputString( "3 + 5" );
        assertEquals( 8, parser.getLastAnswer(), 0.001 );
                
    }

    /**
     * Test of getLastVectorAnswer method, of class Parser.
     */
    @Test
    public void testGetLastVectorAnswer() {
        
        parser.parseInputString( "3 . v(1,1,-1)" );
        
        double result[] = { 3, 3, -3 };
        
        assertArrayEquals( result, parser.getLastVectorAnswer(), 0.001 );
                        
    }

    /**
     * Test of getErrorMessage method, of class Parser.
     */
    @Test
    public void testGetErrorMessage() {
        
        parser.parseInputString( "1" );
        assertEquals( "Too little elements to parse as a calculation.", parser.getErrorMessage() );
        
    }
    
}
