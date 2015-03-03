package com.qulix.ft.teachingSite.pages;


import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

public class Message extends AbstractPage{

    private static final By _labelCreateMessage = Locators.get(Environment.MAPS.MESSAGE, "labelCreateMessage");

    private static final By _buttonCreate = Locators.get(Environment.MAPS.MESSAGE, "buttonCreate");

    private static final By _editHeadlineWhenCreate = Locators.get(Environment.MAPS.MESSAGE, "editHeadlineWhenCreate");

    private static final By _editTextWhenCreate = Locators.get(Environment.MAPS.MESSAGE, "editTextWhenCreate");

    private static final By _labelEditMessage = Locators.get(Environment.MAPS.MESSAGE, "labelEditMessage");

    private static final By _headlineEdit = Locators.get(Environment.MAPS.MESSAGE, "headlineEdit");

    private static final By _textEdit = Locators.get(Environment.MAPS.MESSAGE, "textEdit");

    private static final By _saveButton = Locators.get(Environment.MAPS.MESSAGE, "saveButton");


    private static void clickCreateButton(){
        SuiteLogger.logMessage("Click button Create");
        clickOnElement(_buttonCreate);
    }

    public static void assertCreateMessagePageIsOpened(){
        assertPageIsOpened(_labelCreateMessage, "Create Message");
    }

    public static void createMessage(String headline, String text){
        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        sendTextToTheField(_editHeadlineWhenCreate,headline);
        sendTextToTheField(_editTextWhenCreate,text);
        clickCreateButton();
    }

    public static void fulfilMessageFieldsWithValues(String headline, String text){
        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        sendTextToTheField(_editHeadlineWhenCreate,headline);
        sendTextToTheField(_editTextWhenCreate,text);
    }


    public static void assertEditPageIsOpened() {
        assertPageIsOpened(_labelEditMessage, "Edit Message");
    }

    public static void assertMessageIsCorrect(String headline,String text){
        assertElementHasCorrectText(_headlineEdit, headline);
        assertElementHasCorrectText(_textEdit, text);
    }

    public static void setNewValuesForHeadlineAndText(String headlineNew, String textNew){
        sendTextToTheField(_headlineEdit, headlineNew);
        sendTextToTheField(_textEdit,textNew);
    }

    public static void saveMessage()
    {
        clickOnElement(_saveButton);
    }

}
