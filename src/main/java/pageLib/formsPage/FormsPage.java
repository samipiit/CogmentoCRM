package pageLib.formsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.formsPage.FormsPageLocators.*;

public class FormsPage extends Base {

    @FindBy (css = webElementTextFormsHeader)
    public WebElement textFormsHeader;

    public FormsPage() {
        PageFactory.initElements(driver, this);
    }
}
