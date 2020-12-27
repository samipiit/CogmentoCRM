package pageLib.homePage.loginPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageLib.loginHomepage.LoginHomepage;

import static pageLib.homePage.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    public static final String URL = "https://ui.cogmento.com/";

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

        LoginHomepage loginHomepage = new LoginHomepage();

        waitUntilClickable(loginHomepage.buttonDropdownSettings);

        if (!isElementPresent(loginHomepage.textUserNameDisplay)) {
            System.out.println("INVALID LOGIN");
            return null;
        }


        return loginHomepage;
    }
}
