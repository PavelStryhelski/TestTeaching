package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MessageList extends AbstractPage {

    private static final By _table = Locators.get(Environment.MAPS.MESSAGE_LIST, "table");

    private static final By _labelMessageList = Locators.get(Environment.MAPS.MESSAGE_LIST, "labelMessageList");

    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.MESSAGE_LIST, "buttonNewMessage");

    private static final By _messageListButton = Locators.get(Environment.MAPS.MESSAGE_LIST, "messageListButton");

    private static final By _checkbox = Locators.get(Environment.MAPS.MESSAGE_LIST, "checkBox");

    private static final By _userGreetingLocator =  Locators.get(Environment.MAPS.MESSAGE_LIST, "greetingLocator");

    private static final int _headlineCol = 2;

    private static final int _textCol = 3;

    private static final int _authorCol = 4;



    private static TableManager tableMessages() {
        return new TableManager(_table);
    }

    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    private static boolean assertCheckBoxIsChecked(){
        return assertElementIsSelected(_checkbox);
    }

    private static boolean assertGreetingIsCorrect(String name){
       return getElement(_userGreetingLocator).getText().equals("Hello " + name + "!");
    }

    private static void clickCheckBox(){
        clickOnElement(_checkbox);
    }

    public static void goToNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        clickOnElement(_buttonNewMessage);
    }

    public static void goToMessageList() {
        SuiteLogger.logMessage("Click button MessageList");
        clickOnElement(_messageListButton);
    }


    private static int returnRowIndex(String headline, String text){

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        return tableMessages().getIndexOfRow(cond);
    }

    private static int returnRowIndex(String headline, String text, String author){

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        return tableMessages().getIndexOfRow(cond, author);
    }

    public static void assertMessageIsInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list");

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Row is found.");
        } else {
            SuiteLogger.logError("Row is not found.");
        }
    }

    public static void assertMessageIsInList(String headline, String text,String author) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list with correct Author" + author);

        int index = returnRowIndex(headline,text, author);

        if (index > 1) {
            SuiteLogger.logMessage("Row is found. Author is correct");
        } else {
            SuiteLogger.logError("Row is not found or Author is not correct");
        }
    }


    public static void assertMessageIsNotInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is not in list");

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logError("Row is found.");
        } else {
            SuiteLogger.logMessage("Row is not found.");
        }

    }

    public static void clickViewButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking View button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

            if (index > 1) {
                SuiteLogger.logMessage("Click!");
                clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='View']"));
            } else {
                SuiteLogger.logError("Cannot click View button.");
            }

    }

    public static void clickEditButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']"));
        } else {
            SuiteLogger.logError("Cannot click Edit button.");
        }
    }

    public static void clickDeleteButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='Delete']"));

        } else {
            SuiteLogger.logError("Cannot click Delete button.");
        }

    }

    public static void checkCheckBox(){
        if (!assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Check checkbox 'All User`s messages'");
        } else {
            SuiteLogger.logMessage("CheckBox is already checked!");
        }
    }

    public static void uncheckCheckBox(){
        if (assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Uncheck checkbox 'All User`s messages'");
        } else {
            SuiteLogger.logMessage("CheckBox is already unchecked!");
        }
    }

    public static void assertGreeting(String name){
        if(assertGreetingIsCorrect(name)){
            SuiteLogger.logMessage("Greeting is correct!");
        } else {
            SuiteLogger.logError("Greeting is not correct!");
        }
    }

}
