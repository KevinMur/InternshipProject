package com.ericsson.romannumeralcalculator.validator;

import org.springframework.stereotype.Component;

@Component
public class ExpressionSplitter {

    public String[] splitExpression(String expression) {
        expression = expression.replace(" ", "");
        return expression.split("(?=[-/+*])|(?<=[-/+*])");
    }

}
