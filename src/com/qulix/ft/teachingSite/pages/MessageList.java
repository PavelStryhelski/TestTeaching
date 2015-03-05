package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageList extends AbstractPage {

    private static final By _table = Locators.get(Environment.MAPS.MESSAGE_LIST, "table");

    private static final By _labelMessageList = Locators.get(Environment.MAPS.MESSAGE_LIST, "labelMessageList");

    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.MESSAGE_LIST, "buttonNewMessage");

    private static final By _checkbox = Locators.get(Environment.MAPS.MESSAGE_LIST, "checkBox");

    private static final By _userGreetingLocator = Locators.get(Environment.MAPS.MESSAGE_LIST, "greetingLocator");

    private static final int _headlineCol = 2;

    private static final int _textCol = 3;

    private static final int _authorCol = 4;

    private final WebDriver driver = getDriver();

    private  TableManager tableMessages() {
        return new TableManager(_table);
    }

    public void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    private boolean assertCheckBoxIsChecked() {
        return assertElementIsSelected(_checkbox);
    }

    private boolean assertGreetingIsCorrect(String name) {
        return getElement(_userGreetingLocator).getText().equals("Hello " + name + "!");
    }

    private  void clickCheckBox() {
        clickOnElement(_checkbox);
    }

    public Message createNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        clickOnElement(_buttonNewMessage);
        return new Message();

    }

    private int returnRowIndex(String headline, String text, String author) {

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        cond.addCondition(_authorCol, author);

        return tableMessages().getIndexOfRow(cond);
    }

    public void assertMessageIsInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list");

        assertMessageIsInList(headline, text, "");
    }

    public void assertMessageIsInList(String headline, String text, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list with correct Author " + author);
        }

        int index = returnRowIndex(headline, text, author);

        if (index > 1) {
            SuiteLogger.logMessage("Row is found. All is correct");
        } else {
            SuiteLogger.logError("Row is not found or Author is not correct");
        }
    }


    public  void assertMessageIsNotInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is not in list");

        assertMessageIsNotInList(headline, text, "");
    }

    public  void assertMessageIsNotInList(String headline, String text, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Checking that message with Headline " + headline + ", " + text + " and Author " + author + " is not in a list");
        }

        int index = returnRowIndex(headline, text, author);

        if (index > 1) {
            SuiteLogger.logError("Row is found.");
        } else {
            SuiteLogger.logMessage("Row is not found.");
        }

    }

    public ShowMessagePage viewMessage(String headline, String text) {

        SuiteLogger.logMessage("Clicking View button for Headline: " + headline + "and Text: " + text);

        return  viewMessage(headline, text, "");
    }

    public ShowMessagePage viewMessage(String headline, String text, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking View button for Headline: " + headline + " Text: " + text + " and Author: " + author);
        }

        int index = returnRowIndex(headline, text, author);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='View']"));
            return new ShowMessagePage();
        } else {
            SuiteLogger.logError("Cannot click View button.");
            return null;
        }

    }

    public  Message editMessage(String headline, String text) {

        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        return editMessage(headline, text, "");
    }

    public Message editMessage(String headline, String text, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text + " and Author: " + author);
        }

        int index = returnRowIndex(headline, text, author);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']"));
            return new Message();
        } else {
            SuiteLogger.logError("Cannot click Edit button.");
            return null;
        }
    }

    public void deleteMessage(String headline, String text) {

        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        deleteMessage(headline, text, "");
    }

    public void deleteMessage(String headline, String text, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text + " and Author: " + author);
        }

        int index = returnRowIndex(headline, text, author);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='Delete']"));

        } else {
            SuiteLogger.logError("Cannot click Delete button.");
        }

    }

    public void checkCheckBox() {
        if (!assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Check checkbox 'All Users` messages'");
        } else {
            SuiteLogger.logMessage("CheckBox is already checked!");
        }
    }

    public void uncheckCheckBox() {
        if (assertCheckBoxIsChecked()) {
            clickCheckBox();
            SuiteLogger.logMessage("Uncheck checkbox 'All Users` messages'");
        } else {
            SuiteLogger.logMessage("CheckBox is already unchecked!");
        }
    }

    public void assertGreeting(String name) {
        if (assertGreetingIsCorrect(name)) {
            SuiteLogger.logMessage("Greeting is correct!");
        } else {
            SuiteLogger.logError("Greeting is not correct!");
        }
    }

}
