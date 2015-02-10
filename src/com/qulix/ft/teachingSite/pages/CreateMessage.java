package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� CreateMessage
 */
public class CreateMessage extends AbstractPage{

    /**
     * ������� ������������ ��������
    */
    private static final By _labelCreateMessage = Locators.get(Environment.MAPS.CREATE_MESSAGE, "labelCreateMessage");
    /**
     * ������� ������ Create
    */
    private static final By _buttonCreate = Locators.get(Environment.MAPS.CREATE_MESSAGE, "buttonCreate");
    /**
     * ������� ���� HeadLine
    */
    private static final By _editHeadline = Locators.get(Environment.MAPS.CREATE_MESSAGE, "editHeadline");
    /**
     * ������� ���� Text
    */
    private static final By _editText = Locators.get(Environment.MAPS.CREATE_MESSAGE, "editText");

    /**
     * ���� HeadLine
     *
     * @return ���� ������
     */
    private static WebElement editHeadline() {
        return driver.findElement(_editHeadline);
    }

    /**
     * ���� Text
     *
     * @return ���� Text
     */
    private static WebElement editText() {
        return driver.findElement(_editText);
    }

    /**
     * ������ Create
     *
     * @return ������ Create
     */
    private static WebElement buttonCreate() {
        return driver.findElement(_buttonCreate);
    }

    /**
     * ���������, ��� ������� �������� Create Message
     */
    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelCreateMessage, "Create Message");
    }

    /**
     * ������ Create
     */
    public static void clickCreate(){
        SuiteLogger.logMessage("Click button Create");
        buttonCreate().click();
    }

    /**
     * ��������� ����� Create message: ������ headline � text, ������ Create
     * @param headline �������� headline
     * @param text �������� text
     */
    public static void createMessage(String headline, String text){

        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        editHeadline().sendKeys(headline);
        editText().sendKeys(text);
        clickCreate();

    }
}
