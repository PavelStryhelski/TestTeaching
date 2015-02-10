package com.qulix.ft.teachingSite.components;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.teachingSite.tests.AbstractTest;
import org.openqa.selenium.WebDriver;

/**
 * Абстрактный компонент, используется для работы с GUI приложения.
 * Вся работа с GUI должна вестись через потомков этого класса.
 */
public abstract class AbstractComponent{
    /**
     * Драйвер приложения
     */
    protected static WebDriver driver = AbstractTest.driver;

    /**
     * Выводит в лог информация со статусом DEBUG.
     * К сообщению добавляется название класса и метода, который выводит сообщение.
     *
     * @param message Сообщение для помещения в лог
     */
    protected static void logDebug(String message) {
        SuiteLogger.debug(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + ":" + message);
    }
}
