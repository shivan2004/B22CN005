package com.b22cn005.backend.exceptions;

public class OriginalUrlBlankException extends RuntimeException{
    public OriginalUrlBlankException(String message) {
        super(message);
    }
}
