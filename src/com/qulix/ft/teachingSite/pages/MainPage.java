package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница HomePage
 */
public class MainPage extends AbstractPage {

    /**
     * Локатор ссылки qulixteachingsite.MessageController
     */
    private static final By _linkMessageController = Locators.get(Environment.MAPS.MAIN, "linkMessageController");
    /**
     * Локатор ссылки qulixteachingsite.UserController
     */
    private static final By _linkUserController = Locators.get(Environment.MAPS.MAIN, "linkUserController");

    /**
     * Сссылка qulixteachingsite.MessageController
     *
     * @return Сссылка qulixteachingsite.MessageController
     */
    private static  WebElement linkMessageController() {
        return driver.findElement(_linkMessageController);
    }

    /**
     * Сссылка qulixteachingsite.UserController
     *
     * @return Сссылка qulixteachingsite.UserController
     */
    private static  WebElement linkUserController() {
        return driver.findElement(_linkUserController);
    }

    /**
     * Нажать ссылку qulixteachingsite.MessageController
     */
    public static void clickMessageController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.MessageController");
        linkMessageController().click();
        Login.assertLoginPageIsOpened();
    }

    /**
     * Нажать ссылку qulixteachingsite.UserController
     */
    public static void clickUserController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.UserController");
        linkUserController().click();
        Login.assertLoginPageIsOpened();
    }

    /**
     * Убедиться, что открыта страница Home Page
     */
    public static void assertMainPageIsOpened(){
        assertPageIsOpened(_linkMessageController, "Home Page");
    }
}
