package selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleResultPage extends BasePageObject {

    private final By resultCount = By.id("result-stats");

    public GoogleResultPage(WebDriver driver, Logger log) { //To pass on the driver and log to BasePageObject
        super(driver, log);
    }

    /**
     * Verify the number of results
     */
    public void verifyResult(String expected) {
        WebElement results = findElementReturnElement(resultCount);
        String text = results.getAttribute("innerHTML"); //Gives me the inner text
        log.info("Text from result page: "+text);

        //Replace every non-digit number & take a substring
        String str = text.replaceAll("[^\\d]", "").substring(0,4);

        log.info("Total number of results: " + str);
        Assert.assertEquals(str,expected);
    }
}
