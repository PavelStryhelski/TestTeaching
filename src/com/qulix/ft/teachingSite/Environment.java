package com.qulix.ft.teachingSite;

import com.qulix.ft.utils.*;

import java.io.File;

/**
 * Окружение теста
 */
public class Environment {

    /**
     * Файл настроек
     */
    public static final String PROP_FILE = "settings.properties";
   /**
     * URL приложения
     */
    public static final String URL = getURL();
    /**
     * Перечень карт объектов
     *
     * @see com.qulix.ft.utils
     */
    public final static class MAPS {

        private final static String mapsFolder = "maps" + File.separator;

        /**
         * Карта страницы логина
         */
        public final static String LOGIN = mapsFolder + "login.map";
        /**
         * Карта объектов главной страницы
         */
        public final static String MAIN = mapsFolder + "main.map";
         /**
         * Карта объектов Message List
         */
        public final static String MESSAGE_LIST = mapsFolder + "messageList.map";
         /**
         * Карта объектов Create Message
         */
        public final static String CREATE_MESSAGE = mapsFolder + "createMessage.map";
         /**
         * Карта объектов Show Message
         */
        public final static String SHOW_MESSAGE = mapsFolder + "showMessage.map";
    }

    private static String getURL() {
        String url = PropertiesManager.get(PROP_FILE, "url");

        if (url == null || url.equals("")) {
            throw new RuntimeException("URL not specified! Current value: " + url);
        }

        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }

        return url;
    }

}
