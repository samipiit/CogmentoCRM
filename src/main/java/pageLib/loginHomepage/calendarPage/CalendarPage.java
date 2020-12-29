package pageLib.loginHomepage.calendarPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.loginHomepage.calendarPage.createNewEventPage.CreateNewEventPage;

import static pageLib.loginHomepage.calendarPage.CalendarPageLocators.*;

public class CalendarPage extends Base {

    public static final String URL = "https://ui.cogmento.com/calendar";

    @FindBy (css = webElementTextCalendarHeader)
    public WebElement textCalendarHeader;

    @FindBy (css = webElementButtonNewEvent)
    public WebElement buttonNewEvent;

    @FindBy (css = webElementButtonSyncNow)
    public WebElement buttonSyncNow;

    public CalendarPage() {
        PageFactory.initElements(driver, this);
    }

    public CreateNewEventPage navigateToCreateNewEventPage() {
        waitUntilClickable(buttonNewEvent);
        clickOnElement(buttonNewEvent);

        return new CreateNewEventPage();
    }


}
