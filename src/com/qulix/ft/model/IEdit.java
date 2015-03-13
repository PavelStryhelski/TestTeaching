package com.qulix.ft.model;

/**
 * Поле ввода
 */
public interface IEdit extends IAccessibleElement{

    /**
     * Получение текста
     * @return Текст поля ввода
     */
    public String getText();

    /**
     * Ввести текст в поле ввода
     * @param text Текст
     */
    public void set(String text);
}
