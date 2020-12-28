package testPageLib.loginHomepageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageLib.loginHomepage.calendarPage.CalendarPage;
import pageLib.loginHomepage.callsPage.CallsPage;
import pageLib.loginHomepage.campaignsPage.CampaignsPage;
import pageLib.loginHomepage.casesPage.CasesPage;
import pageLib.loginHomepage.companiesPage.CompaniesPage;
import pageLib.loginHomepage.contactsPage.ContactsPage;
import pageLib.loginHomepage.dealsPage.DealsPage;
import pageLib.loginHomepage.documentsPage.DocumentsPage;
import pageLib.loginHomepage.emailPage.EmailPage;
import pageLib.loginHomepage.formsPage.FormsPage;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.LoginHomepage;
import pageLib.homePage.loginPage.LoginPage;
import pageLib.loginHomepage.importPage.ImportPage;
import pageLib.loginHomepage.productsPage.ProductsPage;
import pageLib.loginHomepage.settingsPage.SettingsPage;
import pageLib.loginHomepage.tasksPage.TasksPage;
import pageLib.loginHomepage.toolsPage.ToolsPage;

import java.util.List;

public class LoginHomepageTest extends Base {

    LoginHomepage loginHomepage;
    LoginPage loginPage;
    SettingsPage settingsPage;
    ProductsPage productsPage;
    ImportPage importPage;
    ToolsPage toolsPage;
    CalendarPage calendarPage;
    ContactsPage contactsPage;
    CompaniesPage companiesPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
    CasesPage casesPage;
    CallsPage callsPage;
    DocumentsPage documentsPage;
    EmailPage emailPage;
    CampaignsPage campaignsPage;
    FormsPage formsPage;

    public LoginHomepageTest() {
        super();
    }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        loginHomepage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"));

