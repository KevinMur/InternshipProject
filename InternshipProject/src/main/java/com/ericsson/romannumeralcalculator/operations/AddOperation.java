package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;

import com.ericsson.romannumeralcalculator.converter.RomanNumeralConverter;
import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer Operation add class that can add two roman numerals
 *
 */
public class AddOperation implements Operation {

    /**
     * method inherited from Strategy interface
     *
     * @param numeralOne
     *            First roman numeral enetered by the user
     * @param numeralTwo
     *            Second roman numeral entered by the user
     * @return Returns a roman numeral object that holds the result of the addition
     *
     */

    @Autowired

    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        final RomanNumeral romanNumeral = new RomanNumeral();
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        final int result = converter.convertNumeralToNumber(numeralOne) + converter.convertNumeralToNumber(numeralTwo);
        romanNumeral.setNumeralValue(converter.convertNumberToNumeral(result));

        return romanNumeral;

    }

}
