package com.example.faculty.utils;

import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputDataValidationUtils {

    private static final String EMAIL_PATTERN = "^(.+)@(.+)$";
    private static final String CORRECT_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    private static final String CORRECT_NAME = "[A-Za-zА-Яа-яєі]*";

    private static final Logger LOGGER = Logger.getLogger(InputDataValidationUtils.class);

    private InputDataValidationUtils() {
    }

    public static boolean isCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        LOGGER.info(matcher.matches());
        return matcher.matches();
    }

    public static boolean isValidPassword(String password1, String password2) {
        Pattern validPassword = Pattern.compile(CORRECT_PASSWORD);
        Matcher matcher = validPassword.matcher(password1);
        return isSamePassword(password1, password2) && matcher.matches();
    }

    public static boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    public static boolean isCorrectName(String name) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_NAME);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
        return matcher.matches();
    }

    public static boolean isCorrectPIB(String firstName, String secondName, String lastName) {
        return isCorrectName(firstName) && isCorrectName(secondName) && isCorrectName(lastName);
    }

    public static boolean isNotCorrectData(String firstName, String secondName, String lastName,
                                           String email, String password, String confirmPassword) {
        return !(isCorrectPIB(firstName, secondName, lastName)
                && isCorrectEmail(email)
                && isValidPassword(password, confirmPassword));
    }

    public static boolean isNotCorrectData(String firstName, String secondName, String lastName,
                                           String email) {
        return !(isCorrectPIB(firstName, secondName, lastName)
                && isCorrectEmail(email));
    }

    public static boolean isNullOrEmpty(String input){
        return (Objects.isNull(input) && input.isEmpty());
    }

}
