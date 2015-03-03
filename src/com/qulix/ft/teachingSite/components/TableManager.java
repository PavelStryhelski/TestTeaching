package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

/**
 * Класс для работы с таблицами
 */
public class TableManager extends AbstractComponent {

    private By tableLocator;
    private static final By _rowLocator = By.tagName("tr");
    private static final By _cellLocator = By.tagName("td");
    private static final By _firstPage = By.xpath("//a[@class='step' and text()='1']");
    private static final By _nextPageButton = By.xpath("//div[@class='paginateButtons']//a[@class='nextLink']");


    public TableManager(By locator) {
        this.tableLocator = locator;
    }

    /**
     * Получить строку таблицы (элемент tr)
     *
     * @param index Номер строки
     * @return Элемент tr таблицы
     */
    private WebElement getRow(int index) {
        logDebug("Getting row " + index);
        return getRows().get(--index);
    }

    /**
     * Все строки таблицы
     *
     * @return Все строки таблицы (tr)
     */
    private List<WebElement> getRows() {
        WebElement table = getElement(tableLocator);
        List<WebElement> rows = table.findElements(_rowLocator);
        return rows;
    }

    /**
     * Получение текста ячейки
     *
     * @param row   Строка (элемент tr)
     * @param index Номер ячейки в строке
     * @return Текст ячейки (с выполнением trim())
     */
    public String getCellText(WebElement row, int index) {
        logDebug("Getting cell text with index " + index);
        return getCellText(getCell(row, index));
    }

    /**
     * Получение ячейки (элемент td)
     *
     * @param row   Cтрока в таблице
     * @param index Номер ячейки в строке
     * @return Ячейка (элемент td)
     */
    private WebElement getCell(WebElement row, int index) {
        if (getCells(row).size() >= index) {
            return getCells(row).get(--index);
        } else {
            logDebug("Row doesn't exist with index " + index);
            return null;
        }
    }

    /**
     * Все ячейки строки
     *
     * @param row Строка (элемент tr)
     * @return Все ячейки строки
     */
    private List<WebElement> getCells(WebElement row) {
        List<WebElement> cells = row.findElements(_cellLocator);
        return cells;
    }


    /**
     * Получение текста ячейки
     *
     * @param cell Ячейка (элемент td)
     * @return Текст ячейки (с выполнением trim())
     */
    public String getCellText(WebElement cell) {
        if (cell == null) {
            logDebug("Cell doesn't exist");
            return null;
        }
        String cellText = cell.getText().trim();
        logDebug("Cell text: " + cellText);
        return cellText;
    }

    /**
     * Поиск строки с текстом в указанной ячейке
     *
     * @param cellIndex Номер ячейки, где должен быть требуемый текст
     * @param text      Текст, по которому найти строку
     * @return Строка (элемент tr) или null, если строки по таким условиям не найдено
     */
    private WebElement findRowWithCellText(int cellIndex, String text) {

        int index = findRowIndexWithCellText(cellIndex, text);

        if (index < 1) return null;

        return getRow(index);
    }

    /**
     * Поиск строки с текстом в указанной ячейке
     *
     * @param cellIndex Номер ячейки, где должен быть требуемый текст
     * @param text      Текст, по которому найти строку
     * @return Номер строки или -1, если строки по таким условиям не найдено
     */
    public int findRowIndexWithCellText(int cellIndex, String text) {

        SuiteLogger.logMessage("Searching row with text " + text + " in cell " + cellIndex);
        boolean notFound;
        List<WebElement> rows = getRows();

        for (int i = 0; i < rows.size(); i++) {

            notFound = false;
            logDebug("Checking row " + (i + 1));

            String cellText = getCellText(rows.get(i), cellIndex);
            logDebug("Got cell(" + (i + 1) + ", " + cellIndex + ") value:" + cellText);

            if (cellText != null) {

                if (!cellText.equalsIgnoreCase(text)) {
                    notFound = true;
                } else {
                    notFound = false;
                }

            } else {
                notFound = true;
            }

            if (!notFound) {
                return i + 1;
            }
        }

        return -1;
    }


    /**
     * Поиск строки с возможностью задания множественного критерия
     *
     * @param condition Критерий поиска
     * @return Номер первой соответствующей строки или -1, если строка не найдена
     */
    public int getIndexOfRow(RowCondition condition) {
        return getIndexOfRow(condition, 1);
    }

    /**
     * Получить номер строки, соответствующей условию
     *
     * @param condition    Условие отбора
     * @param startFromRow Начинать поиск со строки
     * @return Номер первой найденной строки (начиная с startFromRow) или -1, если строка не найдена
     */
    public int getIndexOfRow(RowCondition condition, int startFromRow) {

        Object[] cellIndexes = condition.getAllConditions().keySet().toArray();
        Object[] cellValues = condition.getAllConditions().values().toArray();
        boolean notFound;
        boolean isThisFirstPage;
        boolean stop;

        if (assertElementIsDisplayed(_firstPage)) {
            isThisFirstPage = false;
        } else {
            isThisFirstPage = true;
        }

        do {

            stop = false;
            List<WebElement> rows = getRows();
            logDebug("Checking page ");

            for (int i = startFromRow - 1; i < rows.size(); i++) {

                notFound = false;
                logDebug("Checking row " + (i + 1));

                for (int k = 0; k < cellIndexes.length; k++) {

                    String cellText = getCellText(rows.get(i), Integer.valueOf(cellIndexes[k].toString()));
                    logDebug("Got cell(" + i + ", " + Integer.valueOf(cellIndexes[k].toString()) + ") value:" + cellText);

                    if (cellText != null) {

                        if (cellValues[k] instanceof String[]) {
                            if (!CollectionUtils.contains((String[]) cellValues[k], cellText)) {
                                notFound = true;
                            }
                        } else {
                            if (!cellText.equalsIgnoreCase(cellValues[k].toString())) {
                                notFound = true;
                            }
                        }

                    } else {
                        notFound = true;
                    }

                    if (notFound) {
                        break;
                    }

                }

                if (!notFound) {
                    return i + 1;
                }
            }

            if (!isThisFirstPage) {
                isThisFirstPage = true;
                clickOnElement(_firstPage);
            } else if (assertElementIsDisplayed(_nextPageButton)) {
                clickOnElement(_nextPageButton);
            } else {
                stop  = true;
            }

        } while (!stop);

        return -1;
    }

    /**
     * Создание условия
     *
     * @return Пустое условие поиска
     */
    public static RowCondition createCondition() {
        return new RowCondition();
    }

    /**
     * Класс, отвечающий за представление множественного критерия поиска
     */
    public static class RowCondition {

        private Properties cells = new Properties();

        /**
         * Добавить условие поиска
         *
         * @param cellIndex По какой ячейке
         * @param cellValue Какой текст
         */
        public void addCondition(int cellIndex, String cellValue) {
            cells.put(cellIndex, cellValue);
        }

        /**
         * Добавить условие поиска
         *
         * @param cellIndex  По какой ячейке
         * @param cellValues Какой текст
         */
        public void addCondition(int cellIndex, String[] cellValues) {
            cells.put(cellIndex, cellValues);
        }

        /**
         * Получить все условия
         *
         * @return Все критерии данного условия
         */
        public Properties getAllConditions() {
            return cells;
        }

        public String toString() {
            return cells.toString();
        }

    }


}
