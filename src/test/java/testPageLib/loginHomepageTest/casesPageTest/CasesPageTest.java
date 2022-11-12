package testPageLib.loginHomepageTest.casesPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.casesPage.CasesPage;
import CogmentoCRM.homePage.HomePage;

public class CasesPageTest extends Base {

    CasesPage casesPage;

    public CasesPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        casesPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCasesPage();

        waitUntilURLIs(CasesPage.URL);
        waitUntilPresent(casesPage.textCasesHeader);
    }
}
