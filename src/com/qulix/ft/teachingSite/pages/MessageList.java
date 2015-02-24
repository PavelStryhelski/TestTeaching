package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� MessageList
 */
public class MessageList extends AbstractPage {
    /**
     * ������� �������
     */
    private static final By _table = Locators.get(Environment.MAPS.MESSAGE_LIST, "table");
    /**
     * ������� ������������ ��������
     */
    private static final By _labelMessageList = Locators.get(Environment.MAPS.MESSAGE_LIST, "labelMessageList");
    /**
     * ������� ������ NewMessage
     */
    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.MESSAGE_LIST, "buttonNewMessage");

    /**
     * ������� ������ MessageList
     */
    private static final By _messageListButton = Locators.get(Environment.MAPS.MESSAGE_LIST, "messageListButton");

    /**
     * ������� Checkbox
     */
    private static final By _checkbox = Locators.get(Environment.MAPS.MESSAGE_LIST, "checkBox");

    /**
     * ������� Greeting
     */
    private static final By _userGreetingLocator =  Locators.get(Environment.MAPS.MESSAGE_LIST, "greetingLocator");

    /**
     * ����� ������� Headline
     */
    private static final int _headlineCol = 2;
    /**
     * ����� ������� Text
     */
    private static final int _textCol = 3;

    /**
     * ����� ������� Author
     */
    private static final int _authorCol = 4;



    /**
     * ������ ������ TableManager ��� ������ � ��������
     *
     * @return TableManager
     */
    private static TableManager tableMessages() {
        return new TableManager(_table);
    }


    /**
     * ���������, ��� ������� �������� Message List
     */
    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    /**
     * ������ �� ���-����
     */
    private static boolean assertCheckBoxIsChecked(){
        return driver.findElement(_checkbox).isSelected();
    }

    /**
     * ���������� �� ����������� �� ��������
     */
    private static boolean assertGretingIsCorrect(String name){
       return driver.findElement(_userGreetingLocator).getText().equals("Hello " + name + "!");
    }

    /**
     * ���������� �� ����� � ���������
     */
    private static boolean assertAuthorNameIsCorrect(int index, String author) {

        By authorText = By.xpath("//div[@class='list']//tr[" + --index + "]/td[" + _authorCol + "]");

        if (driver.findElement(authorText).getText().equals(author)) {
            return true;
        }  else {
            return false;
        }
    }

    /**
     * ������ �� ���-����
     */
    private static void clickCheckBox(){
        driver.findElement(_checkbox).click();;
    }

    /**
     * ������ NewMessage
     */
    public static void clickNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        driver.findElement(_buttonNewMessage).click();
    }

    /**
     * ������ MessageListButton
     */
    public static void clickMessageListButton() {
        SuiteLogger.logMessage("Click button MessageList");
        driver.findElement(_messageListButton).click();
    }


    private static int returnRowIndex(String headline, String text){

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        return tableMessages().getIndexOfRow(cond);
    }

    /**
     * ���������, ��� � ������ ���� ������ � ��������� ���������� headline �  text
     *
     * @param headline �������� ������� headline
     * @param text     �������� ������� text
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

    /**
     * ���������, ��� � ������ ���� ������ � ��������� ���������� headline �  text � author
     *
     * @param headline �������� ������� headline
     * @param text     �������� ������� text
     * @param author   �������� ������� author
     */
    public static void assertMessageIsInList(String headline, String text,String author) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list with correct Author" + author);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Row is found.");
            if (assertAuthorNameIsCorrect(index,author)){
                SuiteLogger.logMessage("Author is correct");
            }   else {
                SuiteLogger.logError("Author is not correct!");
            }
        } else {
            SuiteLogger.logError("Row is not found.");
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
                driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='View']")).click();
            } else {
                SuiteLogger.logError("Cannot click View button.");
            }

    }

    public static void clickEditButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']")).click();
        } else {
            SuiteLogger.logError("Cannot click Edit button.");
        }
    }

    public static void clickDeleteButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='Delete']")).click();

        } else {
            SuiteLogger.logError("Cannot click Delete button.");
        }

    }

    public static void checkCheckBox(){
        if (!assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Check checkbox 'All User`s messages'");
        } else {
            SuiteLogger.logError("CheckBox is already checked!");
        }
    }

    public static void uncheckCheckBox(){
        if (assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Uncheck checkbox 'All User`s messages'");
        } else {
            SuiteLogger.logError("CheckBox is already unchecked!");
        }
    }

    public static void assertGreetingIsCorrect(String name){
        if(assertGretingIsCorrect(name)){
            SuiteLogger.logMessage("Greeting is correct!");
        } else {
            SuiteLogger.logError("Greeting is not correct!");
        }
    }

}
