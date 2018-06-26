package com.ericsson.romannumeralcalculator.operations;

public class OperationFactory {

    private OperationFactory() {
    }

    public static Operation getOperation(final String operationType) {
        if (operationType.equals("ADD")) {
            return new AddOperation();
        } else if (operationType.equals("SUBTRACT")) {
            return new SubtractOperation();
        }
        throw new IllegalArgumentException();
    }
}
