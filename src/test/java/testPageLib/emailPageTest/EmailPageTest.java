package testPageLib.emailPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.emailPage.EmailPage;
import pageLib.homePage.HomePage;

public class EmailPageTest extends Base {

    EmailPage emailPage;

    public EmailPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        emailPage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToEmailPage();
    }
}
