package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� ShowMessage
 */

public class ShowMessage extends AbstractPage{
    /**
     * ������� ������������ ��������
    */
    private static final By _labelShowMessage = Locators.get(Environment.MAPS.SHOW_MESSAGE, "labelShowMessage");
    /**
     * ������� ������ MessageList
    */
    private static final By _buttonMessageList = Locators.get(Environment.MAPS.SHOW_MESSAGE, "buttonMessageList");

    /**
     * ������ MessageList
     *
     * @return ������ MessageList
     */
    private static WebElement buttonMessageList() {
        return driver.findElement(_buttonMessageList);
    }

    /**
     * ���������, ��� ������� �������� Show message
     */
    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelShowMessage, "Show Message");
    }

    /**
     * ������ Message List
     */
    public static void clickMessageList(){
        SuiteLogger.logMessage("Click button Message List");
        buttonMessageList().click();
    }

}
