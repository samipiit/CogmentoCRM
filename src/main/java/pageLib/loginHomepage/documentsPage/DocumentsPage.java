package pageLib.loginHomepage.documentsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.documentsPage.DocumentsPageLocators.*;

public class DocumentsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/documents";

    @FindBy (css = webElementTextDocumentsHeader)
    public WebElement textDocumentsHeader;

    public DocumentsPage() {
        PageFactory.initElements(driver, this);
    }
}
