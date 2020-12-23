package testPageLib.loginPageTest;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageLib.loginPage.LoginPage;

public class LoginPageTest extends Base {

    static LoginPage loginPage;

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

        loginPage = new LoginPage();

        loginPage.navigateToLoginPage();
        loginPage.sendKeysToEmailAddressTextBox();
        loginPage.sendKeysToPasswordTextBox();
        loginPage.clickLoginSubmitButton();

        Assert.assertEquals(driver.getTitle(), "Cogmento CRM", "***PAGE TITLE DOES NOT MATCH***");

    }


}
