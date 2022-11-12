package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import base.utils.DataReader;
import base.utils.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static EventFiringWebDriver eventFiringWebDriver;
    public static WebDriverWait webDriverWait;
    public static FluentWait fluentWait;
    public static Actions webDriverAction;
    public static Properties properties;
    public static DataReader dataReader;
    public static ExtentReports extent;

    public Base() {

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dataReader = new DataReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initDriver(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebEventListener());

        driver = eventFiringWebDriver;
    }

    @BeforeSuite
    public void beforeSuiteExtentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void beforeEachMethodExtentInit(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        ExtentTestManager.startTest(methodName);
        ExtentTestManager.getTest().assignCategory(className);

        System.out.println("\n\t***" + methodName + "***\n");
    }


    @Parameters({"browser"})
    @BeforeMethod
    public void beforeEachMethodInit(@Optional("chrome") String browser) {
        initDriver(browser);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = properties.getProperty("url");
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {

        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName());
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            captureScreenshot(driver, result.getName());

        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());
        }
        ExtentTestManager.endTest();
        extent.flush();

        driver.quit();
    }

    @AfterSuite
    private void afterSuiteCloseExtent() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * Method to capture screenshot & store in .png file in specified directory
     */
    private static void captureScreenshot(WebDriver driver, String testName) {
        String fileName = testName + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "test" + File.separator + "resources" + File.separator + "fail_screenshots" +
                File.separator + fileName);

        try {
            FileHandler.copy(screenshot, newScreenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }
    }


    /**
     * UTILITY METHODS
     */
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void switchToParentTab() {
        driver.switchTo().defaultContent();
    }

    public void switchToTab(int tabIndexToSwitchTo) {

        List<String> tabs = new ArrayList<String> (driver.getWindowHandles());

        try {
            driver.switchTo().window(tabs.get(tabIndexToSwitchTo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToiFrameElement(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToiFrameIndex(int frameIndex) {
        try {
            driver.switchTo().frame(frameIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToiFrameNameOrID(String iFrameNameOrID) {
        try {
            driver.switchTo().frame(iFrameNameOrID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mouseHover(WebElement element) {
        try {
            Actions hover = new Actions(driver);
            hover.moveToElement(element).perform();
        } catch (Exception ex) {
            driver.navigate().refresh();
            System.out.println("1st mouse-hover attempt failed - Attempting 2nd time");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            Actions hover = new Actions(driver);

            wait.until(ExpectedConditions.visibilityOf(element));
            hover.moveToElement(element).perform();
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            try {
                webDriverAction = new Actions(driver)
                        .moveToElement(element)
                        .click(element);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void sendKeysInputTextBox(WebElement element, String keysToInput) {
        try {
            element.sendKeys(keysToInput);
        } catch (Exception e) {
            try {
                webDriverAction = new Actions(driver)
                        .sendKeys(element, keysToInput);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void clearInputTextBox(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCSSValueColor(WebElement element) {
        return element.getCssValue("color");
    }

    public String getCSSValueBackgroundColor(WebElement element) {
        return element.getCssValue("background-color");
    }

    public String getTextFromElement(WebElement element) {
        String text = "";

        try {
            text = element.getText().trim();
        } catch (Exception e) {
            try {
                text = element.getAttribute("innerHTML").trim();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return text;
    }

    public String getTextFromElementUsingAttribute(WebElement element, String attribute) {
        String text = "";

        try {
            text = element.getAttribute(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    public List<String> getListOfStringsTextFromElement(By locator) {
        List<WebElement> webElementsList = driver.findElements(locator);
        List<String> webElementsTextList = new ArrayList<>();

        for (WebElement element : webElementsList) {
            webElementsTextList.add(element.getText());
        }

        return webElementsTextList;
    }

    public List<WebElement> getListOfElements(By by) {
        List<WebElement> list = new ArrayList<>();

        try {
            list = driver.findElements(by);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getSizeListOfElements(By by) {
        List<WebElement> list = new ArrayList<>();

        try {
            list = driver.findElements(by);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.size();
    }


    /**
     * Javascript Helper Methods
     */

    public static void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            System.out.println("NO SUCH ELEMENT - " + element);
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            System.out.println("STALE ELEMENT - " + element);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("COULD NOT CLICK ON ELEMENT - " + element);
            e.printStackTrace();
        }
    }

    public void scrollToElementJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (NoSuchElementException e) {
            System.out.println("NO SUCH ELEMENT - " + element);
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            System.out.println("STALE ELEMENT - " + element);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("COULD NOT SCROLL TO ELEMENT - " + element);
            e.printStackTrace();
        }
    }

    public static void mouseHoverJScript(WebElement element) {
        try {
            if (isElementPresent(element)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
                System.out.println("Hover performed\n");
            } else {
                System.out.println("UNABLE TO HOVER OVER ELEMENT\n");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("ELEMENT WITH " + element
                    + " IS NOT ATTACHED TO THE PAGE DOCUMENT");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("ELEMENT " + element + " WAS NOT FOUND IN DOM");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR OCCURED WHILE HOVERING\n");
            e.printStackTrace();
        }
    }

    /**
     * SYNCHRONIZATION METHODS
     */

    public void waitUntilURLIs(String url) {
        fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5));

        try {
            fluentWait.until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilClickable(WebElement element) {
        fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5));

        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilVisible(WebElement element) {
        fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5));

        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilSelectable(WebElement element) {
        fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5));

        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilPresent(WebElement element) {

        try {
            if (!isElementPresent(element)) {
                waitUntilVisible(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed() || element.isEnabled())
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }


    /**
     * COMPARISON METHODS - Using excel read/write methods
     */


    // Gets specified attribute from List<WebElements> and compares against expected String array from user-specified Excel workbook/sheet
    public static boolean compareWebElementListOfAttributesToExpectedStringArray(List<WebElement> webElementList, String attribute, String path, String sheetName) throws IOException {
        String[] expectedList = dataReader.fileReaderStringXSSF(path, sheetName);

        String[] actual = new String[webElementList.size()];

        for (int j = 0; j < webElementList.size(); j++) {
            actual[j] = webElementList.get(j)
                    .getAttribute(attribute)
                    .replaceAll("&amp;", "&")
                    .replaceAll("’", "'")
                    .replaceAll("<br>", "\n").trim();
        }

        int falseCount = 0;
        boolean flag = false;
        for (int i = 0; i < expectedList.length; i++) {
            if (actual[i].equalsIgnoreCase(expectedList[i])) {
                flag = true;
                System.out.println("ACTUAL " + attribute.toUpperCase() + " " + (i + 1) + ": " + actual[i]);
                System.out.println("EXPECTED " + attribute.toUpperCase() + " " + (i + 1) + ": " + expectedList[i] + "\n");
            } else {
                System.out.println("FAILED AT INDEX " + (i + 1) + "\nEXPECTED " + attribute.toUpperCase() + ": " + expectedList[i] +
                        "\nACTUAL " + attribute.toUpperCase() + ": " + actual[i] + "\n");
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }


}
