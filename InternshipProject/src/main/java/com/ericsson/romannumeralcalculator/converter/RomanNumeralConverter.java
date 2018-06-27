package com.ericsson.romannumeralcalculator.converter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author ekvumer
 *
 *         Class used to convert from numerals to numbers and vice-versa
 *
 */
@Component
public class RomanNumeralConverter {

    private static final Map<Character, Integer> CONVERT_TO_NUMBER_MAP = new HashMap<>();
    private static final Map<Integer, String> CONVERT_TO_NUMERAL_MAP = new LinkedHashMap<>();

    static {
        CONVERT_TO_NUMBER_MAP.put('M', 1000);
        CONVERT_TO_NUMBER_MAP.put('D', 500);
        CONVERT_TO_NUMBER_MAP.put('C', 100);
        CONVERT_TO_NUMBER_MAP.put('L', 50);
        CONVERT_TO_NUMBER_MAP.put('X', 10);
        CONVERT_TO_NUMBER_MAP.put('V', 5);
        CONVERT_TO_NUMBER_MAP.put('I', 1);

        CONVERT_TO_NUMERAL_MAP.put(1000, "M");
        CONVERT_TO_NUMERAL_MAP.put(900, "CM");
        CONVERT_TO_NUMERAL_MAP.put(500, "D");
        CONVERT_TO_NUMERAL_MAP.put(400, "CD");
        CONVERT_TO_NUMERAL_MAP.put(100, "C");
        CONVERT_TO_NUMERAL_MAP.put(90, "XC");
        CONVERT_TO_NUMERAL_MAP.put(50, "L");
        CONVERT_TO_NUMERAL_MAP.put(40, "XL");
        CONVERT_TO_NUMERAL_MAP.put(10, "X");
        CONVERT_TO_NUMERAL_MAP.put(9, "IX");
        CONVERT_TO_NUMERAL_MAP.put(5, "V");
        CONVERT_TO_NUMERAL_MAP.put(4, "IV");
        CONVERT_TO_NUMERAL_MAP.put(1, "I");
    }

    /**
     * @param numeral
     *            numeral that is going to be converted to a number
     * @return the number that the numeral entered represented
     */
    public int convertNumeralToNumber(final String numeral) {
        int convertedTotal = 0;
        int currentValue = 0;
        int previousValue = 0;

        for (int i = numeral.length() - 1; i >= 0; i--) {
            currentValue = CONVERT_TO_NUMBER_MAP.get(numeral.charAt(i));
            if (currentValue < previousValue) {
                convertedTotal -= currentValue;
            } else {
                convertedTotal += currentValue;
            }
            previousValue = currentValue;
        }
        return convertedTotal;
    }

    /**
     * @param numeralValue
     *            number that is going to be converted into a numeral
     *
     *            a linked hash map is used for this conversion as the order that the keys are put into this map are kept and this method takes
     *            advantage of this property
     *
     * @return
     *
     *         the numeral string that is a representation of the number inputted
     */
    public String convertNumberToNumeral(int numeralValue) {
        final StringBuilder numeralOutput = new StringBuilder();

        while (numeralValue > 0) {
            for (final Map.Entry<Integer, String> entry : CONVERT_TO_NUMERAL_MAP.entrySet()) {
                if (numeralValue >= entry.getKey()) {
                    numeralOutput.append(entry.getValue());
                    numeralValue -= entry.getKey();
                    break;
                }
            }
        }
        return numeralOutput.toString();
    }
}
