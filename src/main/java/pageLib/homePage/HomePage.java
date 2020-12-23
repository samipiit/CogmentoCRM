package pageLib.homePage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.loginPage.LoginPage;

import static pageLib.homePage.HomePageLocators.*;

public class HomePage extends Base {

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = webElementButtonLogIn)
    public WebElement buttonLogIn;

    public LoginPage clickLoginButton() {
        buttonLogIn.click();

        return new LoginPage();
    }

}
