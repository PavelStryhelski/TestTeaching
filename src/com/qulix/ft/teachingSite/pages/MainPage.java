package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private static final By _labelMainPage = Locators.get(Environment.MAPS.MAIN, "labelMainPage");

    private static final By _linkMessageController = Locators.get(Environment.MAPS.MAIN, "linkMessageController");

    private static final By _linkUserController = Locators.get(Environment.MAPS.MAIN, "linkUserController");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = getDriver();
    }

    public LoginPage goToMessageController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.MessageController");
        clickOnElement(_linkUserController);
        return new LoginPage(driver);
    }

    public LoginPage goToUserController(){
        SuiteLogger.logMessage("Select link qulixteachingsite.UserController");
        clickOnElement(_linkMessageController);
        return new LoginPage(driver);
    }

    public void assertMainPageIsOpened(){
        assertPageIsOpened(_labelMainPage, "Welcome to Grails");
    }
}
