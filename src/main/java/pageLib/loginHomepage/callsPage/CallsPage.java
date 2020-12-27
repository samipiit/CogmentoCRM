package pageLib.loginHomepage.callsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.callsPage.CallsPageLocators.*;

public class CallsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/calls";

    @FindBy (css = webElementTextCallsHeader)
    public WebElement textCallsHeader;

    public CallsPage() {
        PageFactory.initElements(driver, this);
    }
}