        waitUntilPresent(loginHomepage.textUserNameDisplay);
    }

    @Test (enabled = true)
    public void testClickOnExpandSettingsDropdown() {
        loginHomepage.clickOnExpandSettingsDropdown();

        Assert.assertEquals(loginHomepage
                .buttonDropdownSettings
                .getAttribute("aria-expanded"), "true", "SETTINGS MENU NOT DISPLAYED");
    }

    @Test (enabled = true)
    public void testNavigationToSettingsPage() {
        settingsPage = loginHomepage.navigateToSettingsPage();
        waitUntilURLIs(SettingsPage.URL);
        waitUntilPresent(settingsPage.textHeaderAccountSettings);

        Assert.assertEquals(getTextFromElement(settingsPage.textHeaderAccountSettings).trim(),
                "Account Settings\nManage your preferences", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO SETTINGS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToProductsPage() {
        productsPage = loginHomepage.navigateToProductsPage();
        waitUntilURLIs(ProductsPage.URL);
        waitUntilPresent(productsPage.textHeaderProducts);

        Assert.assertEquals(getTextFromElement(productsPage.textHeaderProducts),
                "Products", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO PRODUCTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToImportPage() {
        importPage = loginHomepage.navigateToImportPage();
        waitUntilURLIs(ImportPage.URL);
        waitUntilPresent(importPage.textHeaderImport);

        Assert.assertEquals(getTextFromElement(importPage.textHeaderImport),
                "Import", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO IMPORT PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToToolsPage() {
        toolsPage = loginHomepage.navigateToToolsPage();
        waitUntilURLIs(ToolsPage.URL);
        waitUntilPresent(toolsPage.textHeaderTools);

        Assert.assertEquals(getTextFromElement(toolsPage.textHeaderTools).trim(),
                "Tools\nTools to manage your data", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO TOOLS PAGE");
    }

    @Test (enabled = true)
    public void testDoLogout() {
        loginPage = loginHomepage.doLogout();
        waitUntilURLIs(LoginPage.URL);

        Assert.assertTrue(isElementPresent(loginPage.inputEmailAddress), "UNABLE TO LOGOUT");
    }

    @Test (enabled = true)
    public void testLeftSideBarBackgroundColor() {
        String actualBackgroundColor = getCSSValueColor(loginHomepage.panelLeftSideBar);

        Assert.assertEquals(actualBackgroundColor, "rgba(0, 0, 0, 0.87)", "BACKGROUND COLOR DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testLeftSideBarNumOfLinks() {
        int actualNumOfLinks = loginHomepage.getNumOfLinksLeftSideBar();

        Assert.assertEquals(actualNumOfLinks, 12, "INCORRECT NUMBER OF LINKS COUNTED");
    }

    @Test (enabled = true)
    public void testLeftSideBarLinks() throws Exception {
        List<String> actualLinksList = loginHomepage.getLinksLeftSideBar();
        String[] expectedLinksList = dataReader.fileReaderStringXSSF(System.getProperty("user.dir") +
                properties.getProperty("testdatapath"), "LoginPageLeftSidebarLinks");

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < actualLinksList.size(); i++) {
            System.out.println("ACTUAL URL: " + actualLinksList.get(i) + "\nEXPECTED URL: " + expectedLinksList[i]);

            softAssert.assertEquals(actualLinksList.get(i), expectedLinksList[i], "URL DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test (enabled = true)
    public void testTitleGridTop1() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv1), "Contacts activity stream", "DIV 1 TITLE DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testTitleGridTop2() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv2), "Deals", "DIV 2 TITLE DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testTitleGridTop3() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv3), "Call Queue", "DIV 3 TITLE DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testTitleGridTop4() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv4), "Upcoming calls", "DIV 4 TITLE DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testTitleGridTop5() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv5), "Twitter", "DIV 5 TITLE DOES NOT MATCH");
    }

    @Test (enabled = true)
    public void testTitleGridTop6() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv6), "Exchange Rates", "DIV 3 TITLE DOES NOT MATCH");
    }


    @Test (enabled = true)
    public void testNavigationToCalendarPage() {
        calendarPage = loginHomepage.navigateToCalendarPage();
        waitUntilURLIs(CalendarPage.URL);

        Assert.assertEquals(getTextFromElement(calendarPage.textCalendarHeader), "Calendar", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CALENDAR PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToContactsPage() {
        contactsPage = loginHomepage.navigateToContactsPage();
        waitUntilURLIs(ContactsPage.URL);

        Assert.assertEquals(getTextFromElement(contactsPage.textContactsHeader), "Contacts", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CONTACTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCompaniesPage() {
        companiesPage = loginHomepage.navigateToCompaniesPage();
        waitUntilURLIs(CompaniesPage.URL);

        Assert.assertEquals(getTextFromElement(companiesPage.textCompaniesHeader), "Companies", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO COMPANIES PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToDealsPage() {
        dealsPage = loginHomepage.navigateToDealsPage();
        waitUntilURLIs(DealsPage.URL);

        Assert.assertEquals(getTextFromElement(dealsPage.textDealsHeader), "Deals", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO DEALS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToTasksPage() {
        tasksPage = loginHomepage.navigateToTasksPage();
        waitUntilURLIs(TasksPage.URL);

        Assert.assertEquals(getTextFromElement(tasksPage.textTasksHeader), "Tasks", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO TASKS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCasesPage() {
        casesPage = loginHomepage.navigateToCasesPage();
        waitUntilURLIs(CasesPage.URL);

        Assert.assertEquals(getTextFromElement(casesPage.textCasesHeader), "Cases", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CASES PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCallsPage() {
        callsPage = loginHomepage.navigateToCallsPage();
        waitUntilURLIs(CallsPage.URL);

        Assert.assertEquals(getTextFromElement(callsPage.textCallsHeader), "Calls", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CALLS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToDocumentsPage() {
        documentsPage = loginHomepage.navigateToDocumentsPage();
        waitUntilURLIs(DocumentsPage.URL);

        Assert.assertEquals(getTextFromElement(documentsPage.textDocumentsHeader), "Documents", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO DOCUMENTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToEmailPage() {
        emailPage = loginHomepage.navigateToEmailPage();
        waitUntilURLIs(EmailPage.URL);

        Assert.assertEquals(getTextFromElement(emailPage.textEmailHeader), "Inbox", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO EMAIL PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCampaignsPage() {
        campaignsPage = loginHomepage.navigateToCampaignsPage();
        waitUntilURLIs(CampaignsPage.URL);

        Assert.assertEquals(getTextFromElement(campaignsPage.textCampaignsHeader), "Campaigns", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CAMPAIGNS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToFormsPage() {
        formsPage = loginHomepage.navigateToFormsPage();
        waitUntilURLIs(FormsPage.URL);

        Assert.assertEquals(getTextFromElement(formsPage.textFormsHeader), "Forms", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO FORMS PAGE");
    }

}
