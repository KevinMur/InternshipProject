package com.calculator.exceptions;

/**
 * @author ekvumer
 * 
 * Validation Exception thrown if Roman numeral validation fails
 *
 */
public class ValidationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ValidationException() {
        super("Validation exception for incorrent numeral entered.");
    }
}
