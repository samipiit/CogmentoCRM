package testPageLib.homePageTest.loginPageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.LoginHomepage;
import pageLib.homePage.loginPage.LoginPage;
import base.utils.DataReader;

public class LoginPageTest extends Base {

    public LoginPageTest() { super(); }

    LoginPage loginPage;
    LoginHomepage loginHomepage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional ("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        loginPage = new HomePage().navigateToLoginPage();
        waitUntilURLIs(LoginPage.URL);
    }

    /**
     * Test Case 1:
     *  1. Given user is at https://ui.cogmento.com
     *  2. User enters in valid email address in email address input box
     *  3. User enters in valid password in password input box
     *  4. User clicks Login Submit button
     *  5. Then user should be navigated to profile homepage
     */
    @Test (dataProvider = "getInvalidLoginTestData")
    public void testDoInvalidLogin(String username, String password) {
        loginPage.doLogin(username, password);

        Assert.assertTrue(isElementPresent(loginPage.invalidLoginMessage), "INVALID LOGIN MESSAGE IS NOT DISPLAYED OR USER WAS ALLOWED TO LOGIN");
    }

    @DataProvider
    public Object[][] getInvalidLoginTestData() throws Exception {
        dataReader = new DataReader();
        String path = System.getProperty("user.dir") + properties.getProperty("testdatapath");
        return dataReader.fileReaderArrayStringArraysXSSF(path, "InvalidLogin");
    }

    @Test
    public void testDoValidLogin() {
        loginHomepage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
        waitUntilPresent(loginHomepage.textUserNameDisplay);

        Assert.assertEquals(getTextFromElement(loginHomepage.textUserNameDisplay), properties.getProperty("profilename"), "USER NAME DOES NOT MATCH");
    }

}
