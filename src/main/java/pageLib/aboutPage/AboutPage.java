package pageLib.aboutPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import pageLib.homePage.HomePage;

public class AboutPage extends Base {

    public AboutPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateToAboutPage() {
        new HomePage().clickAboutButton();
    }




}
