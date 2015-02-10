package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.components.AbstractComponent;
import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.SuiteLogger;
import org.openqa.selenium.By;

/**
 * Абстрактная страница.
 * В тестах можно вызывать только объекты-потомки этого класса
 */

public class AbstractPage extends AbstractComponent {

    /**
     * Убедиться, что открыта форма
     */
    public static void assertPageIsOpened(By element, String formName){

        try{
            driver.findElement(element);
            SuiteLogger.logMessage("Page " + formName + " is opened", GetScreenshot.fromDriver());
        }catch(Exception e){
            SuiteLogger.logError("Page " + formName + " is not opened");
        }
    }
}
