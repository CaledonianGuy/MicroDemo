package com.tsi.kirk.mcallister.microdemo.exceptions;

public class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
