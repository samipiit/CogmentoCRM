package CogmentoCRM.loginHomepage.formsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static CogmentoCRM.loginHomepage.formsPage.FormsPageLocators.*;

public class FormsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/forms";

    @FindBy (css = webElementTextFormsHeader)
    public WebElement textFormsHeader;

    public FormsPage() {
        PageFactory.initElements(driver, this);
    }
}
