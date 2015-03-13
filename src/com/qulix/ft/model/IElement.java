package com.qulix.ft.model;

import org.openqa.selenium.By;

/**
 * Элемент UI
 */
public interface IElement {

    /**
     * Страница, которой элемент принадлежит
     * @return Страница, которой элемент принадлежит
     */
    public IPage getOwnerPage();

    /**
     * Локатор элемента
     * @return Локатор элемента
     */
    public By getLocator();

    /**
     * Логическое имя элемента
     * @return Логическое имя элемента
     */
    public String getName();

    /**
     * Получение свойства из DOM модели
     * @param propertyName Наименование свойства
     * @return Значение свойства
     */
    public String getProperty(String propertyName);

    /**
     * Видимый ли элемент
     * @param timeout Таймаут ожидания видимости в секундах
     * @return <code>true</code>, если элемент стал видим в течение указанного таймаута
     */
    public boolean visible(int timeout);

    /**
     * Невидимый ли элемент
     * @param timeout Таймаут ожидания невидимости и/или отсутствия элемента в секундах
     * @return <code>true</code>, если элемент стал невидим и/или перестал существовать в течение указанного таймаута
     */
    public boolean invisible(int timeout);

    /**
     * Существует ли элемент
     * @param timeout Таймаут ожидания существования в секундах
     * @return <code>true</code>, если элемент появился в DOM в течение указанного таймаута
     */
    public boolean exists(int timeout);

    /**
     * Не существует ли элемент
     * @param timeout Таймаут ожидания отсутствия в секундах
     * @return <code>true</code>, если элемент не появился или исчез из DOM в течение указанного таймаута
     */
    public boolean doesntExist(int timeout);

    /**
     * Родительский элемент, если есть
     * @return Родительский элемент, если задан. <code>null</code>, если элемент относится напрямую к странице
     */
    public IElement getParentElement();
}
