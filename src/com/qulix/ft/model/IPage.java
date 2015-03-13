package com.qulix.ft.model;

import org.openqa.selenium.WebDriver;

/**
 * Страница приложения
 */
public interface IPage {

    /**
     * Логическое имя страницы
     * @return Логическое имя страницы
     */
    public String getName();

    /**
     * Драйвер
     * @return Драйвер
     */
    public WebDriver getDriver();

}
