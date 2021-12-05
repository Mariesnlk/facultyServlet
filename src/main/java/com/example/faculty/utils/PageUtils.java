package com.example.faculty.utils;

public class PageUtils {

    public static int getPageNumber(String strNumber) {
        try {
            return Integer.parseInt(strNumber);
        } catch (IllegalArgumentException e) {
            return 1;
        }
    }
}
