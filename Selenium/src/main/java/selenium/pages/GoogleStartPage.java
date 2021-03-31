package selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * A page
 */
public class GoogleStartPage extends BasePageObject {

    private String pageUrl = "https://www.google.com/";
    private By searchInputBox = By.name("q");
    private String searchText = "Klara Hovstadius";

    /**
     * Good to know xpath strategies
     */
    //By.xpath("//div[@class='a4bIc']/input");
    //By.xpath("(//div[@class='jyfHyd'])[2]");
    //By.xpath("//iframe[starts-with(@src,'https://consent')]")
    public GoogleStartPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Navigate to Google (the browser will open in the Before method)
     */
    public void openPage() {
        openURL(pageUrl); //pass-through since we have the Selenium code separate in BasePageObject
    }

    /**
     * Search in Google
     */
    public void searchGoogle() {
        sendKeys(searchInputBox, searchText);
    }

    /**
     * Execute search
     */
    public void clickSearch() throws InterruptedException {
        Thread.sleep(2000);
        //Here we wanna be passed on to the next page TODO
        sendKeys(searchInputBox, Keys.ENTER);
    }

    /**
     * Verify the number of results
     */
    public void verifyResult() {
        //TODO
    }
}
