package com.ericsson.romannumeralcalculator.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationInvoker {

    @Autowired
    private OperationFactory operationFactory;

    public Operation execute(final String operation) {
        return operationFactory.getOperation(operation);
    }

}
