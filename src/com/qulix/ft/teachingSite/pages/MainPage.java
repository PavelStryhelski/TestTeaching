package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    private static final By _labelMainPage = Locators.get(Environment.MAPS.MAIN, "labelMainPage");

    private static final By _linkMessageController = Locators.get(Environment.MAPS.MAIN, "linkMessageController");

    private static final By _linkUserController = Locators.get(Environment.MAPS.MAIN, "linkUserController");

    public static void goToMessageController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.MessageController");
        clickOnElement(_linkUserController);
        Login.assertLoginPageIsOpened();
    }

    public static void goToUserController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.UserController");
        clickOnElement(_linkMessageController);
        Login.assertLoginPageIsOpened();
    }

    public static void assertMainPageIsOpened(){
        assertPageIsOpened(_labelMainPage, "Welcome to Grails");
    }
}
