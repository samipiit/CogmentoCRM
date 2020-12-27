package pageLib.loginHomepage.productsPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.productsPage.ProductsPageLocators.*;

public class ProductsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/products/";

    @FindBy (css = webElementTextHeaderProducts)
    public WebElement textHeaderProducts;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

}
