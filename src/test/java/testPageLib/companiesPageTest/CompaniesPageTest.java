package testPageLib.companiesPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.companiesPage.CompaniesPage;
import pageLib.homePage.HomePage;

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
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCompaniesPage();
    }

}
