package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� HomePage
 */
public class MainPage extends AbstractPage {

    /**
     * ������� ������ qulixteachingsite.MessageController
     */
    private static final By _linkMessageController = Locators.get(Environment.MAPS.MAIN, "linkMessageController");
    /**
     * ������� ������ qulixteachingsite.UserController
     */
    private static final By _linkUserController = Locators.get(Environment.MAPS.MAIN, "linkUserController");

    /**
     * ������� qulixteachingsite.MessageController
     *
     * @return ������� qulixteachingsite.MessageController
     */
    private static  WebElement linkMessageController() {
        return driver.findElement(_linkMessageController);
    }

    /**
     * ������� qulixteachingsite.UserController
     *
     * @return ������� qulixteachingsite.UserController
     */
    private static  WebElement linkUserController() {
        return driver.findElement(_linkUserController);
    }

    /**
     * ������ ������ qulixteachingsite.MessageController
     */
    public static void clickMessageController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.MessageController");
        linkMessageController().click();
        Login.assertLoginPageIsOpened();
    }

    /**
     * ������ ������ qulixteachingsite.UserController
     */
    public static void clickUserController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.UserController");
        linkUserController().click();
        Login.assertLoginPageIsOpened();
    }

    /**
     * ���������, ��� ������� �������� Home Page
     */
    public static void assertMainPageIsOpened(){
        assertPageIsOpened(_linkMessageController, "Home Page");
    }
}
