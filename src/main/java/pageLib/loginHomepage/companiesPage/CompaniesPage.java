package pageLib.loginHomepage.companiesPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.loginHomepage.companiesPage.CompaniesPageLocators.*;

public class CompaniesPage extends Base {

    public static final String URL = "https://ui.cogmento.com/companies";

    @FindBy (css = webElementTextCompaniesHeader)
    public WebElement textCompaniesHeader;

    public CompaniesPage() {
        PageFactory.initElements(driver, this);
    }
}
