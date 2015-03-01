package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница CreateMessage
 */
public class CreateMessage extends AbstractPage{

    private static final By _labelCreateMessage = Locators.get(Environment.MAPS.CREATE_MESSAGE, "labelCreateMessage");

    private static final By _buttonCreate = Locators.get(Environment.MAPS.CREATE_MESSAGE, "buttonCreate");

    private static final By _editHeadline = Locators.get(Environment.MAPS.CREATE_MESSAGE, "headlineField");

    private static final By _editText = Locators.get(Environment.MAPS.CREATE_MESSAGE, "textField");

    private static void clickCreateButton(){
        SuiteLogger.logMessage("Click button Create");
        clickOnElement(_buttonCreate);
    }

    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelCreateMessage, "Create Message");
    }

    public static void createMessage(String headline, String text){
        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        sendTextToTheField(_editHeadline,headline);
        sendTextToTheField(_editText,text);
        clickCreateButton();
    }

    public static void fulfilMessageFieldsWithValues(String headline, String text){
        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        sendTextToTheField(_editHeadline,headline);
        sendTextToTheField(_editText,text);
    }
}
