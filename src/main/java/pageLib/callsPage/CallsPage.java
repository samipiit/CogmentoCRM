package pageLib.callsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.callsPage.CallsPageLocators.*;

public class CallsPage extends Base {

    @FindBy (css = webElementTextCallsHeader)
    public WebElement textCallsHeader;

    public CallsPage() {
        PageFactory.initElements(driver, this);
    }
}
