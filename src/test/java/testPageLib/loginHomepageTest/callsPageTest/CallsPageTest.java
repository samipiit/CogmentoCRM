package testPageLib.loginHomepageTest.callsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.callsPage.CallsPage;
import CogmentoCRM.homePage.HomePage;

public class CallsPageTest extends Base {

    CallsPage callsPage;

    public CallsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        callsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCallsPage();

        waitUntilURLIs(CallsPage.URL);
        waitUntilPresent(callsPage.textCallsHeader);
    }
}
