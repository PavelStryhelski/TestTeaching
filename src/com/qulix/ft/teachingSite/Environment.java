package com.qulix.ft.teachingSite;

import com.qulix.ft.utils.*;

import java.io.File;

/**
 * ��������� �����
 */
public class Environment {

    /**
     * ���� ��������
     */
    public static final String PROP_FILE = "settings.properties";
   /**
     * URL ����������
     */
    public static final String URL = getURL();
    /**
     * �������� ���� ��������
     *
     * @see com.qulix.ft.utils
     */
    public final static class MAPS {

        private final static String mapsFolder = "maps" + File.separator;

        /**
         * ����� �������� ������
         */
        public final static String LOGIN = mapsFolder + "login.map";
        /**
         * ����� �������� ������� ��������
         */
        public final static String MAIN = mapsFolder + "main.map";
         /**
         * ����� �������� Message List
         */
        public final static String MESSAGE_LIST = mapsFolder + "messageList.map";
         /**
         * ����� �������� Create Message
         */
        public final static String CREATE_MESSAGE = mapsFolder + "createMessage.map";
         /**
         * ����� �������� Show Message
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
