package com.qulix.ft.model;

/**
 * Элемент, с которым можно взаимодейстовать
 */
public interface IAccessibleElement extends IElement {

    /**
     * Доступен ли для клика элемент
     * @param timeout Таймаут ожидания доступности для клика в секундах
     * @return <code>true</code>, если элемент стал доступен для клика в течение указанного таймаута
     */
    public boolean clickable(int timeout);

    /**
     * Доступен ли для взаимодействия элемент
     * @param timeout Таймаут ожидания доступности для взаимодействия в секундах
     * @return <code>true</code>, если элемент стал доступен для взаимодействия в течение указанного таймаута
     */
    public boolean enabled(int timeout);

    /**
     * Не доступен ли для взаимодействия элемент
     * @param timeout Таймаут ожидания недоступности для взаимодействия в секундах
     * @return <code>true</code>, если элемент стал не доступен для взаимодействия в течение указанного таймаута
     */
    public boolean disabled(int timeout);

    /**
     * Кликнуть по элементу
     */
    public void click();

    /**
     * Ввести с клавиатуры
     * @param sequence Последовательность клавиш для ввода
     * @see org.openqa.selenium.WebElement#sendKeys(CharSequence...)
     */
    public void sendKeys(CharSequence... sequence);
}
