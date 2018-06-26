package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.stereotype.Service;

import com.ericsson.romannumeralcalculator.exceptions.ValidationException;
import com.ericsson.romannumeralcalculator.operations.Context;
import com.ericsson.romannumeralcalculator.operations.OperationFactory;
import com.ericsson.romannumeralcalculator.validator.RomanNumeralValidator;

/**
 * @author ekvumer
 *
 *         Service class used by the REST controller to carry out additions
 *
 */

@Service
public class RomanNumeralCalculatorService {

    /**
     * @param numeralOne
     *            First numeral entered by the user
     * @param numeralTwo
     *            First numeral entered by the user
     * @return Roman numeral object that stores the result of the addition
     */

    public RomanNumeral calculate(final String numeralOne, final String numeralTwo, final String operator) {
        final RomanNumeralValidator validator = new RomanNumeralValidator();

        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            final Context context = new Context(OperationFactory.getOperation(operator));
            return context.executeOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + " " + numeralTwo);
        }
    }
}
