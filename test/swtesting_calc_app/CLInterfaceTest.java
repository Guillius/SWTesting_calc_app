
package swtesting_calc_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Guillaume
 */
public class CLInterfaceTest {
    
    private CLInterface cli;
    
    public CLInterfaceTest() {
        
        cli = new CLInterface();
        
        System.out.println( "CLInterfaceTest: constructor done, created test Object." );
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
     * Test of main method, of class CLInterface.
     */
    @Ignore // input cannot be provided => input = null => NullPointerException
    @Test
    public void testMain() {
        
        String args[] = {""};
        
        cli.main( args );
        
        System.out.println( "CLInterfaceTest: testMain() method." );
    }

    /**
     * Test of addToHistory method, of class CLInterface.
     */
    @Ignore
    @Test
    public void testAddToHistory() {
    }

    /**
     * Test of getPreviousHistoryEntry method, of class CLInterface.
     */
    @Test
    public void testGetPreviousHistoryEntry() {
        
        ParserTest parserTestClass = new ParserTest();
        parserTestClass.getParserTestObject().parseInputString( "3 + 3" );
        
        assertEquals( "3.0 + 3.0", cli.getPreviousHistoryEntry(1).toString() );
        
        System.out.println( "CLInterfaceTest: testGetPreviousHistoryEntry() method." );
    }
    
}
