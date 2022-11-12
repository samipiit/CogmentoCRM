package testPageLib.loginHomepageTest.contactsPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.loginHomepage.contactsPage.ContactsPage;
import CogmentoCRM.homePage.HomePage;

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
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToContactsPage();

        waitUntilURLIs(ContactsPage.URL);
        waitUntilPresent(contactsPage.textContactsHeader);
    }
}
