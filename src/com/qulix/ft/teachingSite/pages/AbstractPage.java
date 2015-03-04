package com.qulix.ft.teachingSite.pages;


import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.SuiteLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Абстрактная страница.
 * В тестах можно вызывать только объекты-потомки этого класса
 */

public abstract class AbstractPage {

    private static final By _logoutLocator = By.xpath("//a[text()='Logout']");

    private static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected  WebElement getElement(By element) {
        return getDriver().findElement(element);
    }


    protected  void assertPageIsOpened(By element, String formName) {

        if (getElement(element).getText().equals(formName)) {
            SuiteLogger.logMessage("Page " + formName + " is opened", GetScreenshot.fromDriver());
        } else {
            SuiteLogger.logError("Page " + formName + " is not opened");
        }
    }

    protected  void assertElementHasCorrectText(By element, String text) {

        if (getElement(element).getText().equals(text)) {
            SuiteLogger.logMessage("Element " + element + "`s text equals to " + text, GetScreenshot.fromDriver());
        } else if (getElement(element).getAttribute("value").equals(text)) {
            SuiteLogger.logMessage("Element " + element + "`s value equals to " + text, GetScreenshot.fromDriver());
        } else {
            SuiteLogger.logError("Element " + element + "`s value/text does not equal to " + text);
        }

    }

    protected  void sendTextToTheField(By element, String text) {
        clearField(element);
        getElement(element).sendKeys(text);
    }

    public  void logOut() {

        try {
            clickOnElement(_logoutLocator);
            SuiteLogger.logMessage("Logout");
        } catch (Exception e) {
            SuiteLogger.logError("You cannot logout from this page");
        }

    }

    protected  void clearField(By element) {
        getElement(element).clear();
    }

    protected  void clickOnElement(By element) {
        getElement(element).click();
    }

    protected  boolean assertElementIsSelected(By element) {
        return getElement(element).isSelected();

    }


}
