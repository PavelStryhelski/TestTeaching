package com.qulix.ft.utils;

public class CollectionUtils {

    /**
     * Содержит ли массив данный элемент
     * @param array Массив
     * @param what Элемент для проверки
     * @return true, если в массиве есть такой элемент
     */
    public static boolean contains(String[] array, String what){
        for (String element: array){
            if (element.equalsIgnoreCase(what)){
                return true;
            }
        }

        return false;
    }

}
