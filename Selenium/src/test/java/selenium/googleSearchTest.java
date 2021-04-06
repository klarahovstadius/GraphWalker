package selenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.base.TestUtilities;
import selenium.pages.GoogleResultPage;
import selenium.pages.GoogleStartPage;

public class googleSearchTest extends TestUtilities {

    private String expectedResults = "8990";

    //@Parameters({ "username", "password", "expectedMessage" }) - If we would use parameters
    //If we wanna use an xml file as the provider, then we must run the test from the xml file
    //@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class) - If we would use a csv approach
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
