package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

@Component
public class OperationInvoker {

    @Autowired
    private OperationFactory operationFactory;

    public RomanNumeral execute(final String operationType, final String numeralOne, final String numeralTwo) {
        return operationFactory.getOperation(operationType).doOperation(numeralOne, numeralTwo);
    }

}
