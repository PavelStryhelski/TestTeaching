package com.qulix.ft.utils;

public class CollectionUtils {

    /**
     * �������� �� ������ ������ �������
     * @param array ������
     * @param what ������� ��� ��������
     * @return true, ���� � ������� ���� ����� �������
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
