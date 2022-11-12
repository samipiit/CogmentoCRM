package testPageLib.homePageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.homePage.aboutPage.AboutPage;
import CogmentoCRM.homePage.comparePage.ComparePage;
import CogmentoCRM.homePage.loginPage.LoginPage;
import CogmentoCRM.homePage.pricingPage.PricingPage;
import CogmentoCRM.homePage.registerPage.RegisterPage;
import CogmentoCRM.homePage.supportPage.SupportPage;
import CogmentoCRM.loginHomepage.settingsPage.SettingsPage;

public class HomePageTest extends Base {

    public HomePageTest() { super(); }

    HomePage homePage;
    AboutPage aboutPage;
    ComparePage comparePage;
    PricingPage pricingPage;
    SupportPage supportPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    SettingsPage settingsPage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional ("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        homePage = new HomePage();
    }

    @Test (enabled = true)
    public void testNumberOfHeaderLinks() {
        int actualNumOfLinks = homePage.getNumOfHeaderLinks();

        Assert.assertEquals(actualNumOfLinks, 21);
    }

    @Test (enabled = true)
    public void testNavigateToAboutPage(){
        aboutPage = homePage.navigateToAboutPage();
        waitUntilURLIs(AboutPage.URL);

        Assert.assertEquals(getCurrentURL(), AboutPage.URL);
    }

    @Test (enabled = true)
    public void testClickLinkCRM() {
        registerPage = homePage.clickLinkCRM();
        waitUntilURLIs(RegisterPage.URL);

        Assert.assertEquals(getCurrentURL(), RegisterPage.URL);
    }

    @Test (enabled = true)
    public void testNavigateToComparePage() {
        comparePage = homePage.navigateToComparePage();
        waitUntilURLIs(ComparePage.URL);

        Assert.assertEquals(getCurrentURL(), ComparePage.URL);
    }

    @Test (enabled = true)
    public void testNavigateToPricingPage() {
        pricingPage = homePage.navigateToPricingPage();
        waitUntilURLIs(PricingPage.URL);

        Assert.assertEquals(getCurrentURL(), PricingPage.URL);
    }

    @Test (enabled = true)
    public void testClickLinkAppleiTunes() {
        homePage.clickLinkAppleiTunesStore();
        switchToTab(1);

        Assert.assertEquals(getCurrentURL(), "https://apps.apple.com/us/app/cogmento/id1291380634");
    }

    @Test (enabled = true)
    public void testClickLinkGooglePlayStore() {
        homePage.clickLinkGooglePlayStore();
        switchToTab(1);

        Assert.assertEquals(getCurrentURL(), "https://play.google.com/store/apps/details?id=com.cogmento.app");
    }

    @Test (enabled = true)
    public void testNavigateToSupportPage() {
        supportPage = homePage.navigateToSupportPage();
        waitUntilURLIs(SupportPage.URL);

        Assert.assertEquals(getCurrentURL(), SupportPage.URL);
    }

    @Test (enabled = true)
    public void testNavigateToLoginPage(){
        loginPage = homePage.navigateToLoginPage();
        waitUntilPresent(loginPage.inputEmailAddress);

        Assert.assertTrue(isElementPresent(loginPage.inputEmailAddress));
    }

    @Test (enabled = true)
    public void testTextHeaderSection1() {
        Assert.assertEquals(getTextFromElement(homePage.textHeaderSection1), "Cogmento CRM\nbusiness in the cloud");
    }

    @Test (enabled = true)
    public void testClickButtonSignUpSection1() {
        registerPage = homePage.clickButtonSignUpSection1();
        waitUntilURLIs(RegisterPage.URL);

        Assert.assertEquals(getCurrentURL(), RegisterPage.URL);
    }

    @Test (enabled = true)
    public void testBackgroundColorBeforeHoverButtonSignUpSection1() {
        Assert.assertEquals(homePage.getBackgroundColorBeforeHoverButtonSignUpSection1(), "rgba(255, 255, 255, 1)");
    }

    @Test (enabled = false)
    public void testImage1Section2() {
        Assert.assertTrue(isElementPresent(homePage.image1Section2));
    }

    @Test (enabled = false)
    public void testImage2Section2() {
        Assert.assertTrue(isElementPresent(homePage.image2Section2));
    }

    @Test (enabled = false)
    public void testImage3Section2() {
        Assert.assertTrue(isElementPresent(homePage.image3Section2));
    }

    @Test (enabled = false)
    public void testTextHeader1Section2() {
        String actualText = getTextFromElement(homePage.textHeader1Section2);

        Assert.assertEquals(actualText, "Sell");
    }

    @Test (enabled = false)
    public void testTextHeader2Section2() {
        String actualText = getTextFromElement(homePage.textHeader2Section2);

        Assert.assertEquals(actualText, "Service");
    }

    @Test (enabled = false)
    public void testTextHeader3Section2() {
        String actualText = getTextFromElement(homePage.textHeader3Section2);

        Assert.assertEquals(actualText, "Market");
    }

    @Test (enabled = false)
    public void testTextBody1Section2() {
        String actualText = getTextFromElement(homePage.textBody1Section2);

        Assert.assertEquals(actualText, "Convert leads into accounts faster with the world's #1 CRM solution. " +
                "Grow your customer base, find new ones, and close more quickly from anywhere.");
    }

    @Test (enabled = false)
    public void testTextBody2Section2() {
        String actualText = getTextFromElement(homePage.textBody2Section2);

        Assert.assertEquals(actualText, "Support every customer on every channel everywhere with CRM. " +
                "Personalize customer care, close cases faster, and deliver support everywhere.");
    }

    @Test (enabled = false)
    public void testTestBody3Section2() {
        String actualText = getTextFromElement(homePage.textBody3Section2);

        Assert.assertEquals(actualText, "With Cogmento CRM, you can reach out and engage your clients and " +
                "nurture relationships. Personalize your email marketing, engage with mobile and influential social network marketing.");
    }

    @Test (enabled = true)
    public void testURLVideoSection4() {
        Assert.assertEquals(homePage.getURLVideoSection4(), "https://www.youtube.com/embed/WsVpoOVFKQM");
    }

    @Test (enabled = true)
    public void testPlayYouTubeVideoSection4() {
        homePage.playYouTubeVideoSection4();

        Assert.assertTrue(isElementPresent(homePage.youTubeVideoPlaying));
    }





}
