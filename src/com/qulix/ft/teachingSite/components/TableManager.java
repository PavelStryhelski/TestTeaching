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
    private static final By rowLocator = By.tagName("tr");
    private static final By cellLocator = By.tagName("td");
    private static final By _pages = By.xpath("//a[@class='step']");
    private static final int _authorCol = 4;

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
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(rowLocator);
        return rows;
    }

    /**
     * ��� �������� �������
     *
     * @return ��� ��������
     */
    private List<WebElement> getPages() {
        List<WebElement> pages = driver.findElements(_pages);
        return pages;
    }

    /**
     * �������� ��������
     *
     * @param index ����� ������
     * @return ��������

    private WebElement getPage(int index) {
        logDebug("Getting page " + index);
        return getPages().get(index);
    } */

    /**
     * �������� �� ����� ��������
     *
     * @param index ����� ��������
     */
    private void clickOnThePage(int index) {
        logDebug("Clicking on page " + index);
        By newPage = By.xpath("//a[@class='step'][text()='" + index + "']");
        driver.findElement(newPage).click();
    }

    /**
     * ���������� �� ������ ����� ��������
     *
     * @param index ����� ��������
     */
    private boolean assertPageIsPresent(int index) {
        By newPage = By.xpath("//a[@class='step'][text()='" + index + "']");
        try{
            driver.findElement(newPage);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

    private boolean assertAuthorIsCorrect(int index,String author){
        if (driver.findElement(By.xpath("//div[@class='list']//tr[" + index +  "]/td[" + _authorCol + "]")).getText().equals(author)){
            return true;
        } else {
            return false;
        }
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
        List<WebElement> cells = row.findElements(cellLocator);
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

    public int getIndexOfRow(RowCondition condition, String author) {
        return getIndexOfRow(condition, 1, author);
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
        List<WebElement> pages = getPages();
        boolean notFound;

        if (assertPageIsPresent(1)){
            clickOnThePage(1);
        }

        for (int j = 0; j <= pages.size();j++) {

            List<WebElement> rows = getRows();
            logDebug("Checking page " + (j + 1));

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

              if (assertPageIsPresent(j+2)){
                  clickOnThePage(j + 2);
              } else {
                  return -1;
              }

        }

        /*logDebug("Row not found");*/

        return -1;
    }

    public int getIndexOfRow(RowCondition condition, int startFromRow, String author) {

        Object[] cellIndexes = condition.getAllConditions().keySet().toArray();
        Object[] cellValues = condition.getAllConditions().values().toArray();
        List<WebElement> pages = getPages();
        boolean notFound;

        if (assertPageIsPresent(1)){
            clickOnThePage(1);
        }

        //TODO Remove duplicate


        //TODO Check on current page and if not found goto first page
        //TODO Use toNextPage instead of toPage(int)

        for (int j = 0; j <= pages.size();j++) {

            List<WebElement> rows = getRows();
            logDebug("Checking page " + (j + 1));

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
                    if (assertAuthorIsCorrect(i,author)){
                    return i + 1;
                    }
                }
            }

            if (assertPageIsPresent(j+2)){
                clickOnThePage(j + 2);
            } else {
                return -1;
            }

        }

        /*logDebug("Row not found");*/

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
