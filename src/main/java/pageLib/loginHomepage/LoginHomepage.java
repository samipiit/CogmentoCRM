package pageLib.loginHomepage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pageLib.loginHomepage.importPage.ImportPage;
import pageLib.homePage.loginPage.LoginPage;
import pageLib.loginHomepage.productsPage.ProductsPage;
import pageLib.loginHomepage.rubbishPage.RubbishPage;
import pageLib.loginHomepage.settingsPage.SettingsPage;
import pageLib.loginHomepage.tasksPage.TasksPage;
import pageLib.loginHomepage.toolsPage.ToolsPage;

import java.util.ArrayList;
import java.util.List;

import static pageLib.loginHomepage.LoginHomepageLocators.*;

public class LoginHomepage extends Base {

    @FindBy (css = webElementTextUserNameDisplay)
    public WebElement textUserNameDisplay;

    @FindBy (css = webElementButtonRubbishPage)
    public WebElement buttonRubbishPage;

    @FindBy (css = webElementButtonDropdownSettings)
    public WebElement buttonDropdownSettings;

    @FindBy (xpath = webElementLinkSettingsDropdownSettings)
    public WebElement linkSettingsDropdownSettings;

    @FindBy (xpath = webElementLinkSettingsDropdownProducts)
    public WebElement linkSettingsDropdownProducts;

    @FindBy (xpath = webElementLinkSettingsDropdownImport)
    public WebElement linksSettingsDropdownImport;

    @FindBy (xpath = webElementLinkSettingsDropdownTools)
    public WebElement linksSettingsDropdownTools;

    @FindBy (xpath = webElementLinkSettingsDropdownLogOut)
    public WebElement linksSettingsDropdownLogOut;

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

    @FindBy (xpath = webElementTextTitleDiv4)
    public WebElement textTitleDiv4;

    @FindBy (xpath = webElementTextTitleDiv5)
    public WebElement textTitleDiv5;

    @FindBy (xpath = webElementTextTitleDiv6)
    public WebElement textTitleDiv6;

    public LoginHomepage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * HEADER
     */

    public void clickOnExpandSettingsDropdown() {
        clickOnElement(buttonDropdownSettings);
    }

    public SettingsPage navigateToSettingsPage() {
        clickOnExpandSettingsDropdown();
        waitUntilSelectable(linkSettingsDropdownSettings);
        clickOnElement(linkSettingsDropdownSettings);

        return new SettingsPage();
    }

    public ProductsPage navigateToProductsPage() {
        clickOnExpandSettingsDropdown();
        waitUntilSelectable(linkSettingsDropdownProducts);
        clickOnElement(linkSettingsDropdownProducts);

        return new ProductsPage();
    }

    public ImportPage navigateToImportPage() {
        clickOnExpandSettingsDropdown();
        waitUntilSelectable(linksSettingsDropdownImport);
        clickOnElement(linksSettingsDropdownImport);

        return new ImportPage();
    }

    public ToolsPage navigateToToolsPage() {
        clickOnExpandSettingsDropdown();
        waitUntilSelectable(linksSettingsDropdownTools);
        clickOnElement(linksSettingsDropdownTools);

        return new ToolsPage();
    }

    public LoginPage doLogout() {
        clickOnExpandSettingsDropdown();
        waitUntilSelectable(linksSettingsDropdownLogOut);
        clickOnElement(linksSettingsDropdownLogOut);

        return new LoginPage();
    }

    public RubbishPage navigateToRubbishPage() {
        waitUntilSelectable(buttonRubbishPage);
        clickOnElement(buttonRubbishPage);

        return new RubbishPage();
    }



    /**
     * LEFT SIDE BAR
     */

    public int getNumOfLinksLeftSideBar() {
        return getSizeListOfElements(By.cssSelector(webElementsLinksLeftSideBar));
    }

    public List<String> getLinksLeftSideBar() {
        List<WebElement> webElementList = getListOfElements(By.cssSelector(webElementsLinksLeftSideBar));
        List<String> linksList = new ArrayList<>();

        for (WebElement element : webElementList) {
            linksList.add(element.getAttribute("href")) ;
        }

        return linksList;
    }

    public LoginHomepage navigateToLoginHomepage() {
        waitUntilSelectable(linkLeftSideBarHome);
        clickOnElement(linkLeftSideBarHome);

        return new LoginHomepage();
    }

    public CalendarPage navigateToCalendarPage() {
        waitUntilSelectable(linkLeftSideBarCalendar);
        clickOnElement(linkLeftSideBarCalendar);

        return new CalendarPage();
    }

    public ContactsPage navigateToContactsPage() {
        waitUntilSelectable(linkLeftSideBarContacts);
        clickOnElement(linkLeftSideBarContacts);

        return new ContactsPage();
    }

    public CompaniesPage navigateToCompaniesPage() {
        waitUntilSelectable(linkLeftSideBarCompanies);
        clickOnElement(linkLeftSideBarCompanies);

        return new CompaniesPage();
    }

    public DealsPage navigateToDealsPage() {
        waitUntilSelectable(linkLeftSideBarDeals);
        clickOnElement(linkLeftSideBarDeals);

        return new DealsPage();
    }

    public TasksPage navigateToTasksPage() {
        waitUntilSelectable(linkLeftSideBarTasks);
        clickOnElement(linkLeftSideBarTasks);

        return new TasksPage();
    }

    public CasesPage navigateToCasesPage() {
        waitUntilSelectable(linkLeftSideBarCases);
        clickOnElement(linkLeftSideBarCases);

        return new CasesPage();
    }

    public CallsPage navigateToCallsPage() {
        waitUntilSelectable(linkLeftSideBarCalls);
        clickOnElement(linkLeftSideBarCalls);

        return new CallsPage();
    }

    public DocumentsPage navigateToDocumentsPage() {
        waitUntilSelectable(linkLeftSideBarDocuments);
        clickOnElement(linkLeftSideBarDocuments);

        return new DocumentsPage();
    }

    public EmailPage navigateToEmailPage() {
        waitUntilSelectable(linkLeftSideBarEmail);
        clickOnElement(linkLeftSideBarEmail);

        return new EmailPage();
    }

    public CampaignsPage navigateToCampaignsPage() {
        waitUntilSelectable(linkLeftSideBarCampaigns);
        clickOnElement(linkLeftSideBarCampaigns);

        return new CampaignsPage();
    }

    public FormsPage navigateToFormsPage() {
        waitUntilSelectable(linkLeftSideBarForms);
        clickOnElement(linkLeftSideBarForms);

        return new FormsPage();
    }

}
