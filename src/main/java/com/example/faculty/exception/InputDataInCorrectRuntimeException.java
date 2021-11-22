package com.example.faculty.exception;

public class InputDataInCorrectRuntimeException extends RuntimeException {

    public InputDataInCorrectRuntimeException() {
    }

    public InputDataInCorrectRuntimeException(String message) {
        super(message);
    }

    public InputDataInCorrectRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
