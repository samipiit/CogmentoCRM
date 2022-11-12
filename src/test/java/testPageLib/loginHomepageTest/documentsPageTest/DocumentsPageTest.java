package testPageLib.loginHomepageTest.documentsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.documentsPage.DocumentsPage;
import CogmentoCRM.homePage.HomePage;

public class DocumentsPageTest extends Base {

    DocumentsPage documentsPage;

    public DocumentsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        documentsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToDocumentsPage();

        waitUntilURLIs(DocumentsPage.URL);
        waitUntilPresent(documentsPage.textDocumentsHeader);
    }
}
