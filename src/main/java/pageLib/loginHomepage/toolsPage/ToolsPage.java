package pageLib.loginHomepage.toolsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.toolsPage.ToolsPageLocators.*;

public class ToolsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/tools/";

    @FindBy (css = webElementTextHeaderTools)
    public WebElement textHeaderTools;

    public ToolsPage() {
        PageFactory.initElements(driver, this);
    }

}
