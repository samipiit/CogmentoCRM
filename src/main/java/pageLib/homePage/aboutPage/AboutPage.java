package pageLib.homePage.aboutPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import static pageLib.homePage.aboutPage.AboutPageLocators.*;

public class AboutPage extends Base {

    public static final String URL = "https://cogmento.com/about.html";

    public AboutPage() {
        PageFactory.initElements(driver, this);
    }




}
