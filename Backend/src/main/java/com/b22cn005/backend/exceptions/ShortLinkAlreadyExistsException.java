package com.b22cn005.backend.exceptions;

public class ShortLinkAlreadyExistsException extends RuntimeException{

    public ShortLinkAlreadyExistsException(String message) {
        super(message);
    }
}
