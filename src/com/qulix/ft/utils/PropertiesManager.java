package com.qulix.ft.utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ����� ��� ��������� �������� �� ����� properties
 * ���� ������ ��������� �������� ���������� � �������: ��������_���������=��������
 */
public class PropertiesManager {

    /**
     * ����������� ���������
     */
    private static Map<String, Properties> runProps = new HashMap<String, Properties>();

    /**
     * ��������� ���������
     *
     * @param file      �������� ����� (���� � ����� � �����������)
     * @param parameter �������� ��������� � �����
     * @return �������� ���������
     */
    public static String get(String file, String parameter) {
        if (!runProps.containsKey(file)) {
            try {
                runProps.put(file, getProperties(file));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return runProps.get(file).getProperty(parameter);
    }

    private static Properties getProperties(String file) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileReader(file));
        return prop;
    }
}
