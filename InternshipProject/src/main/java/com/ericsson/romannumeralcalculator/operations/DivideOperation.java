package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.romannumeralcalculator.converter.Converter;
import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *
 *         Divide class that implements Operation interface that can add two roman numerals
 *
 */
@Component
public class DivideOperation implements Operation {

    @Autowired
    Converter converter;

    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        final RomanNumeral romanNumeral = new RomanNumeral();
        final int result = converter.convertNumeralToNumber(numeralOne) / converter.convertNumeralToNumber(numeralTwo);
        if (result == 0) {
            romanNumeral.setNumeralValue("Nulla");
        } else {
            romanNumeral.setNumeralValue(converter.convertNumberToNumeral(result));
        }
        return romanNumeral;
    }
}
