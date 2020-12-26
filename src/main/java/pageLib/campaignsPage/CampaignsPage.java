package pageLib.campaignsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.campaignsPage.CampaignsPageLocators.*;

public class CampaignsPage extends Base {

    @FindBy (css = webElementTextCampaignsHeader)
    public WebElement textCampaignsHeader;

    public CampaignsPage() {
        PageFactory.initElements(driver, this);
    }
}
