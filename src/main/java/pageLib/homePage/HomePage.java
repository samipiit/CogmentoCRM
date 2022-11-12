package pageLib.homePage;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLib.homePage.aboutPage.AboutPage;
import pageLib.homePage.comparePage.ComparePage;
import pageLib.homePage.loginPage.LoginPage;
import pageLib.homePage.pricingPage.PricingPage;
import pageLib.homePage.registerPage.RegisterPage;
import pageLib.homePage.supportPage.SupportPage;

import static pageLib.homePage.HomePageLocators.*;

public class HomePage extends Base {

    @FindBy (css = webElementButtonAbout)
    public WebElement buttonAbout;

    @FindBy (css = webElementButtonCRM)
    public WebElement buttonCRM;

    @FindBy (css = webElementDropdownButtonCRM)
    public WebElement dropdownButtonCRM;

    @FindBy (css = webElementButtonApps)
    public WebElement buttonApps;

    @FindBy (css = webElementDropdownButtonApps)
    public WebElement dropdownButtonApps;

    @FindBy (css = webElementButtonCompare)
    public WebElement buttonCompare;

    @FindBy (css = webElementButtonPricing)
    public WebElement buttonPricing;

    @FindBy (css = webElementButtonAppleiTunes)
    public WebElement buttonAppleiTunes;

    @FindBy (css = webElementButtonGooglePlayStore)
    public WebElement buttonGooglePlayStore;

    @FindBy (css = webElementButtonSupport)
    public WebElement buttonSupport;

    @FindBy (css = webElementButtonLogin)
    public WebElement buttonLogin;

    @FindBy (css = webElementButtonSignUpSection1)
    public WebElement buttonSignUpSection1;

    @FindBy (css = webElementTextHeaderSection1)
    public WebElement textHeaderSection1;

    @FindBy (css = webElementTextHeader1Section2)
    public WebElement textHeader1Section2;

    @FindBy (css = webElementTextHeader2Section2)
    public WebElement textHeader2Section2;

    @FindBy (css = webElementTextHeader3Section2)
    public WebElement textHeader3Section2;

    @FindBy (css = webElementTextBody1Section2)
    public WebElement textBody1Section2;

    @FindBy (css = webElementTextBody2Section2)
    public WebElement textBody2Section2;

    @FindBy (css = webElementTextBody3Section2)
    public WebElement textBody3Section2;

    @FindBy (css = webElementImage1Section2)
    public WebElement image1Section2;

    @FindBy (css = webElementImage2Section2)
    public WebElement image2Section2;

    @FindBy (css = webElementImage3Section2)
    public WebElement image3Section2;

    @FindBy (css = webElementiFrameVideoSection4)
    public WebElement iFrameVideoSection4;

    @FindBy (css = webElementButtonPlayYouTubeSection4)
    public WebElement buttonPlayYouTubeSection4;

    @FindBy (css = webElementYouTubeVideoPlaying)
    public WebElement youTubeVideoPlaying;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public int getNumOfHeaderLinks() {
        return getSizeListOfElements(By.cssSelector(webElementsLinksHeader));
    }

    public AboutPage navigateToAboutPage() {
        clickOnElement(buttonAbout);

        return new AboutPage();
    }

    public RegisterPage clickLinkCRM() {
        clickOnElement(buttonCRM);

        return new RegisterPage();
    }

    public void clickDropdownButtonCRM() {
        clickOnElement(dropdownButtonCRM);
    }

    public HomePage clickLinkApps() {
        clickOnElement(buttonApps);

        return new HomePage();
    }

    public void clickDropdownButtonApps() {
        clickOnElement(dropdownButtonApps);
    }

    public ComparePage navigateToComparePage() {
        clickOnElement(buttonCompare);

        return new ComparePage();
    }

    public PricingPage navigateToPricingPage() {
        clickOnElement(buttonPricing);

        return new PricingPage();
    }

    public void clickLinkAppleiTunesStore() {
        clickOnElement(buttonAppleiTunes);
    }

    public void clickLinkGooglePlayStore() {
        clickOnElement(buttonGooglePlayStore);
    }

    public SupportPage navigateToSupportPage() {
        clickOnElement(buttonSupport);

        switchToTab(1);

        return new SupportPage();
    }

    public LoginPage navigateToLoginPage() {
        clickOnElement(buttonLogin);

        return new LoginPage();
    }

    public RegisterPage clickButtonSignUpSection1() {
        clickOnElement(buttonSignUpSection1);

        return new RegisterPage();
    }

    public String getBackgroundColorBeforeHoverButtonSignUpSection1() {
        return getCSSValueBackgroundColor(buttonSignUpSection1);
    }

    public String getURLVideoSection4() {
        return getTextFromElementUsingAttribute(iFrameVideoSection4, "src");
    }

    public void switchToiFrameVideoSection4() {
        switchToiFrameElement(iFrameVideoSection4);
    }

    public void playYouTubeVideoSection4() {
        switchToiFrameVideoSection4();

        waitUntilClickable(buttonPlayYouTubeSection4);
        clickOnElement(buttonPlayYouTubeSection4);
        try {
            Thread.sleep(4000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
