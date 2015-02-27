package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница MessageList
 */
public class MessageList extends AbstractPage {
    /**
     * Локатор таблицы
     */
    private static final By _table = Locators.get(Environment.MAPS.MESSAGE_LIST, "table");
    /**
     * Локатор наименования страницы
     */
    private static final By _labelMessageList = Locators.get(Environment.MAPS.MESSAGE_LIST, "labelMessageList");
    /**
     * Локатор кнопки NewMessage
     */
    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.MESSAGE_LIST, "buttonNewMessage");

    /**
     * Локатор кнопки MessageList
     */
    private static final By _messageListButton = Locators.get(Environment.MAPS.MESSAGE_LIST, "messageListButton");

    /**
     * Локатор Checkbox
     */
    private static final By _checkbox = Locators.get(Environment.MAPS.MESSAGE_LIST, "checkBox");

    /**
     * Локатор Greeting
     */
    private static final By _userGreetingLocator =  Locators.get(Environment.MAPS.MESSAGE_LIST, "greetingLocator");

    /**
     * Номер колонки Headline
     */
    private static final int _headlineCol = 2;
    /**
     * Номер колонки Text
     */
    private static final int _textCol = 3;

    /**
     * Объект класса TableManager для работы с таблицей
     *
     * @return TableManager
     */
    private static TableManager tableMessages() {
        return new TableManager(_table);
    }


    private static WebElement findElement(By element){
        return driver.findElement(element);
    }


    /**
     * Убедиться, что открыта страница Message List
     */
    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    /**
     * Выбран ли чек-бокс
     */
    private static boolean assertCheckBoxIsChecked(){
        return findElement(_checkbox).isSelected();
    }

    /**
     * Правильное ли приветствие на странице
     */
    private static boolean assertGreetingIsCorrect(String name){
       return findElement(_userGreetingLocator).getText().equals("Hello " + name + "!");
    }

    /**
     * Нажать на чек-бокс
     */
    private static void clickCheckBox(){
        findElement(_checkbox).click();
    }

    /**
     * Нажать NewMessage
     */
    public static void clickNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        findElement(_buttonNewMessage).click();
    }

    /**
     * Нажать MessageListButton
     */
    public static void clickMessageListButton() {
        SuiteLogger.logMessage("Click button MessageList");
        //TODO Move to superclass
        findElement(_messageListButton).click();
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

    /**
     * Убедиться, что в табице есть строка с заданными значениями headline и  text
     *
     * @param headline значение столбца headline
     * @param text     значение столбца text
     */
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
                findElement(By.xpath("//tr[" + --index + "]//a[text()='View']")).click();
            } else {
                SuiteLogger.logError("Cannot click View button.");
            }

    }

    public static void clickEditButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            findElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']")).click();
        } else {
            SuiteLogger.logError("Cannot click Edit button.");
        }
    }

    public static void clickDeleteButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            findElement(By.xpath("//tr[" + --index + "]//a[text()='Delete']")).click();

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
