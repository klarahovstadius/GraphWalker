package selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;

/**
 * First class to create
 */
public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;

    public BrowserFactory(String browser, Logger log) { //same name as the class
        this.browser = browser;
        this.log = log;
    }

    public WebDriver createDriver() {
        log.info("Creating driver " + browser);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(chromeOptions));
                log.info("Chrome driver created");
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                log.info("Firefox driver created");
                break;
            default:
                log.info("Do not know how to start " + browser + ". Chrome driver created");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(chromeOptions));
                break;
        }
        return driver.get();
    }


}
