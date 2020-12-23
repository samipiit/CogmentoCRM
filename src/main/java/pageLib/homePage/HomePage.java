package pageLib.homePage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static pageLib.homePage.HomePageLocators.*;

public class HomePage extends Base {

    @FindBy (css = webElementButtonLogin)
    public WebElement buttonLogin;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

}
