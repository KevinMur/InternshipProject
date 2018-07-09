package com.ericsson.romannumeralcalculator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * @author ekvumer
 *
 *         Roman numeral validator class used for validation. Validation regex source:
 *         https://stackoverflow.com/questions/267399/how-do-you-match-only-valid-roman-numerals-with-a-regular-expression
 *
 */
@Component
public class Validator {

    private static final String ROMAN_NUMERAL_REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";

    public boolean validate(final String romanNumeral) {
        final Pattern pattern = Pattern.compile(ROMAN_NUMERAL_REGEX);
        final Matcher matcher = pattern.matcher(romanNumeral);

        return matcher.matches();
    }
}
