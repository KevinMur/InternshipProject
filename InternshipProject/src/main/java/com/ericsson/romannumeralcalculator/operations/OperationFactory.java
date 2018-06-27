package com.ericsson.romannumeralcalculator.operations;

public interface OperationFactory {

    Operation getOperation(String operationName);
}
