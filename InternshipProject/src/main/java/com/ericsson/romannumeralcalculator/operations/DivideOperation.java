package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.romannumeralcalculator.converter.RomanNumeralConverter;
import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

@Component
public class DivideOperation implements Operation {

    @Autowired
    RomanNumeralConverter converter;

    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        final RomanNumeral romanNumeral = new RomanNumeral();
        final int result = converter.convertNumeralToNumber(numeralOne) / converter.convertNumeralToNumber(numeralTwo);
        romanNumeral.setNumeralValue(converter.convertNumberToNumeral(result));
        return romanNumeral;
    }
}
