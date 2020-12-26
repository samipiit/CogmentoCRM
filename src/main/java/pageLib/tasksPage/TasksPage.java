package pageLib.tasksPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageLib.tasksPage.TasksPageLocators.*;

public class TasksPage extends Base {

    @FindBy (css = webElementTextTasksHeader)
    public WebElement textTasksHeader;

    public TasksPage() {
        PageFactory.initElements(driver, this);
    }
}
