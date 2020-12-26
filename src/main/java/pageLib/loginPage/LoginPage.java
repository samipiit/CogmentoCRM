package pageLib.loginPage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLib.homePage.HomePage;
import testUtils.DataReader;

import static pageLib.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    @FindBy (css = textBoxEmailAddress)
    public WebElement inputEmailAddress;

    @FindBy (css = textBoxPassword)
    public WebElement inputPassword;

    @FindBy (css = buttonSubmit)
    public WebElement buttonLoginSubmit;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }




    public void navigateToLoginPage() {
        new HomePage().clickLoginButton();
    }

    public void sendKeysToEmailAddressTextBox(String emailAddress) {
        inputEmailAddress.sendKeys(emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginSubmitButton() {
        buttonLoginSubmit.click();
    }

    public void doLogin(String emailAddress, String password) {
        sendKeysToEmailAddressTextBox(emailAddress);
        sendKeysToPasswordTextBox(password);
        clickLoginSubmitButton();
    }
}
