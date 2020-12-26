package testPageLib.loginPageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pageLib.loginPage.LoginPage;
import testUtils.DataReader;

import java.lang.reflect.Method;

public class LoginPageTest extends Base {

    public LoginPageTest() { super(); }

    LoginPage loginPage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
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
    @Test (dataProvider = "getLoginTestData")
    public void testDoLogin(String username, String password) {
        loginPage.doLogin(username, password);

        Assert.assertEquals(driver.getTitle(), "Cogmento CRM", "***PAGE TITLE DOES NOT MATCH***");
    }

    @DataProvider
    public Object[][] getLoginTestData() throws Exception {
        dataReader = new DataReader();

        String path = System.getProperty("user.dir") + "/src/main/java/testData/TestData1.xlsx";

        return dataReader.fileReaderArrayStringArraysXSSF(path, "Login");
    }

}
