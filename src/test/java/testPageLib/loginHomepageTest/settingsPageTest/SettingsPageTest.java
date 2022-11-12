package testPageLib.loginHomepageTest.settingsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.settingsPage.SettingsPage;

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
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToSettingsPage();

        waitUntilURLIs(SettingsPage.URL);
        waitUntilPresent(settingsPage.textHeaderAccountSettings);
    }
}
