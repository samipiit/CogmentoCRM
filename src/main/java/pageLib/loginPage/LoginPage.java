package pageLib.loginPage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static pageLib.loginPage.LoginPageLocators.*;

public class LoginPage extends Base {

    WebDriverWait driverWait = new WebDriverWait(driver, 3);

    @FindBy (css = textBoxEmailAddress)
    public WebElement inputEmailAddress;

    @FindBy (css = textBoxPassword)
    public WebElement inputPassword;

    @FindBy (css = buttonSubmit)
    public WebElement buttonLoginSubmit;

    public void sendKeysToEmailAddressTextBox() {
        inputEmailAddress.sendKeys("ameikh645@gmail.com");
    }

    public void sendKeysToPasswordTextBox() {
        inputPassword.sendKeys("Tripleh1!");
    }

    public void clickLoginSubmitButton() throws InterruptedException {
        buttonLoginSubmit.click();
    }
}
