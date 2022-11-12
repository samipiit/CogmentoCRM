package testPageLib.loginHomepageTest.tasksPageTest;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import CogmentoCRM.homePage.HomePage;
import CogmentoCRM.loginHomepage.tasksPage.TasksPage;

public class TasksPageTest extends Base {

    TasksPage tasksPage;

    public TasksPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    @Override
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        super.beforeEachMethodInit(browser);
        tasksPage = new HomePage()
                .navigateToLoginPage()
                .doLogin(properties.getProperty("username"), properties.getProperty("password"))
                .navigateToTasksPage();

        waitUntilURLIs(TasksPage.URL);
        waitUntilPresent(tasksPage.textTasksHeader);
    }
}
