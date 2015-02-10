package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

/**
 * �������� MessageList
 */
public class MessageList extends AbstractPage{
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
     * ����� ������� Headline
     */
    private static final int _headlineCol = 2;
    /**
     * ����� ������� Text
     */
    private static final int _textCol = 3;

    /**
     * ������ ������ TableManager ��� ������ � ��������
     * @return TableManager
     */
    private static TableManager tableMessages(){
        return new TableManager(_table);
    }
    /**
     * ���������, ��� ������� �������� Message List
     */
    public static void assertPageIsOpened(){
       assertPageIsOpened(_labelMessageList, "Message List");
    }
    /**
     *  ������ NewMessage
     */
    public static void clickNewMessage(){
        SuiteLogger.logMessage("Click button NewMessage");
        driver.findElement(_buttonNewMessage).click();
    }

    /**
     *  ���������, ��� � ������ ���� ������ � ��������� ���������� headline �  text
     *  ��������! �� ���������� ������� �� ���������, ����� ������� ������ �� ������� ��������
     * @param headline �������� ������� headline
     * @param text �������� ������� text
     */
    public static void assertMessageIsInList(String headline, String text){
        SuiteLogger.logMessage("Check that message with Headline " + headline + " and Text " + text + " is in list");

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        int index = tableMessages().getIndexOfRow(cond);
        if(index>1){
            SuiteLogger.logMessage("Row is founded.");
        }else{
            SuiteLogger.logFail("Row is not found");
        }
    }
}
