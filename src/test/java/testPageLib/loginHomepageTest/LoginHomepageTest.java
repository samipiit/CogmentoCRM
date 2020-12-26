package testPageLib.loginHomepageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageLib.calendarPage.CalendarPage;
import pageLib.callsPage.CallsPage;
import pageLib.campaignsPage.CampaignsPage;
import pageLib.casesPage.CasesPage;
import pageLib.companiesPage.CompaniesPage;
import pageLib.contactsPage.ContactsPage;
import pageLib.dealsPage.DealsPage;
import pageLib.documentsPage.DocumentsPage;
import pageLib.emailPage.EmailPage;
import pageLib.formsPage.FormsPage;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.LoginHomepage;
import pageLib.tasksPage.TasksPage;

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

    @Test (enabled = false)
    public void testLeftSideBarBackgroundColor() {
        String actualBackgroundColor = getCSSValueColor(loginHomepage.panelLeftSideBar);

        Assert.assertEquals(actualBackgroundColor, "rgba(0, 0, 0, 0.87)", "BACKGROUND COLOR DOES NOT MATCH");
    }

    @Test (enabled = false)
    public void testLeftSideBarNumOfLinks() {
        int actualNumOfLinks = loginHomepage.getNumOfLinksLeftSideBar();

        Assert.assertEquals(actualNumOfLinks, 12, "INCORRECT NUMBER OF LINKS COUNTED");
    }

    @Test (enabled = false)
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

    @Test
    public void testTitleGridTop1() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv1), "Contacts activity stream", "DIV 1 TITLE DOES NOT MATCH");
    }

    @Test
    public void testTitleGridTop2() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv2), "Deals", "DIV 2 TITLE DOES NOT MATCH");
    }

    @Test
    public void testTitleGridTop3() {
        Assert.assertEquals(getTextFromElement(loginHomepage.textTitleDiv3), "Call Queue", "DIV 3 TITLE DOES NOT MATCH");
    }





//    @Test
//    public void testNavigationToCalendarPage() {
//        CalendarPage calendarPage = loginHomepage.navigateToCalendarPage();
//
//        Assert.assertEquals(getTextFromElement(calendarPage.textCalendarHeader), "Calendar", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToContactsPage() {
//        ContactsPage contactsPage = loginHomepage.navigateToContactsPage();
//
//        Assert.assertEquals(getTextFromElement(contactsPage.textContactsHeader), "Contacts", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToCompaniesPage() {
//        CompaniesPage companiesPage = loginHomepage.navigateToCompaniesPage();
//
//        Assert.assertEquals(getTextFromElement(companiesPage.textCompaniesHeader), "Companies", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToDealsPage() {
//        DealsPage dealsPage = loginHomepage.navigateToDealsPage();
//
//        Assert.assertEquals(getTextFromElement(dealsPage.textDealsHeader), "Deals", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToTasksPage() {
//        TasksPage tasksPage = loginHomepage.navigateToTasksPage();
//
//        Assert.assertEquals(getTextFromElement(tasksPage.textTasksHeader), "Tasks", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToCasesPage() {
//        CasesPage casesPage = loginHomepage.navigateToCasesPage();
//
//        Assert.assertEquals(getTextFromElement(casesPage.textCasesHeader), "Cases", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToCallsPage() {
//        CallsPage callsPage = loginHomepage.navigateToCallsPage();
//
//        Assert.assertEquals(getTextFromElement(callsPage.textCallsHeader), "Calls", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToDocumentsPage() {
//        DocumentsPage documentsPage = loginHomepage.navigateToDocumentsPage();
//
//        Assert.assertEquals(getTextFromElement(documentsPage.textDocumentsHeader), "Documents", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToEmailPage() {
//        EmailPage emailPage = loginHomepage.navigateToEmailPage();
//
//        Assert.assertEquals(getTextFromElement(emailPage.textEmailHeader), "Inbox", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToCampaignsPage() {
//        CampaignsPage campaignsPage = loginHomepage.navigateToCampaignsPage();
//
//        Assert.assertEquals(getTextFromElement(campaignsPage.textCampaignsHeader), "Campaigns", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }
//
//    @Test
//    public void testNavigationToFormsPage() {
//        FormsPage formsPage = loginHomepage.navigateToFormsPage();
//
//        Assert.assertEquals(getTextFromElement(formsPage.textFormsHeader), "Forms", "HEADER TEXT DOES NOT MATCH/NOT FOUND");
//    }

}
