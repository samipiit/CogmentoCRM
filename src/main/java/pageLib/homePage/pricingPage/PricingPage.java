package pageLib.homePage.pricingPage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import static pageLib.homePage.pricingPage.PricingPageLocators.*;

public class PricingPage extends Base {

    public static final String URL = "https://cogmento.com/pricing.html";

    public PricingPage() {
        PageFactory.initElements(driver, this);
    }
}
