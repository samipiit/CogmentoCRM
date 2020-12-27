package testPageLib.loginHomepageTest.toolsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.toolsPage.ToolsPage;

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
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .clickLinkToolsSettingsDropdown();
    }
}
