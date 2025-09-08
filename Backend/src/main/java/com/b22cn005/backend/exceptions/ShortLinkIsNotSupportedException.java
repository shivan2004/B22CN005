package com.b22cn005.backend.exceptions;

public class ShortLinkIsNotSupportedException extends RuntimeException {
    public ShortLinkIsNotSupportedException(String message) {
        super(message);
    }
}
