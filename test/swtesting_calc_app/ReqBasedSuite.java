
package swtesting_calc_app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Guillaume
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({swtesting_calc_app.ReqBasedPlus.class, swtesting_calc_app.ReqBasedDivide.class, swtesting_calc_app.ReqBasedSine.class, swtesting_calc_app.ReqBasedLn.class})
public class ReqBasedSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
