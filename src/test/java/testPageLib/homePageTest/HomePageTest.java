package testPageLib.homePageTest;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLib.homePage.HomePage;

public class HomePageTest extends Base {

    public HomePageTest() { super(); }

    HomePage homePage;

    @BeforeMethod
    @Override
    public void beforeEachMethodInit() {
        super.beforeEachMethodInit();
        homePage = new HomePage();
    }

    @Test (priority = 1, groups = "Sanity")
    public void testClickOnLogin(){
        homePage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        System.out.println("ACTUAL URL: " + actualURL);
        Assert.assertEquals(actualURL, "https://ui.cogmento.com/", "***URL DOES NOT MATCH***");
    }

    @Test (priority = 2, groups = "Regression")
    public void testClickOnAbout(){
        homePage.clickAboutButton();

        String actualURL = driver.getCurrentUrl();
        System.out.println("ACTUAL URL: " + actualURL);
        Assert.assertEquals(actualURL, "https://cogmento.com/about.html", "***URL DOES NOT MATCH***");
    }

    @Test
    public void testBy() {
    }

}
