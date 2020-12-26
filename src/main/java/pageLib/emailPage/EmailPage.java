package pageLib.emailPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.emailPage.EmailPageLocators.*;

public class EmailPage extends Base {

    @FindBy (css = webElementTextEmailHeader)
    public WebElement textEmailHeader;

    public EmailPage() {
        PageFactory.initElements(driver, this);
    }
}
