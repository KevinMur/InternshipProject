package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.romannumeralcalculator.exceptions.ValidationException;
import com.ericsson.romannumeralcalculator.operations.OperationFactory;
import com.ericsson.romannumeralcalculator.validator.RomanNumeralValidator;

/**
 * @author ekvumer
 *
 *         Service class used by the REST controller to carry out mathematical operations
 *
 */

@Service
public class RomanNumeralCalculatorService {

    @Autowired
    RomanNumeralValidator validator;

    @Autowired
    private OperationFactory operationFactory;

    /**
     * @param numeralOne
     *            First numeral entered by the user
     * @param numeralTwo
     *            First numeral entered by the user
     * @param operator
     *            The operation to be carried out on the two numerals
     * @return Roman numeral object that stores the result of the addition
     */

    public RomanNumeral add(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("addOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + " " + numeralTwo);
        }
    }

    public RomanNumeral subtract(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("subtractOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + " " + numeralTwo);
        }
    }
}
