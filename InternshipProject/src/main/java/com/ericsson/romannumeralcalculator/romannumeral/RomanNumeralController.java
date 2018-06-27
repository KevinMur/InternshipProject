package com.ericsson.romannumeralcalculator.romannumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ekvumer
 *
 *         REST controller class to handle incoming REST requests and send back appropriate responses
 *
 */
@RestController
@RequestMapping("/calculator")
public class RomanNumeralController {

    @Autowired
    RomanNumeralCalculatorService calculator;

    /**
     * @param numeralOne
     *            the first roman numeral received from the http GET request to be used in the calculation
     * @param numeralTwo
     *            the second roman numeral received from the http GETT request to be used in the calculation
     * @return A response entity containing a roman numeral object where the result of the calculation is stored
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ResponseEntity<RomanNumeral> addCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                       @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.calculate(numeralOne, numeralTwo, "ADD");
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subtract")
    public ResponseEntity<RomanNumeral> subtractCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                            @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.calculate(numeralOne, numeralTwo, "SUBTRACT");
        return ResponseEntity.ok(response);
    }
}
