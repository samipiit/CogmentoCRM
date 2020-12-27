package pageLib.loginHomepage.settingsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.settingsPage.SettingsPageLocators.*;

public class SettingsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/settings/";

    @FindBy (css = webElementTextHeaderAccountSettings)
    public WebElement textHeaderAccountSettings;

    public SettingsPage() {
        PageFactory.initElements(driver, this);
    }


}
