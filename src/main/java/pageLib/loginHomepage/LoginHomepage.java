package pageLib.loginHomepage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
import pageLib.tasksPage.TasksPage;

import java.util.ArrayList;
import java.util.List;

import static pageLib.loginHomepage.LoginHomepageLocators.*;

public class LoginHomepage extends Base {

    @FindBy (css = webElementTextUserNameDisplay)
    public WebElement textUserNameDisplay;

    @FindBy (css = webElementPanelLeftSideBar)
    public WebElement panelLeftSideBar;

    @FindBy (css = webElementLinkLeftSideBarHome)
    public WebElement linkLeftSideBarHome;

    @FindBy (css = webElementLinkLeftSideBarCalendar)
    public WebElement linkLeftSideBarCalendar;

    @FindBy (css = webElementLinkLeftSideBarContacts)
    public WebElement linkLeftSideBarContacts;

    @FindBy (css = webElementLinkLeftSideBarCompanies)
    public WebElement linkLeftSideBarCompanies;

    @FindBy (css = webElementLinkLeftSideBarDeals)
    public WebElement linkLeftSideBarDeals;

    @FindBy (css = webElementLinkLeftSideBarTasks)
    public WebElement linkLeftSideBarTasks;

    @FindBy (css = webElementLinkLeftSideBarCases)
    public WebElement linkLeftSideBarCases;

    @FindBy (css = webElementLinkLeftSideBarCalls)
    public WebElement linkLeftSideBarCalls;

    @FindBy (css = webElementLinkLeftSideBarDocuments)
    public WebElement linkLeftSideBarDocuments;

    @FindBy (css = webElementLinkLeftSideBarEmail)
    public WebElement linkLeftSideBarEmail;

    @FindBy (css = webElementLinkLeftSideBarCampaigns)
    public WebElement linkLeftSideBarCampaigns;

    @FindBy (css = webElementLinkLeftSideBarForms)
    public WebElement linkLeftSideBarForms;

    @FindBy (css = webElementTextTitleDiv1)
    public WebElement textTitleDiv1;

    @FindBy (xpath = webElementTextTitleDiv2)
    public WebElement textTitleDiv2;

    @FindBy (xpath = webElementTextTitleDiv3)
    public WebElement textTitleDiv3;

    public LoginHomepage() {
        PageFactory.initElements(driver, this);
    }

    public int getNumOfLinksLeftSideBar() {
        return getNumberOfLinks(By.cssSelector(webElementsLinksLeftSideBar));
    }

    public List<String> getLinksLeftSideBar() {
        List<WebElement> webElementList = getListOfElements(By.cssSelector(webElementsLinksLeftSideBar));
        List<String> linksList = new ArrayList<>();

        for (WebElement element : webElementList) {
            linksList.add(element.getAttribute("href")) ;
        }

        return linksList;
    }

    public CalendarPage navigateToCalendarPage() {
        clickOnElement(linkLeftSideBarCalendar);

        waitUntilURLIs("https://ui.cogmento.com/calendar");

        return new CalendarPage();
    }

    public ContactsPage navigateToContactsPage() {
        clickOnElement(linkLeftSideBarContacts);

        waitUntilURLIs("https://ui.cogmento.com/contacts");

        return new ContactsPage();
    }

    public CompaniesPage navigateToCompaniesPage() {
        clickOnElement(linkLeftSideBarCompanies);

        waitUntilURLIs("https://ui.cogmento.com/companies");

        return new CompaniesPage();
    }

    public DealsPage navigateToDealsPage() {
        clickOnElement(linkLeftSideBarDeals);

        waitUntilURLIs("https://ui.cogmento.com/deals");

        return new DealsPage();
    }

    public TasksPage navigateToTasksPage() {
        clickOnElement(linkLeftSideBarTasks);

        waitUntilURLIs("https://ui.cogmento.com/tasks");

        return new TasksPage();
    }

    public CasesPage navigateToCasesPage() {
        clickOnElement(linkLeftSideBarCases);

        waitUntilURLIs("https://ui.cogmento.com/cases");

        return new CasesPage();
    }

    public CallsPage navigateToCallsPage() {
        clickOnElement(linkLeftSideBarCalls);

        waitUntilURLIs("https://ui.cogmento.com/calls");

        return new CallsPage();
    }

    public DocumentsPage navigateToDocumentsPage() {
        clickOnElement(linkLeftSideBarDocuments);

        waitUntilURLIs("https://ui.cogmento.com/documents");

        return new DocumentsPage();
    }

    public EmailPage navigateToEmailPage() {
        clickOnElement(linkLeftSideBarEmail);

        waitUntilURLIs("https://ui.cogmento.com/email");

        return new EmailPage();
    }

    public CampaignsPage navigateToCampaignsPage() {
        clickOnElement(linkLeftSideBarCampaigns);

        waitUntilURLIs("https://ui.cogmento.com/campaigns");

        return new CampaignsPage();
    }

    public FormsPage navigateToFormsPage() {
        clickOnElement(linkLeftSideBarForms);

        waitUntilURLIs("https://ui.cogmento.com/forms");

        return new FormsPage();
    }

}
