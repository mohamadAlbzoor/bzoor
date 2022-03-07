package com.example.bzoor.handler;

public class deleteException extends RuntimeException{
    public deleteException(String message) {
        super(message);
    }

    public deleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
