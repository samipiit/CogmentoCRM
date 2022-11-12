package testPageLib.loginHomepageTest.toolsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.toolsPage.ToolsPage;

public class ToolsPageTest extends Base {

    ToolsPage toolsPage;

    public ToolsPageTest() {
        super();
    }

    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
        toolsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToToolsPage();

        waitUntilURLIs(ToolsPage.URL);
        waitUntilPresent(toolsPage.textHeaderTools);
    }
}
