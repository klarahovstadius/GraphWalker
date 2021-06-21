package selenium.pages.spotify;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.BasePageObject;

public class spotifyDownloadPage extends BasePageObject {

    private final By downloadButton = By.xpath("//div[@class='ButtonInner-peijbp-0 cfGvV encore-inverted-light-set']");

    public spotifyDownloadPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void download(){
        clickElement(downloadButton);
    }
}
