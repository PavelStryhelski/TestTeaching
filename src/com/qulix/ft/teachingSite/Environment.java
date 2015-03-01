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

    public static final String URL = getURL();

    /**
     * Перечень карт объектов
     *
     * @see com.qulix.ft.utils
     */
    public final static class MAPS {

        private final static String mapsFolder = "maps" + File.separator;

        public final static String LOGIN = mapsFolder + "login.map";

        public final static String MAIN = mapsFolder + "main.map";

        public final static String MESSAGE_LIST = mapsFolder + "messageList.map";

        public final static String CREATE_MESSAGE = mapsFolder + "createMessage.map";

        public final static String SHOW_MESSAGE = mapsFolder + "showMessage.map";

        public final static String EDIT_MESSAGE = mapsFolder + "editMessage.map";
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
