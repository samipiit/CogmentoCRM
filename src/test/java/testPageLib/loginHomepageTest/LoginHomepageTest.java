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
import pageLib.loginHomepage.tasksPage.TasksPage;

import java.util.List;

public class LoginHomepageTest extends Base {

    LoginHomepage loginHomepage;

    public LoginHomepageTest() {
        super();
    }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        loginHomepage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"));
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
        Assert.assertEquals(loginHomepage
                .clickLinkSettingsSettingsDropdown()
                .textHeaderAccountSettings.getText().trim(),
                "Account Settings\nManage your preferences", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO SETTINGS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToProductsPage() {
        Assert.assertEquals(loginHomepage
                .clickLinkProductsSettingsDropdown()
                .textHeaderProducts.getText(), "Products", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO PRODUCTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToImportPage() {
        Assert.assertEquals(loginHomepage
                .clickLinkImportSettingsDropdown()
                .textHeaderImport.getText(), "Import", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO IMPORT PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToToolsPage() {
        Assert.assertEquals(loginHomepage
                .clickLinkToolsSettingsDropdown()
                .textHeaderTools.getText().trim(),
                "Tools\nTools to manage your data", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO TOOLS PAGE");
    }

    @Test (enabled = true)
    public void testDoLogout() {
        Assert.assertTrue(loginHomepage
                .doLogout()
                .isElementPresent(new LoginPage().inputEmailAddress), "UNABLE TO LOGOUT");
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
        CalendarPage calendarPage = loginHomepage.navigateToCalendarPage();

        Assert.assertEquals(getTextFromElement(calendarPage.textCalendarHeader), "Calendar", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CALENDAR PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToContactsPage() {
        ContactsPage contactsPage = loginHomepage.navigateToContactsPage();

        Assert.assertEquals(getTextFromElement(contactsPage.textContactsHeader), "Contacts", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CONTACTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCompaniesPage() {
        CompaniesPage companiesPage = loginHomepage.navigateToCompaniesPage();

        Assert.assertEquals(getTextFromElement(companiesPage.textCompaniesHeader), "Companies", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO COMPANIES PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToDealsPage() {
        DealsPage dealsPage = loginHomepage.navigateToDealsPage();

        Assert.assertEquals(getTextFromElement(dealsPage.textDealsHeader), "Deals", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO DEALS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToTasksPage() {
        TasksPage tasksPage = loginHomepage.navigateToTasksPage();

        Assert.assertEquals(getTextFromElement(tasksPage.textTasksHeader), "Tasks", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO TASKS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCasesPage() {
        CasesPage casesPage = loginHomepage.navigateToCasesPage();

        Assert.assertEquals(getTextFromElement(casesPage.textCasesHeader), "Cases", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CASES PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCallsPage() {
        CallsPage callsPage = loginHomepage.navigateToCallsPage();

        Assert.assertEquals(getTextFromElement(callsPage.textCallsHeader), "Calls", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CALLS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToDocumentsPage() {
        DocumentsPage documentsPage = loginHomepage.navigateToDocumentsPage();

        Assert.assertEquals(getTextFromElement(documentsPage.textDocumentsHeader), "Documents", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO DOCUMENTS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToEmailPage() {
        EmailPage emailPage = loginHomepage.navigateToEmailPage();

        Assert.assertEquals(getTextFromElement(emailPage.textEmailHeader), "Inbox", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO EMAIL PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToCampaignsPage() {
        CampaignsPage campaignsPage = loginHomepage.navigateToCampaignsPage();

        Assert.assertEquals(getTextFromElement(campaignsPage.textCampaignsHeader), "Campaigns", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO CAMPAIGNS PAGE");
    }

    @Test (enabled = true)
    public void testNavigationToFormsPage() {
        FormsPage formsPage = loginHomepage.navigateToFormsPage();

        Assert.assertEquals(getTextFromElement(formsPage.textFormsHeader), "Forms", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO FORMS PAGE");
    }

}
