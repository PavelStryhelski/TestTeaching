package com.qulix.ft.model;

/**
 * Чекбокс
 */
public interface ICheckbox extends IAccessibleElement{

    /**
     * Отмечен ли
     * @return <code>true</code>, если флаг отмечен
     */
    public boolean isSelected();

    /**
     * Отметить чекбокс, если еще не отмечен
     */
    public void select();

    /**
     * Снять отметку с чекбокса, если еще он отмечен
     */
    public void deselect();

    /**
     * Установить состояние чекбокса, если оно не установлено
     * @param state Состония (true = выбрать, false = снять)
     */
    public void setState(boolean state);

    /**
     * Получить текущеее состояние
     * @return Текущее состояние (true = выбран, false = снят)
     */
    public boolean getState();
}
