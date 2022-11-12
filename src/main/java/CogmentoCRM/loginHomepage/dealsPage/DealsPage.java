package CogmentoCRM.loginHomepage.dealsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static CogmentoCRM.loginHomepage.dealsPage.DealsPageLocators.*;

public class DealsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/deals";

    @FindBy (css = webElementTextDealsHeader)
    public WebElement textDealsHeader;

    public DealsPage() {
        PageFactory.initElements(driver, this);
    }
}
