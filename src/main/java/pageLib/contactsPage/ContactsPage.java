package pageLib.contactsPage;

import base.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static pageLib.contactsPage.ContactsPageLocators.*;

public class ContactsPage extends Base {

    @FindBy (css = webElementTextContactsHeader)
    public WebElement textContactsHeader;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }
}
