package testPageLib.homePageTest;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageLib.homePage.HomePage;

public class HomePageTest extends Base {

    public HomePageTest() { super(); }

    HomePage homePage;

    @Parameters ({"browser"})
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
        homePage = new HomePage();
    }

    @Test (priority = 1, enabled = false)
    public void testClickOnLogin(){
        homePage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        System.out.println("ACTUAL URL: " + actualURL);
        Assert.assertEquals(actualURL, "https://ui.cogmento.com/", "***URL DOES NOT MATCH***");
    }

    @Test (priority = 2, enabled = false)
    public void testClickOnAbout(){
        homePage.clickAboutButton();

        String actualURL = driver.getCurrentUrl();
        System.out.println("ACTUAL URL: " + actualURL);
        Assert.assertEquals(actualURL, "https://cogmento.com/about.html", "***URL DOES NOT MATCH***");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText1() {
        String actualText = getWebElementText(homePage.textContainerMainTitle1);
        System.out.println("ACTUAL TEXT: " + actualText);
        Assert.assertEquals(actualText, "Sell", "TITLE DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText2() {
        String actualText = getWebElementText(homePage.textContainerMainTitle2);
        System.out.println("ACTUAL TEXT: " + actualText);

        Assert.assertEquals(actualText, "Service", "TITLE DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testMainContainerTitleText3() {
        String actualText = getWebElementText(homePage.textContainerMainTitle3);
        System.out.println("ACTUAL TEXT: " + actualText);

        Assert.assertEquals(actualText, "Market", "TITLE DOES NOT MATCH");
    }

    @Test
    public void testMainContainerBodyText1() {
        String actualText = getWebElementText(homePage.textContainerMainBody1).trim();
        System.out.println("ACTUAL TEXT: " + actualText);

        Assert.assertEquals(actualText, "Convert leads into accounts faster with the world's #1 CRM solution. " +
                "Grow your customer base, find new ones, and close more quickly from anywhere.", "BODY TEXT DOES NOT MATCH");
    }

    @Test
    public void testMainContainerBodyText2() {
        String actualText = getWebElementText(homePage.textContainerMainBody2).trim();
        System.out.println("ACTUAL TEXT: " + actualText);

        Assert.assertEquals(actualText, "Support every customer on every channel everywhere with CRM. " +
                "Personalize customer care, close cases faster, and deliver support everywhere.", "BODY TEXT DOES NOT MATCH");
    }

    @Test
    public void testMainContainerBodyText3() {
        String actualText = getWebElementText(homePage.textContainerMainBody3).trim();
        System.out.println("ACTUAL TEXT: " + actualText);

        Assert.assertEquals(actualText, "With Cogmento CRM, you can reach out and engage your clients and " +
                "nurture relationships. Personalize your email marketing, engage with mobile and influential social network marketing.", "BODY TEXT DOES NOT MATCH");
    }

    @Test
    public void testNumberOfHeaderLinks() {
        int actualNumOfLinks = homePage.getNumOfHeaderLinks();
        System.out.println("NUMBER OF LINKS: " + actualNumOfLinks);
        Assert.assertEquals(actualNumOfLinks, 21, "NUMBER OF LINKS DO NOT MATCH");
    }

}
