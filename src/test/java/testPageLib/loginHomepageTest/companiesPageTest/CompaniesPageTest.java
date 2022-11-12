package testPageLib.loginHomepageTest.companiesPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.companiesPage.CompaniesPage;
import CogmentoCRM.homePage.HomePage;

public class CompaniesPageTest extends Base {

    CompaniesPage companiesPage;

    public CompaniesPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        companiesPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCompaniesPage();

        waitUntilURLIs(CompaniesPage.URL);
        waitUntilPresent(companiesPage.textCompaniesHeader);
    }

}
