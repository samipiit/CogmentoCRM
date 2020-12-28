package testPageLib.loginHomepageTest.campaignsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.loginHomepage.campaignsPage.CampaignsPage;
import pageLib.homePage.HomePage;

public class CampaignsPageTest extends Base {

    CampaignsPage campaignsPage;

    public CampaignsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        campaignsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCampaignsPage();

        waitUntilURLIs(CampaignsPage.URL);
        waitUntilPresent(campaignsPage.textCampaignsHeader);

    }
}
