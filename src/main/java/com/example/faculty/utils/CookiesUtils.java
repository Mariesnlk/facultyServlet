package com.example.faculty.utils;

import com.example.faculty.exception.InvalidDataRuntimeException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class CookiesUtils {

    public static final String ENCODING = "UTF-8";
    public static final String LOCALE = "locale";
    public static final String BUNDLE = "bundle";

    private CookiesUtils() {
    }

    public static String readCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (key.equals(c.getName())) {
                try {
                    return URLDecoder.decode(c.getValue(), ENCODING);
                } catch (UnsupportedEncodingException e) {
                    throw new InvalidDataRuntimeException();
                }
            }
        }
        return null;
    }
}
