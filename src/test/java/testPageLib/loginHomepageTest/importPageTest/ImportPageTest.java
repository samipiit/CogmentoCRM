package testPageLib.loginHomepageTest.importPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.importPage.ImportPage;

public class ImportPageTest extends Base {

    ImportPage importPage;

    public ImportPageTest() {
        super();
    }

    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
        importPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToImportPage();

        waitUntilURLIs(ImportPage.URL);
        waitUntilPresent(importPage.textHeaderImport);
    }
}
