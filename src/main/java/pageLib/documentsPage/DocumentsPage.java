package pageLib.documentsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.documentsPage.DocumentsPageLocators.*;

public class DocumentsPage extends Base {

    @FindBy (css = webElementTextDocumentsHeader)
    public WebElement textDocumentsHeader;

    public DocumentsPage() {
        PageFactory.initElements(driver, this);
    }
}
