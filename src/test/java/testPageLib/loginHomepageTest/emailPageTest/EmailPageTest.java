package testPageLib.loginHomepageTest.emailPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.emailPage.EmailPage;
import CogmentoCRM.homePage.HomePage;

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
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToEmailPage();

        waitUntilURLIs(EmailPage.URL);
        waitUntilPresent(emailPage.textEmailHeader);
    }
}
