package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;

/**
 * Страница MessageList
 */
public class MessageList extends AbstractPage {
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
     *
     * @return TableManager
     */
    private static TableManager tableMessages() {
        return new TableManager(_table);
    }


    /**
     * Убедиться, что открыта страница Message List
     */
    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    /**
     * Нажать NewMessage
     */
    public static void clickNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        driver.findElement(_buttonNewMessage).click();
    }

    private static int returnRowIndex(String headline, String text){

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        return tableMessages().getIndexOfRow(cond);
    }

    /**
     * Убедиться, что в табице есть строка с заданными значениями headline и  text
     *
     * @param headline значение столбца headline
     * @param text     значение столбца text
     */
    public static void assertMessageIsInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list");

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Row is founded.");

        } else {
            SuiteLogger.logFail("Row is not founded.");
        }


    }

    public static void assertMessageIsNotInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is not in list");

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logFail("Row is founded.");
        } else {
            SuiteLogger.logMessage("Row is not founded.");
        }

    }

    public static void clickViewButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking View button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

            if (index > 1) {
                SuiteLogger.logMessage("Click!");
                driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='View']")).click();
            } else {
                SuiteLogger.logFail("Cannot click View button.");
            }

    }

    public static void clickEditButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='Edit']")).click();
        } else {
            SuiteLogger.logFail("Cannot click Edit button.");
        }
    }

    public static void clickDeleteButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        int index = returnRowIndex(headline,text);

        if (index > 1) {
            SuiteLogger.logMessage("Click!");
            driver.findElement(By.xpath("//tr[" + --index + "]//a[text()='Delete']")).click();

        } else {
            SuiteLogger.logFail("Cannot click Delete button.");
        }

    }

}
