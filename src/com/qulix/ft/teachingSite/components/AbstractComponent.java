package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.tests.AbstractTest;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent{

    protected static WebDriver driver = AbstractTest.driver;

    protected static void logDebug(String message) {
        SuiteLogger.debug(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + ":" + message);
    }
}
