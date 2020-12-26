package testPageLib.calendarPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageLib.calendarPage.CalendarPage;
import pageLib.homePage.HomePage;

public class CalendarPageTest extends Base {

    CalendarPage calendarPage;

    public CalendarPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        calendarPage = new HomePage()
                .clickLoginButton()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToCalendarPage();
    }
}
