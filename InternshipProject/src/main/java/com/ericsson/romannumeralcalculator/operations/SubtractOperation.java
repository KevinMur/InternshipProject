package com.ericsson.romannumeralcalculator.operations;

import com.ericsson.romannumeralcalculator.converter.RomanNumeralConverter;
import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

public class SubtractOperation implements Operation {

    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        final RomanNumeral romanNumeral = new RomanNumeral();
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        final int result = converter.convertNumeralToNumber(numeralOne) - converter.convertNumeralToNumber(numeralTwo);

        if (result < 0) {
            romanNumeral.setNumeralValue("-" + converter.convertNumberToNumeral(Math.abs(result)));
        } else if (result == 0) {
            romanNumeral.setNumeralValue("Nulla");
        } else {
            romanNumeral.setNumeralValue(converter.convertNumberToNumeral(Math.abs(result)));
        }
        return romanNumeral;
    }
}
