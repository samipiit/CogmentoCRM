package CogmentoCRM.homePage.aboutPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends Base {

    public static final String URL = "https://cogmento.com/about.html";

    public AboutPage() {
        PageFactory.initElements(driver, this);
    }




}
