package CogmentoCRM.homePage.loginPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import CogmentoCRM.loginHomepage.LoginHomepage;

import static CogmentoCRM.homePage.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    public static final String URL = "https://ui.cogmento.com/";

    @FindBy (css = webElementTextBoxEmailAddress)
    public WebElement inputEmailAddress;

    @FindBy (css = webElementTextBoxPassword)
    public WebElement inputPassword;

    @FindBy (css = webElementButtonSubmit)
    public WebElement buttonLoginSubmit;

    @FindBy (css = webElementInvalidLoginMessage)
    public WebElement invalidLoginMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToEmailAddressTextBox(String emailAddress) {
        sendKeysInputTextBox(inputEmailAddress, emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        sendKeysInputTextBox(inputPassword, password);
    }

    public void clickLoginSubmitButton() {
        clickOnElement(buttonLoginSubmit);
    }

    public LoginHomepage doLogin(String emailAddress, String password) {
        sendKeysToEmailAddressTextBox(emailAddress);
        sendKeysToPasswordTextBox(password);
        clickLoginSubmitButton();

        return new LoginHomepage();
    }
}
