package com.calculator.utils;

import com.calculator.exceptions.ValidationException;
import com.calculator.romannumeral.RomanNumeral;


/**
 * @author ekvumer
 *      Operation add class that can add two roman numerals
 *
 */
public class OperationAdd implements Strategy{
    

    /**
     *  method inherited from Strategy interface
     *  
     * @param numeralOne        
     *          First roman numeral enetered by the user
     * @param numeralTwo
     *          Second roman numeral entered by the user
     * @return 
     *          Returns a roman numeral object that holds the result of the addition
     * 
     */
    @Override
    public RomanNumeral doOperation(final String numeralOne, final String numeralTwo) {
        int result = 0;
        final RomanNumeralValidator validator = new RomanNumeralValidator();
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        final RomanNumeral romanNumeral = new RomanNumeral();
        if(validator.validate(numeralOne) && validator.validate(numeralTwo)){
            result = converter.convertNumeralToNumber(numeralOne) + 
                    converter.convertNumeralToNumber(numeralTwo);
            romanNumeral.setRequestSuccess(true);
            romanNumeral.setNumeralValue(converter.convertNumberToNumeral(result));
        }else {
            throw new ValidationException();
        }
        return romanNumeral;
    }

}
