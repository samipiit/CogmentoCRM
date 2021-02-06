package testPageLib.homePageTest.pricingPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.homePage.HomePage;
import pageLib.homePage.pricingPage.PricingPage;

public class PricingPageTest extends Base {

    PricingPage pricingPage;

    public PricingPageTest() { super(); }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        pricingPage = new HomePage().navigateToPricingPage();
        waitUntilURLIs(PricingPage.URL);
    }
}
