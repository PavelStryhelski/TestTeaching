package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

/**
 * ����� ��� ������ � ���������
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
     * �������� ������ ������� (������� tr)
     *
     * @param index ����� ������
     * @return ������� tr �������
     */
    private WebElement getRow(int index) {
        logDebug("Getting row " + index);
        return getRows().get(--index);
    }

    /**
     * ��� ������ �������
     *
     * @return ��� ������ ������� (tr)
     */
    private List<WebElement> getRows() {
        WebElement table = getElement(tableLocator);
        List<WebElement> rows = table.findElements(_rowLocator);
        return rows;
    }

    /**
     * ��������� ������ ������
     *
     * @param row   ������ (������� tr)
     * @param index ����� ������ � ������
     * @return ����� ������ (� ����������� trim())
     */
    public String getCellText(WebElement row, int index) {
        logDebug("Getting cell text with index " + index);
        return getCellText(getCell(row, index));
    }

    /**
     * ��������� ������ (������� td)
     *
     * @param row   C����� � �������
     * @param index ����� ������ � ������
     * @return ������ (������� td)
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
     * ��� ������ ������
     *
     * @param row ������ (������� tr)
     * @return ��� ������ ������
     */
    private List<WebElement> getCells(WebElement row) {
        List<WebElement> cells = row.findElements(_cellLocator);
        return cells;
    }


    /**
     * ��������� ������ ������
     *
     * @param cell ������ (������� td)
     * @return ����� ������ (� ����������� trim())
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
     * ����� ������ � ������� � ��������� ������
     *
     * @param cellIndex ����� ������, ��� ������ ���� ��������� �����
     * @param text      �����, �� �������� ����� ������
     * @return ������ (������� tr) ��� null, ���� ������ �� ����� �������� �� �������
     */
    private WebElement findRowWithCellText(int cellIndex, String text) {

        int index = findRowIndexWithCellText(cellIndex, text);

        if (index < 1) return null;

        return getRow(index);
    }

    /**
     * ����� ������ � ������� � ��������� ������
     *
     * @param cellIndex ����� ������, ��� ������ ���� ��������� �����
     * @param text      �����, �� �������� ����� ������
     * @return ����� ������ ��� -1, ���� ������ �� ����� �������� �� �������
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
     * ����� ������ � ������������ ������� �������������� ��������
     *
     * @param condition �������� ������
     * @return ����� ������ ��������������� ������ ��� -1, ���� ������ �� �������
     */
    public int getIndexOfRow(RowCondition condition) {
        return getIndexOfRow(condition, 1);
    }

    /**
     * �������� ����� ������, ��������������� �������
     *
     * @param condition    ������� ������
     * @param startFromRow �������� ����� �� ������
     * @return ����� ������ ��������� ������ (������� � startFromRow) ��� -1, ���� ������ �� �������
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
     * �������� �������
     *
     * @return ������ ������� ������
     */
    public static RowCondition createCondition() {
        return new RowCondition();
    }

    /**
     * �����, ���������� �� ������������� �������������� �������� ������
     */
    public static class RowCondition {

        private Properties cells = new Properties();

        /**
         * �������� ������� ������
         *
         * @param cellIndex �� ����� ������
         * @param cellValue ����� �����
         */
        public void addCondition(int cellIndex, String cellValue) {
            cells.put(cellIndex, cellValue);
        }

        /**
         * �������� ������� ������
         *
         * @param cellIndex  �� ����� ������
         * @param cellValues ����� �����
         */
        public void addCondition(int cellIndex, String[] cellValues) {
            cells.put(cellIndex, cellValues);
        }

        /**
         * �������� ��� �������
         *
         * @return ��� �������� ������� �������
         */
        public Properties getAllConditions() {
            return cells;
        }

        public String toString() {
            return cells.toString();
        }

    }


}
