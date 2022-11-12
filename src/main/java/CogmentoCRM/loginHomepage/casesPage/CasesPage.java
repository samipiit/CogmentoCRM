package CogmentoCRM.loginHomepage.casesPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static CogmentoCRM.loginHomepage.casesPage.CasesPageLocators.*;

public class CasesPage extends Base {

    public static final String URL = "https://ui.cogmento.com/cases";

    @FindBy (css = webElementTextCasesHeader)
    public WebElement textCasesHeader;

    public CasesPage() {
        PageFactory.initElements(driver, this);
    }
}
