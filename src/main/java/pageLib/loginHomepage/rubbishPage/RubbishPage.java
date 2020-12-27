package pageLib.loginHomepage.rubbishPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.rubbishPage.RubbishPageLocators.*;

public class RubbishPage extends Base {

    public static final String URL = "https://ui.cogmento.com/rubbish/";

    @FindBy (css = webElementTextRubbishBinHeader)
    public WebElement textRubbishBinHeader;

    public RubbishPage() {
        PageFactory.initElements(driver, this);
    }

}
