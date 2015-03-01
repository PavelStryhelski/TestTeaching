package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShowMessage extends AbstractPage{

    private static final By _labelShowMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "labelShowMessage");

    private static final By _buttonMessageList = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonMessageList");

    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonNewMessage");

    private static final By _headline = Locators.get(Environment.MAPS.SHOW_MESSAGE, "headline");

    private static final By _text = Locators.get(Environment.MAPS.SHOW_MESSAGE, "text");

    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelShowMessage, "Show Message");
    }

    public static void showMessageList(){
        SuiteLogger.logMessage("Click button Message List");
        clickOnElement(_buttonMessageList);
    }

    public static void createNewMessage(){
        SuiteLogger.logMessage("Click button New Message");
        clickOnElement(_buttonNewMessage);
    }

    public static void assertMessageIsCorrect(String headline,String text){
        assertElementHasCorrectText(_headline, headline);
        assertElementHasCorrectText(_text, text);
    }



}
