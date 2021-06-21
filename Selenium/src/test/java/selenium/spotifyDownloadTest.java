package selenium;

import org.testng.annotations.Test;
import selenium.base.TestUtilities;
import selenium.pages.spotify.spotifyDownloadPage;
import selenium.pages.spotify.spotifyStartPage;

public class spotifyDownloadTest extends TestUtilities {

    spotifyStartPage spotifyStartPage;
    spotifyDownloadPage spotifyDownloadPage;

    @Test
    public void downloadApp() {
        spotifyStartPage = new spotifyStartPage(driver, log);
        spotifyDownloadPage = new spotifyDownloadPage(driver, log);
        spotifyStartPage.openPage();
        spotifyStartPage.clickDownloadPage();

        spotifyDownloadPage.download();
    }
}
