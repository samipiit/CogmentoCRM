package testPageLib.loginHomepageTest.formsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.loginHomepage.formsPage.FormsPage;
import pageLib.homePage.HomePage;

public class FormsPageTest extends Base {

    FormsPage formsPage;

    public FormsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        formsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToFormsPage();

        waitUntilURLIs(FormsPage.URL);
        waitUntilPresent(formsPage.textFormsHeader);
    }
}
