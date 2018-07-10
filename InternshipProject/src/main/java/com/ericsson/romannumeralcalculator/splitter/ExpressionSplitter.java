package com.ericsson.romannumeralcalculator.splitter;

import org.springframework.stereotype.Component;

/**
 * @author ekvumer Expression Splitter - used to split a roman numeral expression to retrieve the two roman numeral operators
 *
 */
@Component
public class ExpressionSplitter {

    public String[] splitExpression(String expression) {
        expression = expression.replace(" ", "");
        return expression.split("(?=[-/+*])|(?<=[-/+*])");
    }

}
