package pageLib.loginHomepage.importPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.importPage.ImportPageLocators.*;

public class ImportPage extends Base {

    public static final String URL = "https://ui.cogmento.com/import/";

    @FindBy (css = webElementTextHeaderImport)
    public WebElement textHeaderImport;

    public ImportPage() {
        PageFactory.initElements(driver, this);
    }
}
