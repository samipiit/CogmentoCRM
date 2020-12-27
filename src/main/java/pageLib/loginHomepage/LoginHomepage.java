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

    public void clickOnExpandSettingsDropdown() {
        clickOnElement(buttonDropdownSettings);
    }

    public SettingsPage clickLinkSettingsSettingsDropdown() {
        clickOnExpandSettingsDropdown();
        clickOnElement(linkSettingsDropdownSettings);

        SettingsPage settingsPage = new SettingsPage();

        waitUntilURLIs(SettingsPage.URL);
        waitUntilVisible(settingsPage.textHeaderAccountSettings);

        return settingsPage;
    }

    public ProductsPage clickLinkProductsSettingsDropdown() {
        clickOnExpandSettingsDropdown();
        clickOnElement(linkSettingsDropdownProducts);

        ProductsPage productsPage = new ProductsPage();

        waitUntilURLIs(ProductsPage.URL);
        waitUntilVisible(productsPage.textHeaderProducts);

        return productsPage;
    }

    public ImportPage clickLinkImportSettingsDropdown() {
        clickOnExpandSettingsDropdown();
        clickOnElement(linksSettingsDropdownImport);

        ImportPage importPage = new ImportPage();

        waitUntilURLIs(ImportPage.URL);
        waitUntilVisible(importPage.textHeaderImport);

        return importPage;
    }

    public ToolsPage clickLinkToolsSettingsDropdown() {
        clickOnExpandSettingsDropdown();
        clickOnElement(linksSettingsDropdownTools);

        ToolsPage toolsPage = new ToolsPage();

        waitUntilURLIs(ToolsPage.URL);
        waitUntilVisible(toolsPage.textHeaderTools);

        return toolsPage;
    }

    public LoginPage doLogout() {
        clickOnExpandSettingsDropdown();
        clickOnElement(linksSettingsDropdownLogOut);

        LoginPage loginPage = new LoginPage();

        waitUntilURLIs(LoginPage.URL);
        waitUntilClickable(loginPage.buttonLoginSubmit);

        return loginPage;
    }

    public RubbishPage navigateToRubbishPage() {
        clickOnElement(buttonRubbishPage);

        waitUntilURLIs(RubbishPage.URL);

        RubbishPage rubbishPage = new RubbishPage();

        waitUntilVisible(rubbishPage.textRubbishBinHeader);

        return rubbishPage;
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

    public LoginHomepage navigateToLoginHomepage() {
        clickOnElement(linkLeftSideBarHome);

        return new LoginHomepage();
    }

    public CalendarPage navigateToCalendarPage() {
        clickOnElement(linkLeftSideBarCalendar);

        waitUntilURLIs(CalendarPage.URL);

        CalendarPage calendarPage = new CalendarPage();

        waitUntilClickable(calendarPage.buttonNewEvent);

        return calendarPage;
    }

    public ContactsPage navigateToContactsPage() {
        clickOnElement(linkLeftSideBarContacts);

        waitUntilURLIs(ContactsPage.URL);

        ContactsPage contactsPage = new ContactsPage();

        waitUntilVisible(contactsPage.textContactsHeader);

        return contactsPage;
    }

    public CompaniesPage navigateToCompaniesPage() {
        clickOnElement(linkLeftSideBarCompanies);

        waitUntilURLIs(CompaniesPage.URL);

        CompaniesPage companiesPage = new CompaniesPage();

        waitUntilVisible(companiesPage.textCompaniesHeader);

        return companiesPage;
    }

    public DealsPage navigateToDealsPage() {
        clickOnElement(linkLeftSideBarDeals);

        waitUntilURLIs(DealsPage.URL);

        DealsPage dealsPage = new DealsPage();

        waitUntilVisible(dealsPage.textDealsHeader);

        return dealsPage;
    }

    public TasksPage navigateToTasksPage() {
        clickOnElement(linkLeftSideBarTasks);

        waitUntilURLIs(TasksPage.URL);

        TasksPage tasksPage = new TasksPage();

        waitUntilVisible(tasksPage.textTasksHeader);

        return tasksPage;
    }

    public CasesPage navigateToCasesPage() {
        clickOnElement(linkLeftSideBarCases);

        waitUntilURLIs(CasesPage.URL);

        CasesPage casesPage = new CasesPage();

        waitUntilVisible(casesPage.textCasesHeader);

        return casesPage;
    }

    public CallsPage navigateToCallsPage() {
        clickOnElement(linkLeftSideBarCalls);

        waitUntilURLIs(CallsPage.URL);

        CallsPage callsPage = new CallsPage();

        waitUntilVisible(callsPage.textCallsHeader);

        return callsPage;
    }

    public DocumentsPage navigateToDocumentsPage() {
        clickOnElement(linkLeftSideBarDocuments);

        waitUntilURLIs(DocumentsPage.URL);

        DocumentsPage documentsPage = new DocumentsPage();

        waitUntilVisible(documentsPage.textDocumentsHeader);

        return documentsPage;
    }

    public EmailPage navigateToEmailPage() {
        clickOnElement(linkLeftSideBarEmail);

        waitUntilURLIs(EmailPage.URL);

        EmailPage emailPage = new EmailPage();

        waitUntilVisible(emailPage.textEmailHeader);

        return emailPage;
    }

    public CampaignsPage navigateToCampaignsPage() {
        clickOnElement(linkLeftSideBarCampaigns);

        waitUntilURLIs(CampaignsPage.URL);

        CampaignsPage campaignsPage = new CampaignsPage();

        waitUntilVisible(campaignsPage.textCampaignsHeader);

        return campaignsPage;
    }

    public FormsPage navigateToFormsPage() {
        clickOnElement(linkLeftSideBarForms);

        waitUntilURLIs(FormsPage.URL);

        FormsPage formsPage = new FormsPage();

        waitUntilVisible(formsPage.textFormsHeader);

        return formsPage;
    }

}
