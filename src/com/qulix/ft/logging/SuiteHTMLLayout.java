package com.qulix.ft.logging;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Формат вывода HTML лога
 */
public class SuiteHTMLLayout extends org.apache.log4j.HTMLLayout {

    private int errNumber = 1;
    private int warnNumber = 1;

    /**
     * Формат представления даты/времени
     */
    private String timestampFormat = "yyyy-MM-dd-HH:mm:ss"; // Default format. Example: 2008-11-21-18:35:21

    /**
     * выполняет форматирование даты/времени
     */
    private SimpleDateFormat sdf = new SimpleDateFormat(timestampFormat);

    private static final String screenShotId = SuiteLogger.screenShotId;

    /**
     * Построение заголовка файла лога
     *
     * @return HTML заголовок файла лога (то, что пишется в файл лога до внесения первой записи о событии)
     */
    @Override
    public String getHeader() {

        try {

            String header = "";
            Scanner fr = new Scanner(new FileReader("utils" + File.separator + "htmlLogHeader.html"));
            while (fr.hasNextLine()) {
                header += fr.nextLine() + "\n";
            }
            return header;
        } catch (Exception e) {
            throw new RuntimeException("Unable to initialize ft.logging", e);
        }

    }

    /**
     * Построение окончания файла лога
     *
     * @return HTML окончание файла лога (то, что пишется в файл лога после внесения последней записи о событии)
     */
    @Override
    public String getFooter() {

        try {

            String footer = "";
            Scanner fr = new Scanner(new FileReader("utils" + File.separator + "htmlLogFooter.html"));
            while (fr.hasNextLine()) {
                footer += fr.nextLine() + "\n";
            }
            return footer;
        } catch (Exception e) {
            throw new RuntimeException("Unable to finalize ft.logging", e);
        }

    }


    /**
     * Задание формата вывода записи о событии
     *
     * @param event Событие
     * @return HTML текст для помещения в лог записи
     */
    public String format(LoggingEvent event) {
        String result;

        if (((String) event.getMessage()).contains("<suite>")) return formatSuiteStart(event);
        if (((String) event.getMessage()).contains("<test>")) return formatTestStart(event);

        switch (event.getLevel().toInt()) {
            case Level.ERROR_INT:
                result = "<tr class='err'>";
                break;
            case Level.WARN_INT:
                result = "<tr class='warn'>";
                break;
            case Level.DEBUG_INT:
                result = "<tr name='debug'>";
                break;
            default:
                result = "<tr>";
        }

        String message = (String) event.getMessage();

        if (message.contains(screenShotId)) {
            int start = message.indexOf(screenShotId) + screenShotId.length();
            int end = message.indexOf("]", start);
            String file = message.substring(start, end);
            message = message.replace(screenShotId + file + "]", "");
            message = StringEscapeUtils.escapeHtml(message).replace("\n", "<br/>");
            message = message.replace("\t", "&nbsp;&nbsp;&nbsp;");
            message += "<img height=100px width=200px src='" + file + "'/><br>";
            message += "<a target=new href='" + file + "'>Full screen</a>";
        } else {
            message = StringEscapeUtils.escapeHtml(message).replace("\n", "<br/>");
            message = message.replace("\t", "&nbsp;&nbsp;&nbsp;");
        }

        message = removeParameterSymbols(message);

        if (event.getLevel().toInt()==Level.ERROR_INT){
            message = "<a name=error"+ errNumber++ + ">_</a>" + message;
        }

        if (event.getLevel().toInt()==Level.WARN_INT){
            message = "<a name=warn"+ warnNumber++ + ">_</a>" + message;
        }

        result += "<td>" + sdf.format(new Date(event.timeStamp)) + "</td>";
        result += "<td title=\"" + event.getThreadName() + " thread\">" + event.getThreadName() + "</td>";
        result += "<td title=\"Level\">" + event.getLevel() + "</td>";
        result += "<td title=\"" + event.getLoggerName() + " category\">" + event.getLoggerName() + "</td>";
        result += "<td title=\"Message\">" + message + "</td>";
        result += "</tr>";

        return result;
    }

    private String removeParameterSymbols(String source){

        int start = source.indexOf("[parameter:");
        if (start>-1){
            start += "[parameter:".length();
            int end = source.indexOf("]", start);
            String paramValue = source.substring(start, end);

            String newString = source.replace("[parameter:" + paramValue + "]", "<strong>" + paramValue + "</strong>");

            return removeParameterSymbols(newString);

        } else {
            return source;
        }
    }

    /**
     * Вывод сообщения о начале выполнения Suite
     *
     * @param event Событие
     * @return HTML форматированная строка
     */
    private String formatSuiteStart(LoggingEvent event) {
        String result = "<div><h1>";
        result += ((String) event.getMessage()).split("<suite>")[1];
        result += "</h1></div>";
        return result;
    }

    /**
     * Вывод сообщения о начале выполнения теста
     *
     * @param event Событие
     * @return HTML форматированная строка
     */
    private String formatTestStart(LoggingEvent event) {
        String result = "<tr><td>" + sdf.format(new Date(event.timeStamp)) + "</td>";
        result += "<td colspan=4><center><b>" + ((String) event.getMessage()).split("<test>")[1] + "</b></center></td></tr>";
        return result;
    }

    /**
     * Setter for timestamp format. Called if log4j.appender.<category>.layout.TimestampFormat property is specfied
     */
    public void setTimestampFormat(String format) {
        this.timestampFormat = format;
        this.sdf = new SimpleDateFormat(format); // Use the format specified by the TimestampFormat property
    }

    /**
     * Getter for timestamp format being used.
     */
    public String getTimestampFormat() {
        return this.timestampFormat;
    }
}

