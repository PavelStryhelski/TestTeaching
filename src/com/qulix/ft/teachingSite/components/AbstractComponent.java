package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.tests.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent{

    protected static WebDriver driver = AbstractTest.driver;


    protected static WebElement getElement(By element){
        return driver.findElement(element);
    }

    protected static List<WebElement> getElements(By element){
        return driver.findElements(element);
    }

    protected static void clickOnElement (By element) {
        getElement(element).click();
    }

    protected static void logDebug(String message) {
        SuiteLogger.debug(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + ":" + message);
    }
}
