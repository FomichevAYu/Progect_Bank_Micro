package com.bank.account.exception;

/**
 * Exception for getEntity method
 */

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(long id) {
        super("Entity with id: " + id + " not found");
    }
}
