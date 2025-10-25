package com.codecode.controlleradvice;

public class ResourceNotFoundException extends Exception  {
    String message;

    ResourceNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return " Resource Not Found! "+ message;
    }
}
