package pageLib.homePage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageLib.homePage.aboutPage.AboutPage;
import pageLib.homePage.loginPage.LoginPage;

import static pageLib.homePage.HomePageLocators.*;

public class HomePage extends Base {

    public static final String URL = properties.getProperty("url");

    @FindBy (css = webElementButtonLogin)
    public WebElement buttonLogin;

    @FindBy (css = webElementButtonAbout)
    public WebElement buttonAbout;

    @FindBy (css = webElementTextContainerMainTitle1)
    public WebElement textContainerMainTitle1;

    @FindBy (css = webElementTextContainerMainTitle2)
    public WebElement textContainerMainTitle2;

    @FindBy (css = webElementTextContainerMainTitle3)
    public WebElement textContainerMainTitle3;

    @FindBy (css = webElementTextContainerMainBody1)
    public WebElement textContainerMainBody1;

    @FindBy (css = webElementTextContainerMainBody2)
    public WebElement textContainerMainBody2;

    @FindBy (css = webElementTextContainerMainBody3)
    public WebElement textContainerMainBody3;

    @FindBy (css = webElementImageContainerMain1)
    public WebElement imageContainerMain1;

    @FindBy (css = webElementImageContainerMain2)
    public WebElement imageContainerMain2;

    @FindBy (css = webElementImageContainerMain3)
    public WebElement imageContainerMain3;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        buttonLogin.click();

        return new LoginPage();
    }

    public AboutPage navigateToAboutPage() {
        buttonAbout.click();

        return new AboutPage();
    }

    public int getNumOfHeaderLinks() {
        int numOfLinks = getNumberOfLinks(By.cssSelector(webElementsLinksHeader));

        return numOfLinks;
    }
}
