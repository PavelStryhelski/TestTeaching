package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    private static final By _linkMessageController = Locators.get(Environment.MAPS.MAIN, "linkMessageController");

    private static final By _linkUserController = Locators.get(Environment.MAPS.MAIN, "linkUserController");

    private static  WebElement linkMessageController() {
        return getElement(_linkMessageController);
    }

    private static  WebElement linkUserController() {
        return getElement(_linkUserController);
    }

    public static void clickMessageController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.MessageController");
        linkMessageController().click();
        Login.assertLoginPageIsOpened();
    }

    public static void clickUserController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.UserController");
        linkUserController().click();
        Login.assertLoginPageIsOpened();
    }

    public static void assertMainPageIsOpened(){
        assertPageIsOpened(_linkMessageController, "Home Page");
    }
}
