package CogmentoCRM.loginHomepage.tasksPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static CogmentoCRM.loginHomepage.tasksPage.TasksPageLocators.*;

public class TasksPage extends Base {

    public static final String URL = "https://ui.cogmento.com/tasks";

    @FindBy (css = webElementTextTasksHeader)
    public WebElement textTasksHeader;

    public TasksPage() {
        PageFactory.initElements(driver, this);
    }
}
