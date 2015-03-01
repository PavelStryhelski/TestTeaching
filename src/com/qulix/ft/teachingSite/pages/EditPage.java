package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

public class EditPage  extends AbstractPage{

    private static final By _labelEditMessage = Locators.get(Environment.MAPS.EDIT_MESSAGE, "labelEditMessage");

    private static final By _headline = Locators.get(Environment.MAPS.EDIT_MESSAGE, "headline");

    private static final By _text = Locators.get(Environment.MAPS.EDIT_MESSAGE, "text");

    private static final By _saveButton = Locators.get(Environment.MAPS.EDIT_MESSAGE, "saveButton");


    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelEditMessage, "Edit Message");
    }

    public static void assertMessageIsCorrect(String headline,String text){
        assertElementHasCorrectText(_headline, headline);
        assertElementHasCorrectText(_text, text);
    }

    public static void setNewValuesForHeadlineAndText(String headlineNew, String textNew){
        sendTextToTheField(_headline, headlineNew);
        sendTextToTheField(_text,textNew);
    }

    public static void saveMessage()
    {
       clickOnElement(_saveButton);
    }

}
