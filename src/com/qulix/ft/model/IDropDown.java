package com.qulix.ft.model;

import java.util.Collection;

/**
 * Выпадающий список
 */
public interface IDropDown extends IAccessibleElement {

    /**
     * Значение, которое выбрано
     * @return Значение, которое выбрано
     */
    public String getSelected();

    /**
     * Выбрать значение по тексту
     * @param text Текст
     */
    public void select(String text);

    /**
     * Выбрать по атрибуту value
     * @param value Значение атрибута
     */
    public void selectByOptionValue(String value);

    /**
     * Все значения списка
     * @return Все значения списка
     */
    public Collection<String> getAllValues();

    /**
     * Количество значений в списке
     * @return Количество значений в списке
     */
    public int getValuesCount();

    /**
     * Задано ли значение в списке (выбран ли какой-либо элемент)
     * @return <code>false</code>, если выбранный элемент отсутствует или имеет пустой текст
     */
    public boolean hasSelectedValue();
}
