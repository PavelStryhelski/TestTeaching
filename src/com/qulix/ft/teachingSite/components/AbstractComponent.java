package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.tests.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent{

    //TODO Create driver, initialize and create getter
    /*private final WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }*/

    protected  WebElement getElement(By element){
        return driver.findElement(element);
    }

    protected  List<WebElement> getElements(By element){
        return driver.findElements(element);
    }

    protected  void clickOnElement (By element) {
        getElement(element).click();
    }

    protected  void logDebug(String message) {
        SuiteLogger.debug(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + ":" + message);
    }

    protected  boolean assertElementIsDisplayed(By element){
        try {
            getElement(element).isDisplayed();
            return true;
        }  catch (NoSuchElementException e){
            return false;
        }
    }

}
