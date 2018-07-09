package com.ericsson.romannumeralcalculator.romannumeral;

import java.io.Serializable;

/**
 * @author ekvumer
 *
 *         Roman Numeral class used to return numeral information back to the UI
 */

public class RomanNumeral implements Serializable {

    private String numeralValue;

    public String getNumeralValue() {
        return numeralValue;
    }

    public void setNumeralValue(final String numeralValue) {
        this.numeralValue = numeralValue;
    }
}
