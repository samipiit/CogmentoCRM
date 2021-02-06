package testPageLib.homePageTest.comparePageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.homePage.HomePage;
import pageLib.homePage.comparePage.ComparePage;

public class ComparePageTest extends Base {

    ComparePage comparePage;

    public ComparePageTest() { super(); }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        comparePage = new HomePage().navigateToComparePage();
        waitUntilURLIs(ComparePage.URL);
    }


}
