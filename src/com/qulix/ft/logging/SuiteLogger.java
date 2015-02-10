package com.qulix.ft.logging;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Enumeration;

/**
 * Логирование хода выполнения (использует log4j)
 */
public class SuiteLogger {

    /**
     * количество полученных fail сообщений
     */
    private static int testFailsCount = 0;

    /**
     * Статус сообщения
     * ERROR - прервет выполнение теста
     */
    private static enum Level {
        WARN, INFO, DEBUG, FAIL, ERROR
    }

    /**
     * Строка, которая используется для обозначения, что в лог нужно поместить скриншот
     */
    static final String screenShotId = "[screenshot:";
    static final String imagesFolder = "images";
    /**
     * Если опция установлена в true, то в случае ошибки перед вызовом exception и остановкой теста появится сообщение в консоли с ожиданием пользовательского ввода
     */
    public static boolean DEBUG = false;

    /**
     * log4j логгер
     */
    private static Logger logger = Logger.getLogger("com.qulix.ft.teachingSite.tests");

    private static String logPath = getLogPath();

    private static String getLogPath() {
        Enumeration appenders = logger.getAllAppenders();

        while (appenders.hasMoreElements()) {
            Object appender = appenders.nextElement();
            if (appender instanceof FileAppender) {
                String file = ((FileAppender) appender).getFile();
                file = new File(file).getParent();
                if (!file.endsWith(File.separator)) file += File.separator;
                file += imagesFolder + File.separator;
                new File(file).mkdirs();
                return file;
            }
        }
        try {
            logger.addAppender(new FileAppender(new SuiteHTMLLayout(), "logs\\suiteLog.html"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "logs\\images\\";
    }

    /**
     * Вывод инфо сообщения
     *
     * @param message Сообщение
     * @see Logger
     */
    private static void info(String message) {
        logger.info(message);
    }

    /**
     * Вывод debug сообщения
     *
     * @param message Сообщение
     * @see Logger
     */
    public static void debug(String message) {
        logger.debug(message);
    }

    /**
     * Вывод warning сообщения
     *
     * @param message Сообщение
     * @see Logger
     */
    private static void warn(String message) {
        logger.warn(message);
    }

    /**
     * Вывод error сообщения
     *
     * @param message Сообщение
     * @see Logger
     */
    private static void error(String message) {
        logger.error(message);
    }

    /**
     * Вывод инфо сообщения
     *
     * @param message Сообщение
     */
    public static void logMessage(String message) {
        SuiteLogger.info(message);
    }

    /**
     * Вывод error сообщения и прерывание выполнения
     *
     * @param message Сообщение
     */
    public static void logError(String message) {
        logFail(message);

        if (DEBUG) {
            System.out.print("Включена опция DEBUG. Тест будет остановлен после нажатия любой клавиши. ");
            try {
                System.in.read();
            } catch (Exception e) {
                logFail("Произошла ошибка при ожидании пользовательского ввода: " + e.getMessage());
            }
        }

        throw new RuntimeException("Test ended with critical error: " + message);
    }

    /**
     * Вывод warning сообщения
     *
     * @param message Сообщение
     */
    public static void logWarning(String message) {
        SuiteLogger.warn(message);
    }

    /**
     * Вывод error сообщения
     *
     * @param message Сообщение
     */
    public static void logFail(String message) {
        SuiteLogger.error(message);
        testFailsCount++;
    }

    /**
     * Есть ли ошибки
     *
     * @return true, если за время выполнения теста были выводы сообщений error, fail или warn
     */
    public static boolean hasErrors() {
        return testFailsCount > 0;
    }

    /**
     * Вывод в лог сообщения и скриншота
     *
     * @param message    Текст сообщения
     * @param screenShot Файл скриншота
     * @param level      Статус сообщения
     * @see Level
     */
    private static void logMessageWithScreenShot(String message, File screenShot, Level level) {
        File logScreenshot = new File(logPath + screenShot.getName());
        screenShot.renameTo(logScreenshot);
        message += screenShotId + imagesFolder + File.separator + logScreenshot.getName() + "]";
        switch (level) {
            case INFO:
                info(message);
                break;
            case WARN:
                warn(message);
                break;
            case ERROR:
                logError(message);
                break;
            case DEBUG:
                debug(message);
                break;
            case FAIL:
                logFail(message);
                break;
            default:
                info(message);
        }
    }

    /**
     * Вывод в лог сообщения и скриншота
     *
     * @param message    Текст сообщения
     * @param screenShot Путь к файлу скриншота
     * @param level      Статус сообщения
     * @see Level
     */
    private static void logMessageWithScreenShot(String message, String screenShot, Level level) {
        logMessageWithScreenShot(message, new File(screenShot), level);
    }

    /**
     * Вывод в лог info сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Файл скриншота
     */
    public static void logMessage(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.INFO);
    }

    /**
     * Вывод в лог info сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Путь к файлу скриншота
     */
    public static void logMessage(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.INFO);
    }

    /**
     * Вывод в лог error сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Файл скриншота
     */
    public static void logError(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.ERROR);
    }

    /**
     * Вывод в лог error сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Путь к файлу скриншота
     */
    public static void logError(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.ERROR);
    }

    /**
     * Вывод в лог fail сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Файл скриншота
     */
    public static void logFail(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.FAIL);
    }

    /**
     * Вывод в лог fail сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Путь к файлу скриншота
     */
    public static void logFail(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.FAIL);
    }

    /**
     * Вывод в лог warning сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Файл скриншота
     */
    public static void logWarning(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.WARN);
    }

    /**
     * Вывод в лог warning сообщения и скриншота
     *
     * @param message    Сообщение
     * @param screenShot Путь к файлу скриншота
     */
    public static void logWarning(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.WARN);
    }

    /**
     * Вывод в лог сообщения о начале выполнения Suite
     *
     * @param suiteName Название suite
     */
    public static void startLogSuite(String suiteName) {
        logMessage("Starting <suite> " + suiteName);
    }

    /**
     * Вывод в лог сообщения о начале выполнения теста (сбрасывает счетчик ошибок)
     *
     * @param testName Имя теста
     */
    public static void startLogTest(String testName) {
        logMessage("Starting <test> " + testName);
        testFailsCount = 0;
    }

}

