package testPageLib.loginHomepageTest.rubbishPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.rubbishPage.RubbishPage;

public class RubbishPageTest extends Base {

    RubbishPage rubbishPage;

    public RubbishPageTest() {
        super();
    }

    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        rubbishPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToRubbishPage();

        waitUntilURLIs(RubbishPage.URL);
        waitUntilPresent(rubbishPage.textRubbishBinHeader);
    }
}
