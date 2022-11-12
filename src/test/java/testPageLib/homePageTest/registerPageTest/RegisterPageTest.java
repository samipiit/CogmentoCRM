package testPageLib.homePageTest.registerPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.homePage.registerPage.RegisterPage;

public class RegisterPageTest extends Base {

    RegisterPage registerPage;

    public RegisterPageTest() { super(); }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        registerPage = new HomePage().clickButtonSignUpSection1();

        waitUntilURLIs(RegisterPage.URL);
    }
}
