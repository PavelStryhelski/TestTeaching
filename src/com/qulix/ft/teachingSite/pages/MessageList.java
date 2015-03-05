package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.UserMessage;
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

    public static final String EMPTY_FIELD = "";

    private final WebDriver driver;

    public MessageList(WebDriver driver) {
        super(driver);
        this.driver = getDriver();
    }

    private TableManager tableMessages() {
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

    private void clickCheckBox() {
        clickOnElement(_checkbox);
    }

    public Message createNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        clickOnElement(_buttonNewMessage);
        return new Message(driver);
    }

    private int returnRowIndex(String headline, String text, String author) {

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        if (!author.equals(EMPTY_FIELD)) {
            cond.addCondition(_authorCol, author);
        }


        return tableMessages().getIndexOfRow(cond);
    }

    public void assertMessageIsInList(UserMessage userMessage) {
        SuiteLogger.logMessage("Checking that message with Headline " + userMessage.getHeadline() + " and Text " + userMessage.getText() + " is in list");

        assertMessageIsInList(userMessage, EMPTY_FIELD);
    }

    public void assertMessageIsInList(UserMessage userMessage, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Checking that message with Headline " + userMessage.getHeadline() + " and Text " + userMessage.getText() + " is in list with correct Author " + author);
        }

        int index = returnRowIndex(userMessage.getHeadline(), userMessage.getText(), author);

        if (index > 1) {
            SuiteLogger.logMessage("Row is found. All is correct");
        } else {
            SuiteLogger.logError("Row is not found or Author is not correct");
        }
    }


    public void assertMessageIsNotInList(UserMessage userMessage) {
        SuiteLogger.logMessage("Checking that message with Headline " + userMessage.getHeadline() + " and Text " + userMessage.getText() + " is not in list");

        assertMessageIsNotInList(userMessage, EMPTY_FIELD);
    }

    public void assertMessageIsNotInList(UserMessage userMessage, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Checking that message with Headline " + userMessage.getHeadline() + ", " + userMessage.getText() + " and Author " + author + " is not in a list");
        }

        int index = returnRowIndex(userMessage.getHeadline(), userMessage.getText(), author);

        if (index > 1) {
            SuiteLogger.logError("Row is found.");
        } else {
            SuiteLogger.logMessage("Row is not found.");
        }

    }

    public ShowMessagePage viewMessage(UserMessage userMessage) {

        SuiteLogger.logMessage("Clicking View button for Headline: " + userMessage.getHeadline() + "and Text: " + userMessage.getText());

        return viewMessage(userMessage, EMPTY_FIELD);
    }

    public ShowMessagePage viewMessage(UserMessage userMessage, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking View button for Headline: " + userMessage.getHeadline() + " Text: " + userMessage.getText() + " and Author: " + author);
        }

        int index = returnRowIndex(userMessage.getHeadline(), userMessage.getText(), author);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='View']"));
            return new ShowMessagePage(driver);
        } else {
            SuiteLogger.logError("Cannot click View button.");
            return null;
        }

    }

    public Message editMessage(UserMessage userMessage) {

        SuiteLogger.logMessage("Clicking Edit button for Headline: " + userMessage.getHeadline() + "and Text: " + userMessage.getText());

        return editMessage(userMessage, EMPTY_FIELD);
    }

    public Message editMessage(UserMessage userMessage, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking Edit button for Headline: " + userMessage.getHeadline() + "and Text: " + userMessage.getText() + " and Author: " + author);
        }

        int index = returnRowIndex(userMessage.getHeadline(), userMessage.getText(), author);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            clickOnElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']"));
            return new Message(driver);
        } else {
            SuiteLogger.logError("Cannot click Edit button.");
            return null;
        }
    }

    public void deleteMessage(UserMessage userMessage) {

        SuiteLogger.logMessage("Clicking Delete button for Headline: " + userMessage.getHeadline() + "and Text: " + userMessage.getText());

        deleteMessage(userMessage, EMPTY_FIELD);
    }

    public void deleteMessage(UserMessage userMessage, String author) {

        if (!author.equals("")) {
            SuiteLogger.logMessage("Clicking Delete button for Headline: " + userMessage.getHeadline() + "and Text: " + userMessage.getText() + " and Author: " + author);
        }

        int index = returnRowIndex(userMessage.getHeadline(), userMessage.getText(), author);

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
