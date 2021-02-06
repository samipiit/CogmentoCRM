package testPageLib.homePageTest.supportPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.homePage.HomePage;
import pageLib.homePage.supportPage.SupportPage;

public class SupportPageTest extends Base {

    SupportPage supportPage;

    public SupportPageTest() { super(); }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        supportPage = new HomePage().navigateToSupportPage();

        waitUntilURLIs(SupportPage.URL);
    }
}
