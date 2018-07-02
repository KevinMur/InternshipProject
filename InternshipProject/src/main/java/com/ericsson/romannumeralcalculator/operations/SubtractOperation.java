package com.ericsson.romannumeralcalculator.operations;

import org.springframework.stereotype.Component;

import com.ericsson.romannumeralcalculator.converter.Converter;
import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *
 *         Subtract class that implements Operation interface that can add two roman numerals
 *
 */

@Component
public class SubtractOperation implements Operation {

    /**
     * @param numeralOne
     *            the roman numeral that second numeral is subtracted from
     * @param numeralTwo
     *            the roman numeral that is subtracted from numeralOne
     * @return Returns the result of subtracting numeralTwo from numeralOne. Will add a '-' to the beginning of the resulting roman numeral if it is
     *         negative. Will return 'Nulla' (latin for 0) if result is 0.
     */
    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        final RomanNumeral romanNumeral = new RomanNumeral();
        final Converter converter = new Converter();
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
