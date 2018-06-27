package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {

    @Autowired
    AddOperation addOperation;

    @Autowired
    SubtractOperation subtractOperation;

    private OperationFactory() {
    }

    public Operation getOperation(final String operationType) {
        if (operationType.equals("ADD")) {
            return addOperation;
        } else if (operationType.equals("SUBTRACT")) {
            return subtractOperation;
        }
        throw new IllegalArgumentException();
    }
}
