package testPageLib.loginHomepageTest.calendarPageTest.createNewEventPageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pageLib.homePage.HomePage;
import pageLib.loginHomepage.calendarPage.createNewEventPage.CreateNewEventPage;

import java.io.IOException;

public class CreateNewEventPageTest extends Base {

    CreateNewEventPage createNewEventPage;

    public CreateNewEventPageTest() {
        super();
    }

    @Parameters ("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        createNewEventPage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCalendarPage()
                .clickNewEventButton();
    }

    @Test
    public void testTitlesFormUILabels() throws IOException {
        Assert.assertTrue(compareWebElementListOfAttributesToExpectedStringArray(createNewEventPage.getTextTitlesFormUILabels(),"innerHTML",
                System.getProperty("user.dir") + properties.getProperty("testdatapath"), "CreateNewEventFormTitles"));
    }

    @Test
    public void testInputTextTitleField(@Optional("New Calendar Event") String eventTitle) {
        createNewEventPage.enterTextInputTextBoxTitle(eventTitle);

        Assert.assertEquals(getTextFromElementUsingAttribute(createNewEventPage.inputTextBoxTitle, "value"), "New Calendar Event", "INPUT TEXT DOES NOT MATCH");
    }

    @Test
    public void testCountDropdownListItemsCalendarDropdown() {
        createNewEventPage.clickDropdownButtonCalendar();

        Assert.assertEquals(createNewEventPage.getCountDropdownItemsCalendarDropdown(), 2, "NUMBER OF LIST ITEMS DO NOT MATCH");
    }

    @Test
    public void testSelectDropdownListItemCalendarDropdown() {
        createNewEventPage.clickDropdownButtonCalendar();
        createNewEventPage.selectDropdownItemByNameCalendarDropdown("Sami Sheikh <ameikh645@gmail.com>");

        Assert.assertEquals(getTextFromElement(createNewEventPage.dropdownButtonCalendar), "Sami Sheikh <ameikh645@gmail.com>", "INCORRECT DROPDOWN ITEM SELECTED");
    }








}
