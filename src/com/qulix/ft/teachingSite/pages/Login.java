package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница Login
 */
public class Login extends AbstractPage {

    /**
     * Локатор поля логина
     */
    private static final By _editLogin = Locators.get(Environment.MAPS.LOGIN, "username");
    /**
     * Локатор поля пароля
     */
    private static final By _editPassword = Locators.get(Environment.MAPS.LOGIN, "userpassword");
    /**
     * Локатор кнопки Ввод
     */
    private static final By _buttonLogin = Locators.get(Environment.MAPS.LOGIN, "buttonLogin");

    private static String loggedUser = null;

    /**
     * Поле логина
     *
     * @return поле логина
     */
    private static WebElement editLogin() {
        return driver.findElement(_editLogin);
    }

    /**
     * Поле пароля
     *
     * @return поле пароля
     */
    private static WebElement editPassword() {
        return driver.findElement(_editPassword);
    }

    /**
     * Кнопка ввод
     *
     * @return кнопка ввод
     */
    private static WebElement buttonLogin() {
        return driver.findElement(_buttonLogin);
    }

    /**
     * Убедиться, что открыта форма логина
     */
    public static void assertLoginPageIsOpened(){
        assertPageIsOpened(_editLogin, "Login");
    }

    /**
     * Вход в приложение
     *
     * @param userName     Имя пользователя
     * @param userPassword Пароль пользователя
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

