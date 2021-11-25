package com.example.faculty.utils;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputDataRegistrationUtils {

    private static final String EMAIL_PATTERN = "^(.+)@(.+)$";
    private static final String CORRECT_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    private static final String CORRECT_NAME = "[A-Za-zА-Яа-яєі]*";

    private static final Logger LOGGER = Logger.getLogger(InputDataRegistrationUtils.class);

    private InputDataRegistrationUtils() {
    }

    private static boolean isCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        LOGGER.info(matcher.matches());
        return matcher.matches();
    }

    private static boolean isValidPassword(String password1, String password2) {
        Pattern validPassword = Pattern.compile(CORRECT_PASSWORD);
        Matcher matcher = validPassword.matcher(password1);
        return isSamePassword(password1, password2) && matcher.matches();
    }

    private static boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    private static boolean isCorrectName(String name) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_NAME);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
        return matcher.matches();
    }

    private static boolean isCorrectPIB(String firstName, String secondName, String lastName) {
        return isCorrectName(firstName) && isCorrectName(secondName) && isCorrectName(lastName);
    }

    public static boolean isNotCorrectData(String firstName, String secondName, String lastName,
                                           String email, String password, String confirmPassword) {
        return !(isCorrectPIB(firstName, secondName, lastName)
                && isCorrectEmail(email)
                && isValidPassword(password, confirmPassword));
    }
}
