package pageLib.loginHomepage.calendarPage.createNewEventPage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;

import static pageLib.loginHomepage.calendarPage.createNewEventPage.CreateNewEventPageLocators.*;

public class CreateNewEventPage extends Base {

    public static final String URL = "https://ui.cogmento.com/calendar/new";

    @FindBy (css = webElementTextCreateNewEventHeader)
    public WebElement textCreateNewEventHeader;

    @FindBy (css = webElementButtonCancel)
    public WebElement buttonCancel;

    @FindBy (css = webElementButtonSave)
    public WebElement buttonSave;

    @FindBy (css = webElementInputTextBoxTitle)
    public WebElement inputTextBoxTitle;

    @FindBy (css = webElementDropdownButtonCalendar)
    public WebElement dropdownButtonCalendar;

    @FindBy (css = webElementDropdownListBoxCalendar)
    public WebElement dropdownListBoxCalendar;

    @FindBy (css = webElementTextSelectedItemDropdownCalendar)
    public WebElement textSelectedItemDropdownCalendar;

    @FindBy (css = webElementInputTextBoxStartDate)
    public WebElement inputTextBoxStartDate;

    @FindBy (css = webElementInputTextBoxEndDate)
    public WebElement inputTextBoxEndDate;

    @FindBy (css = webElementButtonDatePickerPreviousMonth)
    public WebElement buttonDatePickerPreviousMonth;

    @FindBy (css = webElementButtonDatePickerNextMonth)
    public WebElement buttonDatePickerNextMonth;

    @FindBy (css = webElementDropdownButtonCategory)
    public WebElement dropdownButtonCategory;

    @FindBy (css = webElementDropdownListBoxCategory)
    public WebElement dropdownListBoxCategory;


    public CreateNewEventPage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getTextTitlesFormUILabels() {
        return getListOfElements(By.cssSelector(webElementsTextTitlesFormUILabels));
    }

    public void enterTextInputTextBoxTitle(String eventTitle) {
        sendKeysInputTextBox(inputTextBoxTitle, eventTitle);
    }

    public void clickDropdownButtonCalendar() {
        waitUntilClickable(dropdownButtonCalendar);
        clickOnElement(dropdownButtonCalendar);
    }

    public int getCountDropdownItemsCalendarDropdown() {
        return getSizeListOfElements(By.xpath(webElementsDropdownListItemsCalendar));
    }

    public void selectDropdownItemByNameCalendarDropdown(String dropdownListItemName) {
        List<WebElement> webElementsList = getListOfElements(By.xpath(webElementsDropdownListItemsCalendar));

        int listSize = webElementsList.size();

        for (int i = 0; i < listSize; i++) {
            String elementText = getTextFromElement(webElementsList.get(i));

            if ((elementText.equalsIgnoreCase(dropdownListItemName)) && (!dropdownListItemName.equalsIgnoreCase("New Calendar"))) {
                waitUntilClickable(webElementsList.get(i));
                clickOnElement(webElementsList.get(i));
                break;
            }
        }
    }

    public void selectDropdownItemByIndexCalendarDropdown(int index) {
        List<WebElement> webElementsList = getListOfElements(By.xpath(webElementsDropdownListItemsCalendar));

        int listSize = webElementsList.size();

        if (index > listSize) {
            System.out.println("***SELECTED INDEX OUT OF BOUNDS FOR LIST SIZE " + listSize + "***");
        } else {
            waitUntilClickable(webElementsList.get(index));
            clickOnElement(webElementsList.get(index));
        }
    }

    public void clickDropdownButtonCategory() {
        waitUntilClickable(dropdownButtonCategory);
        clickOnElement(dropdownButtonCategory);
    }

    public void selectDropdownItemByNameCategoryDropdown(String dropdownListItemName) {
        List<WebElement> webElementsList = getListOfElements(By.cssSelector(webElementsDropdownListItemsCategory));

        int listSize = webElementsList.size();

        for (int i = 0; i < listSize; i++) {
            String elementText = getTextFromElement(webElementsList.get(i));

            if (elementText.equalsIgnoreCase(dropdownListItemName)) {
                waitUntilClickable(webElementsList.get(i));
                clickOnElement(webElementsList.get(i));
                break;
            }
        }
    }

    public void selectDropdownItemByIndexCategoryDropdown(int index) {
        List<WebElement> webElementsList = getListOfElements(By.cssSelector(webElementsDropdownListItemsCategory));

        int listSize = webElementsList.size();

        if (index > listSize) {
            System.out.println("***SELECTED INDEX OUT OF BOUNDS FOR LIST SIZE " + listSize + "***");
        } else {
            waitUntilClickable(webElementsList.get(index));
            clickOnElement(webElementsList.get(index));
        }

    }

    public void enterTextInputTextBoxStartDate(String date) {
        sendKeysInputTextBox(inputTextBoxStartDate, date);
    }

    public void enterTextInputTextBoxEndDate(String date) {
        sendKeysInputTextBox(inputTextBoxEndDate, date);
    }


    public void createNewCalendarEvent(String eventTitle, String calendarDropdownListItemName, String startDate,
                                       String endDate, String categoryListItemName) {
        enterTextInputTextBoxTitle(eventTitle);
        clickDropdownButtonCalendar();
        selectDropdownItemByNameCalendarDropdown(calendarDropdownListItemName);
        enterTextInputTextBoxStartDate(startDate);
        enterTextInputTextBoxEndDate(endDate);
        clickDropdownButtonCategory();
        selectDropdownItemByNameCategoryDropdown(categoryListItemName);

    }










}
