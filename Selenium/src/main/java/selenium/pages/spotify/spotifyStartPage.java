package selenium.pages.spotify;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.BasePageObject;

/**
 * Page that extends the base class to be able to use
 */
public class spotifyStartPage extends BasePageObject { //Create a child of another class. You extend a class when it has an "is-a" relationship (and not "use"/"has a"): cat is an animal, car has a wheel
//this page should be the BasePageObject but with additional features

    /**
     * Report added by editing run configuration (Listneres->Check)
     */
    private final By clickDownload = By.xpath("(//a[@class='mh-header-primary svelte-vf0pv9'])[3]");
    private String pageUrl = "https://www.spotify.com/se/";

    public spotifyStartPage(WebDriver driver, Logger log) { //Refer to parent class objects
        super(driver, log);
    }

    public void openPage() {
        openURL(pageUrl);
    }

    public spotifyDownloadPage clickDownloadPage(){
        clickElement(clickDownload);
        return new spotifyDownloadPage(driver,log);
    }
}
