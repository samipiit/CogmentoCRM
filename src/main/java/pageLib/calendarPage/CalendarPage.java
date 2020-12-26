package pageLib.calendarPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.calendarPage.CalendarPageLocators.*;

public class CalendarPage extends Base {

    @FindBy (css = webElementTextCalendarHeader)
    public WebElement textCalendarHeader;

    public CalendarPage() {
        PageFactory.initElements(driver, this);
    }


}
