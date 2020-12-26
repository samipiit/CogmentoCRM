package pageLib.loginPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.loginHomepage.LoginHomepage;

import static pageLib.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    @FindBy (css = webElementTextBoxEmailAddress)
    public WebElement inputEmailAddress;

    @FindBy (css = webElementTextBoxPassword)
    public WebElement inputPassword;

    @FindBy (css = webELementButtonSubmit)
    public WebElement buttonLoginSubmit;

    @FindBy (css = webElementInvalidLoginMessage)
    public WebElement invalidLoginMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
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

    public LoginHomepage doLogin(String emailAddress, String password) {
        sendKeysToEmailAddressTextBox(emailAddress);
        sendKeysToPasswordTextBox(password);
        clickLoginSubmitButton();

        return new LoginHomepage();
    }
}
