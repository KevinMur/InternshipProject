package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.romannumeralcalculator.exceptions.ValidationException;
import com.ericsson.romannumeralcalculator.operations.OperationInvoker;
import com.ericsson.romannumeralcalculator.validator.ExpressionSplitter;
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
    private ExpressionSplitter splitter;

    @Autowired
    private OperationInvoker operationInvoker;

    public RomanNumeral add(final String numeralExpression) {
        final String[] numerals = retrieveNumeralsFromExpression(numeralExpression);
        if (validator.validate(numerals[0]) && validator.validate(numerals[1])) {
            return operationInvoker.execute("addOperation", numerals[0], numerals[1]);
        } else {
            throw new ValidationException(numerals[0] + ", " + numerals[1]);
        }
    }

    public RomanNumeral subtract(final String numeralExpression) {
        final String[] numerals = retrieveNumeralsFromExpression(numeralExpression);
        if (validator.validate(numerals[0]) && validator.validate(numerals[1])) {
            return operationInvoker.execute("subtractOperation", numerals[0], numerals[1]);
        } else {
            throw new ValidationException(numerals[0] + ", " + numerals[1]);
        }
    }

    public RomanNumeral multiply(final String numeralExpression) {
        final String[] numerals = retrieveNumeralsFromExpression(numeralExpression);
        if (validator.validate(numerals[0]) && validator.validate(numerals[1])) {
            return operationInvoker.execute("multiplyOperation", numerals[0], numerals[1]);
        } else {
            throw new ValidationException(numerals[0] + ", " + numerals[1]);
        }
    }

    public RomanNumeral divide(final String numeralExpression) {
        final String[] numerals = retrieveNumeralsFromExpression(numeralExpression);
        if (validator.validate(numerals[0]) && validator.validate(numerals[1])) {
            return operationInvoker.execute("divideOperation", numerals[0], numerals[1]);
        } else {
            throw new ValidationException(numerals[0] + ", " + numerals[1]);
        }
    }

    private String[] retrieveNumeralsFromExpression(final String expression) {
        final String[] splitExpression = splitter.splitExpression(expression);
        final String numeralOne = splitExpression[0];
        final String numeralTwo = splitExpression[2];
        return new String[] { numeralOne, numeralTwo };
    }
}
