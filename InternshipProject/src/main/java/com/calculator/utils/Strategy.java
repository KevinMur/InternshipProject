package com.calculator.utils;

import com.calculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *      Interface to be implemented by classed that will handle mathematical operations
 *      to be carried out by the calculator application 
 *
 */
public interface Strategy {
    RomanNumeral doOperation(final String numeralOne, final String numeralTwo);
}
