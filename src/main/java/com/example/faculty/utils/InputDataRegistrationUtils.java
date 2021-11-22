package com.example.faculty.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputDataRegistrationUtils {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{5,20}";
    private static final String CORRECT_NAME = "[a-zA-Z\\p{IsCyrillic}]{3,20}";

    private InputDataRegistrationUtils() {
    }

    private static boolean isCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
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
