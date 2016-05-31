
package swtesting_calc_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Guillaume
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({swtesting_calc_app.ParserTest.class, swtesting_calc_app.CalculationTest.class, swtesting_calc_app.CLInterfaceTest.class, swtesting_calc_app.OneOperandCalculationTest.class, swtesting_calc_app.VectorVectorCalculationTest.class, swtesting_calc_app.TwoOperandCalculationTest.class, swtesting_calc_app.VectorScalarCalculationTest.class})
public class FirstSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
