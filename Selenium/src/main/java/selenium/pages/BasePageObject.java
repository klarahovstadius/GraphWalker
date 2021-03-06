package selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Forth class to create/when the other base classes are done
 */

/**
 * I will add methods here that are related to Selenium & that are common to the pages
 */
public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) { //needed from the pages that extends this class
        this.driver = driver;
        this.log = log;
    }

    /**
     * Open URL
     */
    public void openURL(String URL) {
        driver.get(URL);
        log.info("Webpage opened");
    }

    /**
     * Find element
     */
    public void findElement(By locator) {
        driver.findElement(locator);
        log.info("Found the element from locator " + locator);
    }

    public WebElement findElementReturnElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        log.info("Found the element from locator " + locator);
        return element;
    }

    /**
     * Wait
     */
    protected boolean isClickable(By locator, int timeOutSeconds) {
        boolean result;
        try {
            log.info("Checking for {} seconds if element is clickable. Element: {}", timeOutSeconds, locator);
            WebDriverWait waitForLocator = new WebDriverWait(driver, timeOutSeconds);
            waitForLocator.until(ExpectedConditions.elementToBeClickable(locator));
            result = driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Exception while checking if the element is clickable: {}", (Object) e.getStackTrace());
            result = false;
        }
        return result;
    }

    protected boolean isDisplayed(By locator) {
        boolean result = false;
        try {
            log.info("Checking if displayed: {}", locator);
            WebDriverWait waitForLocator = new WebDriverWait(driver, 5);
            waitForLocator.until(ExpectedConditions.visibilityOfElementLocated(locator));
            result = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Exception waiting for a locator to be visible: {}", (Object) e.getStackTrace());
        }
        return result;
    }

    /**
     * Send Keys
     */
    public void sendKeys(By locator, String keys) {
        driver.findElement(locator).sendKeys(keys);
        log.info("Found the element from locator " + locator);
        log.info("Keys sent to locator " + locator);
    }

    public void sendKeys(By locator, Keys keys) {
        driver.findElement(locator).sendKeys(keys);
        log.info("Found the element from locator " + locator);
        log.info("Keys sent to locator " + locator);
    }

    /**
     * Click on element
     */
    public void clickElement(By locator) {
        isClickable(locator,5);
        driver.findElement(locator).click();
        log.info("Clicked on locator {} ",locator);
    }

    /**
     * Switch frame/iframe window either with iframe name or number (index 0)
     */
    public void switchWindow(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public void switchWindow(int frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToParent() {
        driver.switchTo().parentFrame();
    }
}
