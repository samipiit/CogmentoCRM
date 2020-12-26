package testPageLib.aboutPageTest;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageLib.aboutPage.AboutPage;
import pageLib.homePage.HomePage;

public class AboutPageTest extends Base {

    public AboutPageTest () { super(); }

    AboutPage aboutPage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional ("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        aboutPage = new HomePage().clickAboutButton();
    }

}
