package pageLib.companiesPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.companiesPage.CompaniesPageLocators.*;

public class CompaniesPage extends Base {

    @FindBy (css = webElementTextCompaniesHeader)
    public WebElement textCompaniesHeader;

    public CompaniesPage() {
        PageFactory.initElements(driver, this);
    }
}
