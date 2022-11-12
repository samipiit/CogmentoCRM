package CogmentoCRM.loginHomepage.calendarPage.createNewEventPage;

public class CreateNewEventPageLocators {

    /**
     * HEADER
     */
    public static final String webElementTextCreateNewEventHeader = "div.ui.header.item.mb5.light-black";
    public static final String webElementButtonCancel = "button[class='ui button']";
    public static final String webElementButtonSave = "button[class='ui linkedin button']";

    /**
     * BODY
     */
    public static final String webElementsTextTitlesFormUILabels = "div.ui.fluid.container.main-content > form div[class='ui field'] > label:nth-child(1)";
    public static final String webElementInputTextBoxTitle = "input[name=title]";

    public static final String webElementDropdownButtonCalendar = "div[name=calendar]";
    public static final String webElementDropdownListBoxCalendar = "div.visible.menu.transition";
    public static final String webElementTextSelectedItemDropdownCalendar = "div[name='calendar'] > div.divider.text";
    public static final String webElementsDropdownListItemsCalendar = "//div[@name='calendar']/div[@class='visible menu transition']/div[@role]";

    public static String getWebElementsDropdownListItemCalendar(int listItem) {
        return webElementsDropdownListItemsCalendar + "[" + listItem + "]";
    }

    public static final String webElementInputTextBoxStartDate = "div[class='two fields'] > div:nth-child(1) input[class='calendarField']";
    public static final String webElementInputTextBoxEndDate = "div[class='two fields'] > div:nth-child(2) input[class='calendarField']";
    public static final String webElementButtonDatePickerPreviousMonth = "button.react-datepicker__navigation.react-datepicker__navigation--previous";
    public static final String webElementButtonDatePickerNextMonth = "button.react-datepicker__navigation.react-datepicker__navigation--next.react-datepicker__navigation--next--with-time";
    public static final String webElementsDatePickerRowsOfWeeks = "div.react-datepicker__month > div";
    public static final String webElementsTimePickerListOfTimes15MinIntervals = "div.react-datepicker__time ul li";

    public static final String webElementDropdownButtonCategory = "div[name='category'][role='listbox']";
    public static final String webElementDropdownListBoxCategory = "div[class='visible menu transition']";
    public static final String webElementsDropdownListItemsCategory = "div[class='visible menu transition'] div";
    public static String getWebElementDropdownListItemCategory(int listItem) {
        return webElementsDropdownListItemsCategory + ":nth-child(" + listItem + ")";
    }

    public static String getWebElementsDropdownListItemsTextCategory(int listItem) {
        return "div[class='visible menu transition'] div:nth-child(" + listItem + ") span";
    }

    public static final String webElementInputTextBoxTags = "form[class='ui form segment custom-form-container'] > div:nth-child(4) div[role='combobox'] input";
    public static final String webElementsMultiSelectableListItemsTags = "form[class='ui form segment custom-form-container'] > div:nth-child(4) div[role='combobox'] > div span";

    public static final String webElementInputTextBoxDescription = "";
    public static final String webElementInputTextBoxLocation = "";
    public static final String webElementToggleSwitchAllDay = "";
    public static final String webElementInputTextBoxDeal = "";
    public static final String webElementInputTextBoxTask = "";
    public static final String webElementInputTextBoxCase = "";
    public static final String webElementDropdownAlertBefore = "";
    public static final String webElementDropdownAlertVia = "";
    public static final String webElementInputTextBoxReminderTime = "";
    public static final String webElementDropdownAssignedTo = "";
    public static final String webElementInputTextBoxParticipants = "";
    public static final String webElementInputTextBoxCompany = "";
    public static final String webElementLinkButtonRecurrence = "";


}
