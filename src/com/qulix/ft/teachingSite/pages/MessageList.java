package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

/**
 * Страница MessageList
 */
public class MessageList extends AbstractPage{
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
     * Номер колонки Headline
     */
    private static final int _headlineCol = 2;
    /**
     * Номер колонки Text
     */
    private static final int _textCol = 3;

    /**
     * Объект класса TableManager для работы с таблицей
     * @return TableManager
     */
    private static TableManager tableMessages(){
        return new TableManager(_table);
    }
    /**
     * Убедиться, что открыта страница Message List
     */
    public static void assertPageIsOpened(){
       assertPageIsOpened(_labelMessageList, "Message List");
    }
    /**
     *  Нажать NewMessage
     */
    public static void clickNewMessage(){
        SuiteLogger.logMessage("Click button NewMessage");
        driver.findElement(_buttonNewMessage).click();
    }

    /**
     *  Убедиться, что в табице есть строка с заданными значениями headline и  text
     *  Внимание! Не реализован переход по страницам, поиск ведется только на текущей странице
     * @param headline значение столбца headline
     * @param text значение столбца text
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
