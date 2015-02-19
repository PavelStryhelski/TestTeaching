package com.qulix.ft.logging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;

public class WebDriverFactory {

    private WebDriver activeDriver;

    private Browser defaultBrowser;

    private static WebDriverFactory _instance;

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

    public WebDriver get() {
        return activeDriver;
    }

    public WebDriver openNewBrowser() {
        return openNewBrowser(defaultBrowser);
    }


    public WebDriver openNewBrowser(Browser browser) {

        File file;

        if (activeDriver == null) {

            switch (browser) {
                case IE:
                    file = new File("drivers" + File.separator + "IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    activeDriver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    file = new File("drivers" + File.separator + "ChromeDriver.exe");
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    activeDriver = new ChromeDriver();
                    break;
                default:
                    file = new File("drivers" + File.separator + "IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    activeDriver = new InternetExplorerDriver();
            }

            activeDriver.manage().deleteAllCookies();

        }

        return get();
    }


}
