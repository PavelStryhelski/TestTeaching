package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.WebDriverFactory;
import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.pages.AbstractPage;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * ����� ����� ��� ���� ������
 */
public abstract class AbstractTest {

    /**
     * ������� ����������
     */
    public WebDriver driver;

    /**
     * ������������� ��������� � ��������
     *
     * @param context @see ITestContext
     */
    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        WebDriverFactory.init(WebDriverFactory.Browser.CHROME);
        driver = WebDriverFactory.instance().openNewBrowser();
        GetScreenshot.setWebDriver(driver);
        SuiteLogger.startLogSuite(context.getSuite().getName() + ". URL: " + Environment.URL); //����� � ��� ��������� � ������ ����������
    }

    /**
     * ������������� ����� ����������� ������ (�����)
     *
     * @param method �����, ������� ����� �����������
     */
    @BeforeMethod
    public void openStartPage(Method method) {
        SuiteLogger.logMessage("Start method  " + method.getName());
        driver.get(Environment.URL); //�������� ��������� ��������
        //���������� ���� ��������
        Selenium selenium = new WebDriverBackedSelenium(driver, Environment.URL);
        selenium.windowMaximize();
    }

    /**
     * �������� ��������
     */
    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
        SuiteLogger.logMessage("Suite ended");
    }

    /**
     * ����� ��������� ���������� ������ ����� ���������� ������ ������� ������ � ���
     *
     * @param result ITestResult
     */
    @AfterMethod(alwaysRun = true)
    public void verifyTestStatus(ITestResult result) {

        if (SuiteLogger.hasErrors()) {
            Reporter.log("Test ended with errors.");
        }

    }
}
