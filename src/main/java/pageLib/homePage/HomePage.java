package pageLib.homePage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.aboutPage.AboutPage;
import pageLib.loginPage.LoginPage;

import static pageLib.homePage.HomePageLocators.*;

public class HomePage extends Base {

    @FindBy (css = webElementButtonLogin)
    public WebElement buttonLogin;

    @FindBy (css = webElementButtonAbout)
    public WebElement buttonAbout;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton() {
        buttonLogin.click();

        return new LoginPage();
    }

    public AboutPage clickAboutButton() {
        buttonAbout.click();

        return new AboutPage();
    }



}
