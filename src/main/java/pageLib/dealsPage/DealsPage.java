package pageLib.dealsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.dealsPage.DealsPageLocators.*;

public class DealsPage extends Base {

    @FindBy (css = webElementTextDealsHeader)
    public WebElement textDealsHeader;

    public DealsPage() {
        PageFactory.initElements(driver, this);
    }
}
