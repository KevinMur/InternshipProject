package com.ericsson.romannumeralcalculator.exceptions;

/**
 * @author ekvumer
 *
 *         Validation Exception thrown if Roman numeral validation fails
 *
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationException(final String numerals) {
        super("Validation exception for incorrent numerals entered: " + numerals);
    }
}
