package pageLib.loginPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.homePage.HomePage;

import java.util.concurrent.TimeUnit;

import static pageLib.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }


    // Page Factory
    @FindBy (css = textBoxEmailAddress)
    public WebElement inputEmailAddress;

    @FindBy (css = textBoxPassword)
    public WebElement inputPassword;

    @FindBy (css = buttonSubmit)
    public WebElement buttonLoginSubmit;

    public void navigateToLoginPage() {
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();
    }

    public void sendKeysToEmailAddressTextBox() {
        inputEmailAddress.sendKeys(properties.getProperty("username"));
    }

    public void sendKeysToPasswordTextBox() {
        inputPassword.sendKeys(properties.getProperty("password"));
    }

    public void clickLoginSubmitButton() {
        buttonLoginSubmit.click();
    }
}
