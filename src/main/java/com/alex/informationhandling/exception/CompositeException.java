package com.alex.informationhandling.exception;

public class CompositeException extends Exception {

    public CompositeException(String message) {
        super(message);
    }

    public CompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompositeException(Throwable cause) {
        super(cause);
    }

    protected CompositeException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
