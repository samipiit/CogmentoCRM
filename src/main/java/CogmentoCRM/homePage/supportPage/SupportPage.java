package CogmentoCRM.homePage.supportPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

public class SupportPage extends Base {

    public static final String URL = "https://support.cogmento.com/en/collections/1398782-webinars-videos";

    public SupportPage() {
        PageFactory.initElements(driver, this);
    }
}
