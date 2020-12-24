package testPageLib.aboutPageTest;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pageLib.aboutPage.AboutPage;

public class AboutPageTest extends Base {

    public AboutPageTest () { super(); }

    AboutPage aboutPage;

    @BeforeMethod
    @Override
    public void beforeEachMethodInit() {
        super.beforeEachMethodInit();
        aboutPage = new AboutPage();
        aboutPage.navigateToAboutPage();
    }



}