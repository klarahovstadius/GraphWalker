package selenium;

import org.testng.annotations.Test;
import selenium.base.TestUtilities;
import selenium.pages.GoogleResultPage;
import selenium.pages.GoogleStartPage;

public class googleSearchTest extends TestUtilities {

    private String expectedResults = "9260";

    @Test
    public void searchTest() throws InterruptedException {
        /** Change chrome settings */
        GoogleStartPage googleStartPage = new GoogleStartPage(driver, log);
        /** Navigate to Google (the browser will open in the Before method)*/

        googleStartPage.openPage();


        /** Search for a string in Google*/
        googleStartPage.searchGoogle();

        /** Execute search*/
        GoogleResultPage googleResultPage = googleStartPage.clickSearch();

        /** Verify the number of results*/
        googleResultPage.verifyResult(expectedResults);
        takeScreenshot("Result");
    }
}
