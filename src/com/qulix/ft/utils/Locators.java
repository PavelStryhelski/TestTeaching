package com.qulix.ft.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс для получения локаторов объектов из карт
 * Карта должна быть формата properties файла: название_объекта=способо_идентификации_объекта:локатор_объекта
 * Способ_идентификации_объекта может быть:
 * <p>id - By.id<p>
 * <p>xpath - By.xpath<p>
 * <p>name - By.name<p>
 * <p>link - By.linkText<p>
 * <p>partLink - By.partialLinkText<p>
 * <p>css - By.cssSelector<p>
 * <p>class - By.className<p>
 * <p>tag - By.tagName<p>
 */
public class Locators {

    /**
     * Загруженные карты объектов
     */
    private static Map<String, LocatorsMap> maps = new HashMap<String, LocatorsMap>();

    /**
     * Класс для получения локаторов карты
     */
    static class LocatorsMap {

        /**
         * Локаторы карты
         */
        private Map<String, By> locators = new HashMap<String, By>();
        /**
         * Название карты (путь к файлу карты)
         */
        private String name;

        /**
         * Загружает локаторы карты.
         *
         * @param file Путь к файлу карты
         * @throws Exception Генерирует IOException в случае ошибки чтения карты и IllegalArgumentException в случае неправильного идентификатора
         */
        LocatorsMap(String file) throws Exception {

            this.name = file;
            Properties map = new Properties();

            map.load(new InputStreamReader(new FileInputStream(file)));

            for (String propName : map.stringPropertyNames()) {

                String propValue = map.getProperty(propName).split(":", 2)[1];
                String by = map.getProperty(propName).split(":")[0];
                By byLocator;

                if (by.equalsIgnoreCase("id")) {
                    byLocator = By.id(propValue);
                } else if (by.equalsIgnoreCase("name")) {
                    byLocator = By.name(propValue);
                } else if (by.equalsIgnoreCase("link")) {
                    byLocator = By.linkText(propValue);
                } else if (by.equalsIgnoreCase("xpath")) {
                    byLocator = By.xpath(propValue);
                } else if (by.equalsIgnoreCase("partLink")) {
                    byLocator = By.partialLinkText(propValue);
                } else if (by.equalsIgnoreCase("css")) {
                    byLocator = By.cssSelector(propValue);
                } else if (by.equalsIgnoreCase("class")) {
                    byLocator = By.className(propValue);
                } else if (by.equalsIgnoreCase("tag")) {
                    byLocator = By.tagName(propValue);
                } else {
                    throw new IllegalArgumentException("In map " + file + " object " + propName + " has incorrect type of locator: " + by);
                }

                locators.put(propName.toLowerCase(), byLocator);
            }

        }

        /**
         * Получение локатора
         *
         * @param name Название объекта в карте
         * @return Локатор объекта
         * @throws IllegalArgumentException Если объекта с таким именем нет в карте
         */
        By getLocator(String name) throws IllegalArgumentException {
            if (!locators.containsKey(name.toLowerCase()))
                throw new IllegalArgumentException("There is no object " + name + " in map " + this.name);
            return locators.get(name.toLowerCase());
        }

    }

    /**
     * Получение локатора
     *
     * @param map    Название карты (путь к файлу с картой)
     * @param object Название объекта в карте
     * @return Локатор объекта
     */
    public static By get(String map, String object) {
        map = map.toLowerCase();
        if (!maps.containsKey(map)) {
            try {
                maps.put(map, new LocatorsMap(map));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return maps.get(map).getLocator(object);
    }
}

