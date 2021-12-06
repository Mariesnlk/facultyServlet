package com.example.faculty.exception;

public class NameIsAlreadyTaken extends RuntimeException {

    public NameIsAlreadyTaken() {
    }

    public NameIsAlreadyTaken(String message) {
        super(message);
    }

    public NameIsAlreadyTaken(Throwable throwable) {
        super(throwable);
    }

    public NameIsAlreadyTaken(String message, Throwable throwable) {
        super(message, throwable);
    }

}
