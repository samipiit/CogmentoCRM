package testPageLib.loginHomepageTest.calendarPageTest;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import CogmentoCRM.loginHomepage.calendarPage.CalendarPage;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.calendarPage.createNewEventPage.CreateNewEventPage;

public class CalendarPageTest extends Base {

    CalendarPage calendarPage;
    CreateNewEventPage createNewEventPage;

    public CalendarPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        calendarPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCalendarPage();

        waitUntilURLIs(CalendarPage.URL);
        waitUntilClickable(calendarPage.buttonNewEvent);
    }

    @Test
    public void testNavigationToCreateNewEventPage() {
        createNewEventPage = calendarPage.navigateToCreateNewEventPage();
        waitUntilURLIs(CreateNewEventPage.URL);
        waitUntilClickable(createNewEventPage.buttonSave);

        Assert.assertEquals(getTextFromElement(createNewEventPage.textCreateNewEventHeader),
                "Create new Event", "HEADER TEXT DOES NOT MATCH/NOT FOUND --- DID NOT NAVIGATE TO PRODUCTS PAGE");
    }


}
