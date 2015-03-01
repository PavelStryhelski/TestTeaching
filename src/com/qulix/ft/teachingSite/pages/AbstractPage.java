package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.components.AbstractComponent;
import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.SuiteLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Абстрактная страница.
 * В тестах можно вызывать только объекты-потомки этого класса
 */

public class AbstractPage extends AbstractComponent {

    private static final By _logoutLocator = By.xpath("//a[text()='Logout']");


    protected static WebElement getElement(By element){
        return driver.findElement(element);
    }


    protected static void assertPageIsOpened(By element, String formName){

        try{
            getElement(element);
            SuiteLogger.logMessage("Page " + formName + " is opened", GetScreenshot.fromDriver());
        }catch(Exception e){
            SuiteLogger.logError("Page " + formName + " is not opened");
        }
    }

    protected static void assertElementHasCorrectText(By element, String text){

            if (getElement(element).getText().equals(text)){
            SuiteLogger.logMessage("Element " + element + "`s text equals to " + text, GetScreenshot.fromDriver());
            }

            else if (getElement(element).getAttribute("value").equals(text)){
                SuiteLogger.logMessage("Element " + element + "`s value equals to " + text, GetScreenshot.fromDriver());
            }

            else {
            SuiteLogger.logError("Element " + element + "`s value/text does not equal to " + text);
            }

    }

    protected static void sendTextToTheField(By element,String text){
        clearField(element);
        getElement(element).sendKeys(text);
    }

    public static void logOut(){

        try {
            clickOnElement(_logoutLocator);
            SuiteLogger.logMessage("Logout");
        } catch (Exception e){
            SuiteLogger.logError("You cannot logout from this page");
        }

    }

    protected static void clearField(By element){
        getElement(element).clear();
    }

    protected static void clickOnElement (By element) {
        getElement(element).click();
    }

    protected static boolean assertElementIsSelected(By element){
        return getElement(element).isSelected();
    }


}
