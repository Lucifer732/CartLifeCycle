package com.Ftd.Product.Exceptions;

public class InputInvalidationException extends Exception{
    private int statusCode;
    private String message;

    public InputInvalidationException(int statusCode, String message) {

        this.statusCode = statusCode;
        this.message = message;
    }
}
