package selenium;

import org.testng.annotations.Test;
import selenium.base.TestUtilities;
import selenium.pages.google.GoogleResultPage;
import selenium.pages.google.GoogleStartPage;

public class googleSearchTest extends TestUtilities {

    private String expectedResults = "8990";

    //@Parameters({ "username", "password", "expectedMessage" }) - If we would use parameters
    //If we wanna use an xml file as the provider, then we must run the test from the xml file
    //@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class) - If we would use a csv approach

    /**
     * This test doesn't work anymore due to a "I'm not a robot" box that appears
     */
    GoogleStartPage googleStartPage;
    GoogleResultPage googleResultPage;

    @Test
    public void searchTest() throws InterruptedException {
        googleStartPage = new GoogleStartPage(driver, log);

        /** Navigate to Google (the browser will open in the Before method)*/
        googleStartPage.openPage();

        /** Search for a string in Google*/
        googleStartPage.searchGoogle();

        /** Execute search*/
        googleResultPage = googleStartPage.clickSearch();

        /** Verify the number of results*/
        googleResultPage.verifyResult(expectedResults);
        takeScreenshot("Result");
    }

}
