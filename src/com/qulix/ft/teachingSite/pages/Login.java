package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� Login
 */
public class Login extends AbstractPage {

    /**
     * ������� ���� ������
     */
    private static final By _editLogin = Locators.get(Environment.MAPS.LOGIN, "username");
    /**
     * ������� ���� ������
     */
    private static final By _editPassword = Locators.get(Environment.MAPS.LOGIN, "userpassword");
    /**
     * ������� ������ ����
     */
    private static final By _buttonLogin = Locators.get(Environment.MAPS.LOGIN, "buttonLogin");

    private static String loggedUser = null;

    /**
     * ���� ������
     *
     * @return ���� ������
     */
    private static WebElement editLogin() {
        return driver.findElement(_editLogin);
    }

    /**
     * ���� ������
     *
     * @return ���� ������
     */
    private static WebElement editPassword() {
        return driver.findElement(_editPassword);
    }

    /**
     * ������ ����
     *
     * @return ������ ����
     */
    private static WebElement buttonLogin() {
        return driver.findElement(_buttonLogin);
    }

    /**
     * ���������, ��� ������� ����� ������
     */
    public static void assertLoginPageIsOpened(){
        assertPageIsOpened(_editLogin, "Login");
    }

    /**
     * ���� � ����������
     *
     * @param userName     ��� ������������
     * @param userPassword ������ ������������
     */
    public static void signIn(String userName, String userPassword) {
        SuiteLogger.logMessage("Log in user: " + userName + "\\" + userPassword);

        driver.switchTo().defaultContent();
        editLogin().clear();
        editLogin().sendKeys(userName);
        editPassword().sendKeys(userPassword);
        buttonLogin().click();
        loggedUser = userName;
    }

}

