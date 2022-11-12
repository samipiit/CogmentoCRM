package CogmentoCRM.loginHomepage.campaignsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static CogmentoCRM.loginHomepage.campaignsPage.CampaignsPageLocators.*;

public class CampaignsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/campaigns";

    @FindBy (css = webElementTextCampaignsHeader)
    public WebElement textCampaignsHeader;

    public CampaignsPage() {
        PageFactory.initElements(driver, this);
    }
}
