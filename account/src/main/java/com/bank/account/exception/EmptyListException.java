package com.bank.account.exception;

/**
 * Exception for getList method
 */
public class EmptyListException extends RuntimeException {
    public EmptyListException(String message) {
        super(message);
    }
}
