package com.b22cn005.backend.exceptions;

public class ShortLinkNotFoundException extends RuntimeException {
    public ShortLinkNotFoundException(String message) {
        super(message);
    }
}
