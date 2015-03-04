package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.User;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends AbstractPage {

    private static final By _labelLogin = Locators.get(Environment.MAPS.LOGIN, "labelLogin");

    private static final By _editLogin = Locators.get(Environment.MAPS.LOGIN, "userName");

    private static final By _editPassword = Locators.get(Environment.MAPS.LOGIN, "userPassword");

    private static final By _buttonLogin = Locators.get(Environment.MAPS.LOGIN, "buttonLogin");

    private final WebDriver driver;

    private static String loggedUser = null;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void assertLoginPageIsOpened(){
        assertPageIsOpened(_labelLogin, "Login");
    }

    public MessageList signIn(User user) {
        SuiteLogger.logMessage("Log in user: " + user.getUserLoginName() + "\\" + user.getPassword());
        driver.switchTo().defaultContent();
        sendTextToTheField(_editLogin, user.getUserLoginName());
        sendTextToTheField(_editPassword, user.getPassword());
        clickOnElement(_buttonLogin);
        loggedUser = user.getName();
        return new MessageList(driver);
    }

}

