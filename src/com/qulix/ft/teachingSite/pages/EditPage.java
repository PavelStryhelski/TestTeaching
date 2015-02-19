package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

public class EditPage  extends AbstractPage{

    /**
     * Локатор наименования страницы
     */
    private static final By _labelEditMessage = Locators.get(Environment.MAPS.EDIT_MESSAGE, "labelEditMessage");

    /**
     * Локатор Headline
     */
    private static final By _headline = Locators.get(Environment.MAPS.EDIT_MESSAGE, "headline");

    /**
     * Локатор Text
     */
    private static final By _text = Locators.get(Environment.MAPS.EDIT_MESSAGE, "text");

    /**
     * Локатор кнопки Save
     */
    private static final By _saveButton = Locators.get(Environment.MAPS.EDIT_MESSAGE, "saveButton");


    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelEditMessage, "Edit Message");
    }

    public static void assertMessageIsCorrect(String headline,String text){
        assertElementHasCorrectText(_headline, headline);
        assertElementHasCorrectText(_text, text);
    }

    public static void setNewValuesForHeadlineAndText(String headlineNew, String textNew){
        driver.findElement(_headline).clear();
        driver.findElement(_headline).sendKeys(headlineNew);
        driver.findElement(_text).clear();
        driver.findElement(_text).sendKeys(textNew);
    }

    public static void save(){
       driver.findElement(_saveButton).click();
    }

}
