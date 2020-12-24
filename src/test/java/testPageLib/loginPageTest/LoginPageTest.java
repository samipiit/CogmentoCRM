package testPageLib.loginPageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLib.loginPage.LoginPage;

import java.lang.reflect.Method;

public class LoginPageTest extends Base {

    public LoginPageTest() { super(); }

    LoginPage loginPage;

    @BeforeMethod
    @Override
    public void beforeEachMethodInit() {
        super.beforeEachMethodInit();
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }

    /**
     * Test Case 1:
     *  1. Given user is at https://ui.cogmento.com
     *  2. User enters in valid email address in email address input box
     *  3. User enters in valid password in password input box
     *  4. User clicks Login Submit button
     *  5. Then user should be navigated to profile homepage
     */
    @Test
    public void testDoLogin() {
        loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));

        Assert.assertEquals(driver.getTitle(), "Cogmento CRM", "***PAGE TITLE DOES NOT MATCH***");
    }


}
