package testUtils;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener extends Base implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE TO: " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("NAVIGATED TO: " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE BACK");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("NAVIGATED BACK");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE FORWARD");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("NAVIGATED FORWARD");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO REFRESH PAGE");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("REFRESHED PAGE");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO FIND: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("FOUND: " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO CLICK: " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("CLICKED: " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("ATTEMPTING TO INPUT (" + charSequences + ") TO " + webElement.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("INPUT (" + charSequences + ") TO " + webElement.toString());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
