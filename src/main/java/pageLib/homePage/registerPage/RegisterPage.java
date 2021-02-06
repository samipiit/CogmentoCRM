package pageLib.homePage.registerPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import static pageLib.homePage.registerPage.RegisterPageLocators.*;

public class RegisterPage extends Base {

    public static final String URL = "https://register.freecrm.com/register/";

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

}
