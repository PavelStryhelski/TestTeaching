package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.components.TableManager;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * �������� MessageList
 */
public class MessageList extends AbstractPage {
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
     * ������� ������ Next page
     */
    private static final By _page = Locators.get(Environment.MAPS.MESSAGE_LIST, "nextPage");

    boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();
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
     *
     * @return TableManager
     */
    private static TableManager tableMessages() {
        return new TableManager(_table);
    }


    /**
     * ���������, ��� ������� �������� Message List
     */
    public static void assertPageIsOpened() {
        assertPageIsOpened(_labelMessageList, "Message List");
    }

    /**
     * ������ NewMessage
     */
    public static void clickNewMessage() {
        SuiteLogger.logMessage("Click button NewMessage");
        driver.findElement(_buttonNewMessage).click();
    }

    /**
     * ������ NextPage
     */
    public static void clickNextPage() {
        SuiteLogger.logMessage("Click button NextPage");
        driver.findElement(_page).click();
    }

    /**
     * ���������, ��� � ������ ���� ������ � ��������� ���������� headline �  text
     * ��������! �� ���������� ������� �� ���������, ����� ������� ������ �� ������� ��������
     *
     * @param headline �������� ������� headline
     * @param text     �������� ������� text
     */
    public static void assertMessageIsInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is in list");

        boolean stop = false;
        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();

        do {

            int index = tableMessages().getIndexOfRow(cond);

            if (index > 1) {
                SuiteLogger.logMessage("Row is founded.");
                stop = true;
            } else {
                if(_nextPageButtonIsPresentOnThePage){
                clickNextPage();
                } else {
                    SuiteLogger.logError("Row is not founded.");
                    stop = true;
                }
            }
        } while(!stop);

    }

    public static void assertMessageIsNotInList(String headline, String text) {
        SuiteLogger.logMessage("Checking that message with Headline " + headline + " and Text " + text + " is not in list");

        boolean stop = false;
        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);

        do {

            boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();
            int index = tableMessages().getIndexOfRow(cond);

            if (index > 1) {
                SuiteLogger.logError("Row is founded.");
                stop = true;
            } else {
                if(_nextPageButtonIsPresentOnThePage){
                    clickNextPage();
                } else {
                    SuiteLogger.logMessage("Row is not in list.");
                    stop = true;
                }
            }
        } while(!stop);

    }

    public static void clickViewButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking View button for Headline: " + headline + "and Text: " + text);

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();
        boolean stop = false;

        do {

            int index = tableMessages().getIndexOfRow(cond);

            if (index > 1) {
                SuiteLogger.logMessage("Click!");
                driver.findElement(By.xpath("//tr[" + --index  + "]//a[text()='View']")).click();
                stop = true;
            } else {
                if(_nextPageButtonIsPresentOnThePage){
                    clickNextPage();
                } else {
                    stop = true;
                }
            }
        } while(!stop);

    }

    public static void clickEditButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Edit button for Headline: " + headline + "and Text: " + text);

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();
        boolean stop = false;

        do {

            int index = tableMessages().getIndexOfRow(cond);

            if (index > 1) {
                SuiteLogger.logMessage("Click!");
                driver.findElement(By.xpath("//tr[" + --index  + "]//a[text()='Edit']")).click();
                stop = true;
            } else {
                if(_nextPageButtonIsPresentOnThePage){
                    clickNextPage();
                } else {
                    stop = true;
                }
            }
        } while(!stop);

    }

    public static void clickDeleteButton(String headline, String text) {
        SuiteLogger.logMessage("Clicking Delete button for Headline: " + headline + "and Text: " + text);

        TableManager.RowCondition cond = TableManager.createCondition();
        cond.addCondition(_headlineCol, headline);
        cond.addCondition(_textCol, text);
        boolean _nextPageButtonIsPresentOnThePage = driver.findElement(_page).isDisplayed();
        boolean stop = false;

        do {

            int index = tableMessages().getIndexOfRow(cond);

            if (index > 1) {
                SuiteLogger.logMessage("Deleting!");
                driver.findElement(By.xpath("//tr[" + --index  + "]//a[text()='Delete']")).click();
                stop = true;
            } else {
                if(_nextPageButtonIsPresentOnThePage){
                    clickNextPage();
                } else {
                    stop = true;
                }
            }
        } while(!stop);

    }

}
