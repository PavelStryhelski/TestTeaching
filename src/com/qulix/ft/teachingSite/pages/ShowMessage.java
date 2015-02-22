package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница ShowMessage
 */

public class ShowMessage extends AbstractPage{
    /**
     * Локатор наименования страницы
    */
    private static final By _labelShowMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "labelShowMessage");
    /**
     * Локатор кнопки MessageList
    */
    private static final By _buttonMessageList = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonMessageList");


    private static final By _buttonNewMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonNewMessage");

    /**
     * Локатор Headline
     */
    private static final By _headline = Locators.get(Environment.MAPS.SHOW_MESSAGE, "headline");

    /**
     * Локатор Text
     */
    private static final By _text = Locators.get(Environment.MAPS.SHOW_MESSAGE, "text");

    /**
     * Кнопка MessageList
     *
     * @return кнопка MessageList
     */
    private static WebElement buttonMessageList() {
        return driver.findElement(_buttonMessageList);
    }

    /**
     * Кнопка New Message
     *
     * @return кнопка MessageList
     */
    private static WebElement buttonNewMessage() {
        return driver.findElement(_buttonNewMessage);
    }

    /**
     * Убедиться, что открыта страница Show message
     */
    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelShowMessage, "Show Message");
    }

    /**
     * Нажать Message List
     */
    public static void clickMessageList(){
        SuiteLogger.logMessage("Click button Message List");
        buttonMessageList().click();
    }

    /**
     * Нажать New Message
     */
    public static void clickCreateNewMessageButton(){
        SuiteLogger.logMessage("Click button New Message");
        buttonNewMessage().click();
    }

    /**
     * Убедиться, что открыта сообщение совпадает
     */
    public static void assertMessageIsCorrect(String headline,String text){
        assertElementHasCorrectText(_headline, headline);
        assertElementHasCorrectText(_text, text);
    }



}
