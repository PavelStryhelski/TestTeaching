package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.components.AbstractComponent;
import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.SuiteLogger;
import org.openqa.selenium.By;

/**
 * ����������� ��������.
 * � ������ ����� �������� ������ �������-������� ����� ������
 */

public class AbstractPage extends AbstractComponent {

    private static final By _logoutLocator = By.xpath("//a[text()='Logout']");

    /**
     * ���������, ��� ������� �����
     */
    //todo non public
    public static void assertPageIsOpened(By element, String formName){

        try{
            driver.findElement(element);
            SuiteLogger.logMessage("Page " + formName + " is opened", GetScreenshot.fromDriver());
        }catch(Exception e){
            SuiteLogger.logError("Page " + formName + " is not opened");
        }
    }

    /**
     * ���������, ��� ���� ������ ������ ������� � ������ �������
     */
    //todo non public
    public static void assertElementHasCorrectText(By element, String text){

            if (driver.findElement(element).getText().equals(text)){
            SuiteLogger.logMessage("Element " + element + "`s text equals to " + text, GetScreenshot.fromDriver());
            }

            else if (driver.findElement(element).getAttribute("value").equals(text)){
                SuiteLogger.logMessage("Element " + element + "`s value equals to " + text, GetScreenshot.fromDriver());
            }

            else {
            SuiteLogger.logError("Element " + element + "`s value/text does not equal to " + text);
            }

    }


    /**
    Log out for all Pages except Login Page
     */
    public static void LogOut(){

        try {
            driver.findElement(_logoutLocator).click();
            SuiteLogger.logMessage("Logout");
        } catch (Exception e){
            SuiteLogger.logError("You cannot logout from this page");
        }

    }


}
