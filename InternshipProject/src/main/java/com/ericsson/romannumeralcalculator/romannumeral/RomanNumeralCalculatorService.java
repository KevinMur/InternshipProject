package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.romannumeralcalculator.exceptions.ValidationException;
import com.ericsson.romannumeralcalculator.operations.OperationFactory;
import com.ericsson.romannumeralcalculator.validator.Validator;

/**
 * @author ekvumer
 *
 *         Service class used by the REST controller to carry out mathematical operations
 *
 */

@Service
public class RomanNumeralCalculatorService {

    @Autowired
    private Validator validator;

    @Autowired
    private OperationFactory operationFactory;

    public RomanNumeral add(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("addOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + ", " + numeralTwo);
        }
    }

    public RomanNumeral subtract(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("subtractOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + ", " + numeralTwo);
        }
    }

    public RomanNumeral multiply(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("multiplyOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + ", " + numeralTwo);
        }
    }

    public RomanNumeral divide(final String numeralOne, final String numeralTwo) {
        if (validator.validate(numeralOne) && validator.validate(numeralTwo)) {
            return operationFactory.getOperation("divideOperation").doOperation(numeralOne, numeralTwo);
        } else {
            throw new ValidationException(numeralOne + ", " + numeralTwo);
        }
    }
}
