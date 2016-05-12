
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
public class ParserTest {
    
    private Parser parser;
    
    public ParserTest() {
        
        parser = new Parser( new CLInterface() );
        
        System.out.println( "ParserTest: constructor done, created test Object." );
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
    public void testParseInputString() {
        
        assertEquals( -1, parser.parseInputString( null ) );
        assertEquals( -1, parser.parseInputString( "0 ^ -1" ) );
        assertEquals( 0, parser.parseInputString( "ln 5" ) );
        assertEquals( 0, parser.parseInputString( "3.0 + 1") );
        assertEquals( -1, parser.parseInputString( "3 r 5" ) );
        assertEquals( 0, parser.parseInputString( "3 + 5" ) );
        assertEquals( -1, parser.parseInputString( "1+2" ) );
        assertEquals( -1, parser.parseInputString( "1 + 2 + 3") );
        assertEquals( 1, parser.parseInputString( "v(1,2,3) . 3" ) );
        assertEquals( 0, parser.parseInputString( "v(1,2,3) . v(1,2,3)" ) );
     //   assertEquals( -1, parser.parseInputString( "3..0 + 3" ) );
     //   assertEquals( -1, parser.parseInputString( "V(3,2,1) x v(1,2,3)" ) );
                
        System.out.println( "ParserTest: testParseInputString() method." );
    }

    /**
     * Test of getLastAnswer method, of class Parser.
     */
    @Test
    public void testGetLastAnswer() {
        
        parser.parseInputString( "3 + 5" );
        assertEquals( 8, parser.getLastAnswer(), 0.001 );
                
        System.out.println( "ParserTest: testGetLastAnswer() method." );
    }

    /**
     * Test of getLastVectorAnswer method, of class Parser.
     */
    @Test
    public void testGetLastVectorAnswer() {
        
        assertEquals( 1, parser.parseInputString( "3 . v(1,1,-1)" ) );
        
        double result[] = { 3, 3, -3 };
        
        assertEquals( result.length, parser.getLastVectorAnswer().length );
        
        for( int i=0; i<result.length; i++ ){
            assertEquals( result[i], parser.getLastVectorAnswer()[i], 0.001 );
        }
                
        System.out.println( "ParserTest: testGetLastVectorAnswer() method." );
    }

    /**
     * Test of getErrorMessage method, of class Parser.
     */
    @Test
    public void testGetErrorMessage() {
        
        assertEquals( -1, parser.parseInputString( "1" ) );
        assertEquals( "Too little elements to parse as a calculation.", parser.getErrorMessage() );
        
        System.out.println( "ParserTest: testGetErrorMessage() method." );
    }
    
}
