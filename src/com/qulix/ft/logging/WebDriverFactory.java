package com.qulix.ft.logging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.LinkedList;

public class WebDriverFactory {

    private WebDriver activeDriver;

    private Browser defaultBrowser;

    private static WebDriverFactory _instance;

    private static LinkedList<WebDriver> _listOfWebDrivers = new LinkedList<>();

    public static enum Browser {
        IE,
        CHROME;
    }

    private WebDriverFactory(Browser defaultBrowser) {
        this.defaultBrowser = defaultBrowser;
    }

    public static void init() {
        init(Browser.IE);
    }

    public static void init(Browser defaultBrowser) {
        if (_instance == null) _instance = new WebDriverFactory(defaultBrowser);
    }

    public static WebDriverFactory instance() {
        init();
        return _instance;
    }

    public WebDriver getActiveWebDriver() {
        return activeDriver;
    }

    public void setActiveWebDriver(WebDriver driver){
        activeDriver = driver;
    }

    public WebDriver openNewBrowser() {
        return openNewBrowser(defaultBrowser);
    }


    public WebDriver openNewBrowser(Browser browser) {

        File file;

            switch (browser) {
                case IE:
                    file = new File("drivers" + File.separator + "IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    activeDriver = new InternetExplorerDriver();
                    _listOfWebDrivers.add(activeDriver);
                    break;
                case CHROME:
                    file = new File("drivers" + File.separator + "ChromeDriver.exe");
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    activeDriver = new ChromeDriver();
                    _listOfWebDrivers.add(activeDriver);
                    break;
                default:
                    file = new File("drivers" + File.separator + "IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    activeDriver = new InternetExplorerDriver();
                    _listOfWebDrivers.add(activeDriver);
                    break;
            }

            activeDriver.manage().deleteAllCookies();

        return getActiveWebDriver();
    }

    /**
     * Закрытие браузера
     */
    public void closeBrowsers() {

        for (WebDriver driver : _listOfWebDrivers){
            driver.close();
            driver.quit();
        }
        SuiteLogger.logMessage("Suite ended");
    }




}
