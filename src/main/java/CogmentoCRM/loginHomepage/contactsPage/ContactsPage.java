package CogmentoCRM.loginHomepage.contactsPage;

import base.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static CogmentoCRM.loginHomepage.contactsPage.ContactsPageLocators.*;

public class ContactsPage extends Base {

    public static final String URL = "https://ui.cogmento.com/contacts";

    @FindBy (css = webElementTextContactsHeader)
    public WebElement textContactsHeader;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }
}
