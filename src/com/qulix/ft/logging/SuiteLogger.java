package com.qulix.ft.logging;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Enumeration;

/**
 * ����������� ���� ���������� (���������� log4j)
 */
public class SuiteLogger {

    /**
     * ���������� ���������� fail ���������
     */
    private static int testFailsCount = 0;

    /**
     * ������ ���������
     * ERROR - ������� ���������� �����
     */
    private static enum Level {
        WARN, INFO, DEBUG, FAIL, ERROR
    }

    /**
     * ������, ������� ������������ ��� �����������, ��� � ��� ����� ��������� ��������
     */
    static final String screenShotId = "[screenshot:";
    static final String imagesFolder = "images";
    /**
     * ���� ����� ����������� � true, �� � ������ ������ ����� ������� exception � ���������� ����� �������� ��������� � ������� � ��������� ����������������� �����
     */
    public static boolean DEBUG = false;

    /**
     * log4j ������
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
     * ����� ���� ���������
     *
     * @param message ���������
     * @see Logger
     */
    private static void info(String message) {
        logger.info(message);
    }

    /**
     * ����� debug ���������
     *
     * @param message ���������
     * @see Logger
     */
    public static void debug(String message) {
        logger.debug(message);
    }

    /**
     * ����� warning ���������
     *
     * @param message ���������
     * @see Logger
     */
    private static void warn(String message) {
        logger.warn(message);
    }

    /**
     * ����� error ���������
     *
     * @param message ���������
     * @see Logger
     */
    private static void error(String message) {
        logger.error(message);
    }

    /**
     * ����� ���� ���������
     *
     * @param message ���������
     */
    public static void logMessage(String message) {
        SuiteLogger.info(message);
    }

    /**
     * ����� error ��������� � ���������� ����������
     *
     * @param message ���������
     */
    public static void logError(String message) {
        logFail(message);

        if (DEBUG) {
            System.out.print("�������� ����� DEBUG. ���� ����� ���������� ����� ������� ����� �������. ");
            try {
                System.in.read();
            } catch (Exception e) {
                logFail("��������� ������ ��� �������� ����������������� �����: " + e.getMessage());
            }
        }

        throw new RuntimeException("Test ended with critical error: " + message);
    }

    /**
     * ����� warning ���������
     *
     * @param message ���������
     */
    public static void logWarning(String message) {
        SuiteLogger.warn(message);
    }

    /**
     * ����� error ���������
     *
     * @param message ���������
     */
    public static void logFail(String message) {
        SuiteLogger.error(message);
        testFailsCount++;
    }

    /**
     * ���� �� ������
     *
     * @return true, ���� �� ����� ���������� ����� ���� ������ ��������� error, fail ��� warn
     */
    public static boolean hasErrors() {
        return testFailsCount > 0;
    }

    /**
     * ����� � ��� ��������� � ���������
     *
     * @param message    ����� ���������
     * @param screenShot ���� ���������
     * @param level      ������ ���������
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
     * ����� � ��� ��������� � ���������
     *
     * @param message    ����� ���������
     * @param screenShot ���� � ����� ���������
     * @param level      ������ ���������
     * @see Level
     */
    private static void logMessageWithScreenShot(String message, String screenShot, Level level) {
        logMessageWithScreenShot(message, new File(screenShot), level);
    }

    /**
     * ����� � ��� info ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� ���������
     */
    public static void logMessage(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.INFO);
    }

    /**
     * ����� � ��� info ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� � ����� ���������
     */
    public static void logMessage(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.INFO);
    }

    /**
     * ����� � ��� error ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� ���������
     */
    public static void logError(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.ERROR);
    }

    /**
     * ����� � ��� error ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� � ����� ���������
     */
    public static void logError(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.ERROR);
    }

    /**
     * ����� � ��� fail ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� ���������
     */
    public static void logFail(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.FAIL);
    }

    /**
     * ����� � ��� fail ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� � ����� ���������
     */
    public static void logFail(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.FAIL);
    }

    /**
     * ����� � ��� warning ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� ���������
     */
    public static void logWarning(String message, File screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.WARN);
    }

    /**
     * ����� � ��� warning ��������� � ���������
     *
     * @param message    ���������
     * @param screenShot ���� � ����� ���������
     */
    public static void logWarning(String message, String screenShot) {
        logMessageWithScreenShot(message, screenShot, Level.WARN);
    }

    /**
     * ����� � ��� ��������� � ������ ���������� Suite
     *
     * @param suiteName �������� suite
     */
    public static void startLogSuite(String suiteName) {
        logMessage("Starting <suite> " + suiteName);
    }

    /**
     * ����� � ��� ��������� � ������ ���������� ����� (���������� ������� ������)
     *
     * @param testName ��� �����
     */
    public static void startLogTest(String testName) {
        logMessage("Starting <test> " + testName);
        testFailsCount = 0;
    }

}

