package com.qulix.ft.model;

/**
 * Картинка
 */
public interface IImage extends IAccessibleElement {

    /**
     * Атрибут src
     * @return Атрибут src
     */
    public String getSource();

    /**
     * Alt картинки
     * @return Alt картинки
     */
    public String getAlt();

}
