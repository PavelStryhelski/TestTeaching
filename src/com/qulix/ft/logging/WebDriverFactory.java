package com.qulix.ft.logging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class WebDriverFactory {

    private RemoteWebDriver activeDriver;

    private Browser defaultBrowser;

    private WebDriverFactory _instance;

    public static enum Browser {
        IE,
        CHROME;
    }

    public WebDriverFactory() {
    }


    public WebDriver get() {
        return activeDriver;
    }

    public WebDriver openNewBrowser() {
        return openNewBrowser(defaultBrowser);
    }


    public WebDriver openNewBrowser(Browser browser) {

        File file;

//        if (activeDriver == null) {

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

//        }

        return get();
    }


}
