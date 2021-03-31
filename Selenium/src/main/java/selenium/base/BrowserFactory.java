package selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        FirefoxOptions options2 = new FirefoxOptions();
        options2.addArguments("start-maximized");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(options));
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
                driver.set(new ChromeDriver(options));
                break;
        }
        return driver.get();
    }


}
