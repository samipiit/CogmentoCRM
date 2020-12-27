package pageLib.loginHomepage.emailPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.emailPage.EmailPageLocators.*;

public class EmailPage extends Base {

    public static final String URL = "https://ui.cogmento.com/email";

    @FindBy (css = webElementTextEmailHeader)
    public WebElement textEmailHeader;

    public EmailPage() {
        PageFactory.initElements(driver, this);
    }
}
