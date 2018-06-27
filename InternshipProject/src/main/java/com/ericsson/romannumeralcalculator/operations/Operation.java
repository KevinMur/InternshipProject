package com.ericsson.romannumeralcalculator.operations;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer Interface to be implemented by classed that will handle mathematical operations to be carried out by the calculator application
 *
 */
public interface Operation {
    RomanNumeral doOperation(final String numeralOne, final String numeralTwo);
}
