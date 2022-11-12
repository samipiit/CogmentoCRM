package testPageLib.loginHomepageTest.productsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.productsPage.ProductsPage;

public class ProductsPageTest extends Base {

    ProductsPage productsPage;

    public ProductsPageTest() {
        super();
    }

    @BeforeMethod
    @Override
    public void beforeEachMethodInit(String browser) {
        super.beforeEachMethodInit(browser);
        productsPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToProductsPage();

        waitUntilURLIs(ProductsPage.URL);
        waitUntilPresent(productsPage.textHeaderProducts);
    }
}
