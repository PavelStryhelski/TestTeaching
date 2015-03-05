package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShowMessagePage extends AbstractPage{

    private static final By _labelShowMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "labelShowMessage");

    private static final By _buttonMessageList = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonMessageList");

    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonNewMessage");

    private static final By _headline = Locators.get(Environment.MAPS.SHOW_MESSAGE, "headline");

    private static final By _text = Locators.get(Environment.MAPS.SHOW_MESSAGE, "text");

    private final WebDriver driver;

    public ShowMessagePage(WebDriver driver) {
        super(driver);
        this.driver = getDriver();
    }

    public void assertPageIsOpened(){
        assertPageIsOpened(_labelShowMessage, "Show Message");
    }

    public MessageList showMessageList(){
        SuiteLogger.logMessage("Click button Message List");
        clickOnElement(_buttonMessageList);
        return new MessageList(driver);
    }

    public Message createNewMessage(){
        SuiteLogger.logMessage("Click button New Message");
        clickOnElement(_buttonNewMessage);
        return new Message(driver);
    }

    public void assertMessageIsCorrect(UserMessage userMessage){
        assertElementHasCorrectText(_headline, userMessage.getHeadline());
        assertElementHasCorrectText(_text, userMessage.getText());
    }



}
