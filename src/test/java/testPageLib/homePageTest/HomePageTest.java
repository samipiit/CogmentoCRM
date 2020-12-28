package testPageLib.homePageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageLib.homePage.HomePage;
import pageLib.homePage.aboutPage.AboutPage;
import pageLib.homePage.loginPage.LoginPage;

public class HomePageTest extends Base {

    public HomePageTest() { super(); }

    HomePage homePage;
    AboutPage aboutPage;
    LoginPage loginPage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional ("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        homePage = new HomePage();
    }

    @Test (priority = 1, enabled = true)
    public void testNavigateToLoginPage(){
        loginPage = homePage.navigateToLoginPage();
        waitUntilURLIs(LoginPage.URL);
        waitUntilPresent(loginPage.inputEmailAddress);

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, LoginPage.URL, "***URL DOES NOT MATCH***");
    }

    @Test (enabled = false)
    public void testNavigateToAboutPage(){
        aboutPage = homePage.navigateToAboutPage();
        waitUntilURLIs(AboutPage.URL);

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, AboutPage.URL, "***URL DOES NOT MATCH***");
    }

    @Test
    public void testMainContainerImage1() {
        Assert.assertTrue(isElementPresent(homePage.imageContainerMain1), "IMAGE IS NOT DISPLAYED");
    }

    @Test
    public void testMainContainerImage2() {
        Assert.assertTrue(isElementPresent(homePage.imageContainerMain2), "IMAGE IS NOT DISPLAYED");
    }

    @Test
    public void testMainContainerImage3() {
        Assert.assertTrue(isElementPresent(homePage.imageContainerMain3), "IMAGE IS NOT DISPLAYED");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText1() {
        String actualText = getTextFromElement(homePage.textContainerMainTitle1);

        Assert.assertEquals(actualText, "Sell", "TITLE DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText2() {
        String actualText = getTextFromElement(homePage.textContainerMainTitle2);

        Assert.assertEquals(actualText, "Service", "TITLE DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText3() {
        String actualText = getTextFromElement(homePage.textContainerMainTitle3);

        Assert.assertEquals(actualText, "Market", "TITLE DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerBodyText1() {
        String actualText = getTextFromElement(homePage.textContainerMainBody1).trim();

        Assert.assertEquals(actualText, "Convert leads into accounts faster with the world's #1 CRM solution. " +
                "Grow your customer base, find new ones, and close more quickly from anywhere.", "BODY TEXT DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerBodyText2() {
        String actualText = getTextFromElement(homePage.textContainerMainBody2).trim();

        Assert.assertEquals(actualText, "Support every customer on every channel everywhere with CRM. " +
                "Personalize customer care, close cases faster, and deliver support everywhere.", "BODY TEXT DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerBodyText3() {
        String actualText = getTextFromElement(homePage.textContainerMainBody3).trim();

        Assert.assertEquals(actualText, "With Cogmento CRM, you can reach out and engage your clients and " +
                "nurture relationships. Personalize your email marketing, engage with mobile and influential social network marketing.", "BODY TEXT DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testNumberOfHeaderLinks() {
        int actualNumOfLinks = homePage.getNumOfHeaderLinks();

        Assert.assertEquals(actualNumOfLinks, 21, "NUMBER OF LINKS DO NOT MATCH");
    }

}
