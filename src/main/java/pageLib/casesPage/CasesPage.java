package pageLib.casesPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.casesPage.CasesPageLocators.*;

public class CasesPage extends Base {

    @FindBy (css = webElementTextCasesHeader)
    public WebElement textCasesHeader;

    public CasesPage() {
        PageFactory.initElements(driver, this);
    }
}
