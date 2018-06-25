package com.calculator.romannumeral;

import org.springframework.stereotype.Service;

import com.calculator.utils.Context;
import com.calculator.utils.OperationAdd;

/**
 * @author ekvumer
 * 
 * Service class used by the REST controller to carry out additions
 *
 */

@Service
public class CalculatorService {
    
    /**
     * @param numeralOne
     *          First numeral entered by the user
     * @param numeralTwo
     *           First numeral entered by the user
     * @return
     *          Roman numeral object that sores the result of the addition
     */
    public RomanNumeral add(final String numeralOne, final String numeralTwo) {
        final Context context = new Context(new OperationAdd());
        return context.executeStrategy(numeralOne, numeralTwo);
    }

}
