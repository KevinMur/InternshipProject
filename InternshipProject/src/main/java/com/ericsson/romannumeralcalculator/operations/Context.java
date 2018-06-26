package com.ericsson.romannumeralcalculator.operations;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *
 *         Context class that stores and executes a strategy
 *
 */
public class Context {

    private final Operation operation;

    public Context(final Operation operation) {
        this.operation = operation;
    }

    /**
     * @param numeralOne
     *            First roman numeral entered by the user
     * @param numeralTwo
     *            Second roman numeral entered by the user
     * @return Returns a roman numeral object that holds the result of the calculation
     */
    public RomanNumeral executeOperation(final String numeralOne, final String numeralTwo) {
        return operation.doOperation(numeralOne, numeralTwo);
    }
}
