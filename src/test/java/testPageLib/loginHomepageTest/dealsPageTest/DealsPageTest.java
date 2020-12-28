package testPageLib.loginHomepageTest.dealsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.loginHomepage.dealsPage.DealsPage;
import pageLib.homePage.HomePage;

public class DealsPageTest extends Base {

    DealsPage dealsPage;

    public DealsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        dealsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToDealsPage();

        waitUntilURLIs(DealsPage.URL);
        waitUntilPresent(dealsPage.textDealsHeader);
    }
}
