package selenium.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

/** Second class to create */
/** Every test will extend this class, so here we will add common code for the tests (opening, closing driver)*/
public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserFactory factory = new BrowserFactory(browser,log); //create an object where the values for browser and log are used
        driver = factory.createDriver(); //open browser
        log.info("Browser opened");

        this.testSuiteName = ctx.getSuite().getName(); //for the screenshots
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver!=null) {
            //driver.quit();
            //log.info("Closed driver in the after method");
        }
    }
}
