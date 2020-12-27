package testPageLib.loginHomepageTest.settingsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.settingsPage.SettingsPage;

public class SettingsPageTest extends Base {

    SettingsPage settingsPage;

    public SettingsPageTest() {
        super();
    }

    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
        settingsPage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .clickLinkSettingsSettingsDropdown();
    }
}
