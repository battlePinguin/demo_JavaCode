package com.javacode.demo_javacode.utils.exception;

public class WalletNotFoundException extends RuntimeException {

    public WalletNotFoundException(final String message) {
        super(message);
    }
}
