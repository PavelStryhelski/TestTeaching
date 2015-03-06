package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.logging.GetScreenshot;
import com.qulix.ft.logging.WebDriverFactory;
import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
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
    public WebDriver jd_driver;


    /**
     * ������������� ��������� � ��������
     *
     * @param context @see ITestContext
     */
    @BeforeSuite
    public void beforeSuite(ITestContext context) throws InterruptedException {
        WebDriverFactory WDF_jd = new WebDriverFactory();
        WDF_jd.openNewBrowser(WebDriverFactory.Browser.CHROME);
        jd_driver = WDF_jd.get();

        WebDriverFactory WDF_admin = new WebDriverFactory();
        WDF_admin.openNewBrowser(WebDriverFactory.Browser.CHROME);
        driver = WDF_admin.get();

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
        jd_driver.get(Environment.URL);
        Selenium selenium = new WebDriverBackedSelenium(driver, Environment.URL);
        Selenium seleniumjd = new WebDriverBackedSelenium(jd_driver, Environment.URL);
        selenium.windowMaximize();
        seleniumjd.windowMaximize();
    }

    /**
     * �������� ��������
     */
    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
        jd_driver.close();
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
