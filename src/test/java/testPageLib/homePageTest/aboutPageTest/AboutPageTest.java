package testPageLib.homePageTest.aboutPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.homePage.aboutPage.AboutPage;
import CogmentoCRM.homePage.HomePage;

public class AboutPageTest extends Base {

    public AboutPageTest () { super(); }

    AboutPage aboutPage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional ("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        aboutPage = new HomePage().navigateToAboutPage();
    }

}
