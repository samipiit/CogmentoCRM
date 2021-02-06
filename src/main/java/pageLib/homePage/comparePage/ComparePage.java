package pageLib.homePage.comparePage;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import static pageLib.homePage.comparePage.ComparePageLocators.*;

public class ComparePage extends Base {

    public static final String URL = "https://cogmento.com/compare.html";

    public ComparePage() {
        PageFactory.initElements(driver, this);
    }


}
