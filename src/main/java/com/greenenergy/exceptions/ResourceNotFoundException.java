package com.greenenergy.exceptions;

/**
 * ResourceNotFoundException.
 *
 * @author javad talebi
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
