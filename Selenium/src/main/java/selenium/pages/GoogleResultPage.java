package selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage extends BasePageObject{

    public GoogleResultPage(WebDriver driver, Logger log) { //To pass on the driver and log to BasePageObject
        super(driver, log);
    }
}
