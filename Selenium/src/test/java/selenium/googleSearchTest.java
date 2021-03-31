package selenium;

import org.testng.annotations.Test;
import selenium.base.TestUtilities;
import selenium.pages.GoogleStartPage;

public class googleSearchTest extends TestUtilities {

    @Test
    public void searchTest() throws InterruptedException {
        /** Change chrome settings */
        GoogleStartPage googleStartPage = new GoogleStartPage(driver, log);
        /** Navigate to Google (the browser will open in the Before method)*/

        googleStartPage.openPage();


        /** Search for a string in Google*/
        googleStartPage.searchGoogle();

        /** Execute search*/
        googleStartPage.clickSearch();

        /** Verify the number of results*/

    }
}
