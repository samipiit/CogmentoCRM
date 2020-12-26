package testPageLib.contactsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.contactsPage.ContactsPage;
import pageLib.homePage.HomePage;

public class ContactsPageTest extends Base {

    ContactsPage contactsPage;

    public ContactsPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        contactsPage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToContactsPage();
    }
}
