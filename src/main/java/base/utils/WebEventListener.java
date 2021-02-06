package base.utils;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class WebEventListener extends Base implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO ACCEPT ALERT");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("SUCCESSFULLY ACCEPTED ALERT");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO DISMISS ALERT");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("SUCCESSFULLY DISMISSED ALERT");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE TO: " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("SUCCESSFULLY NAVIGATED TO: " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE BACK");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("SUCCESSFULLY NAVIGATED BACK");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO NAVIGATE FORWARD");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("SUCCESSFULLY NAVIGATED FORWARD");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("ATTEMPTING TO REFRESH PAGE");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("SUCCESSFULLY REFRESHED PAGE");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO FIND: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("SUCCESSFULLY FOUND: " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO CLICK: " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("SUCCESSFULLY CLICKED: " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("ATTEMPTING TO INPUT (" + Arrays.toString(charSequences) + ") TO " + webElement.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("SUCCESSFULLY INPUT (" + Arrays.toString(charSequences) + ") TO " + webElement.toString());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO SWITCH TO WINDOW: " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("SUCCESSFULLY SWITCHED TO WINDOW: " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        System.out.println("GETTING SCREENSHOT");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        System.out.println("SUCCESSFULLY CAPTURED SCREENSHOT");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        System.out.println("ATTEMPTING TO GET TEXT FROM: " + webElement);
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("SUCCESSFULLY GOT TEXT FROM: " + webElement);
    }
}
