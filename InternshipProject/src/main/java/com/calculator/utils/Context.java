package com.calculator.utils;

import com.calculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *      
 *      Context class that stores and executes a strategy
 *
 */
public class Context {

    private final Strategy strategy;
    
    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * @param numeralOne
     *          First roman numeral entered by the user
     * @param numeralTwo
     *          Second roman numeral entered by the user
     * @return
     *          Returns a roman numeral object that hold the result of the calculation
     */
    public RomanNumeral executeStrategy(final String numeralOne, final String numeralTwo) {
        return strategy.doOperation(numeralOne, numeralTwo);
    }
}
