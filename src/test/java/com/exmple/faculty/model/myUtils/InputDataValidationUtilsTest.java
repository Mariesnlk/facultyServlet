package com.exmple.faculty.model.myUtils;

import com.example.faculty.utils.InputDataValidationUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputDataValidationUtilsTest {

    @Test
    public void isCorrectEmail() {
        assertEquals(InputDataValidationUtils.isCorrectEmail("mariesnlk@gmail.com"), true);
        assertEquals(InputDataValidationUtils.isCorrectEmail(""), false);
    }

    @Test
    public void isValidPassword() {
        assertEquals(InputDataValidationUtils.isValidPassword("Testing123!", "Testing123!"), true);
        assertEquals(InputDataValidationUtils.isValidPassword("Testing123!", "Testing"), false);
        assertEquals(InputDataValidationUtils.isValidPassword("", ""), false);
    }

    @Test
    public void isSamePassword() {
        assertEquals(InputDataValidationUtils.isSamePassword("Testing123!", "Testing123!"), true);
        assertEquals(InputDataValidationUtils.isSamePassword("Testing123!", "Testing123"), false);
    }

    @Test
    public void isCorrectName() {
        assertEquals(InputDataValidationUtils.isCorrectName("Anna"), true);
        assertEquals(InputDataValidationUtils.isCorrectName("111"), false);
    }

    @Test
    public void isCorrectPIB() {
        assertEquals(InputDataValidationUtils.isCorrectPIB("Anna", "Mariia", "Synelnyk"), true);
        assertEquals(InputDataValidationUtils.isCorrectPIB("111", "Mariia", "Synelnyk"), false);
    }

    @Test
    public void isNotCorrectData() {
        assertEquals(InputDataValidationUtils.isNotCorrectData("", "Mariia", "Synelnyk", "Testing123!"), true);
        assertEquals(InputDataValidationUtils.isNotCorrectData("Anna", "Mariia", "Synelnyk", "mariesnlk@gmail.com"), false);
    }

    @Test
    public void isNullOrEmpty() {
        assertEquals(InputDataValidationUtils.isNullOrEmpty("Testing123!"), false);
    }

}
