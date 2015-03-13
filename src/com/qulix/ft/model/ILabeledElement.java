package com.qulix.ft.model;

/**
 * Элемент, у которого есть текст
 */
public interface ILabeledElement extends IElement {

    /**
     * Текст элемента
     * @return Текст элемента
     */
    public String getText();
}
