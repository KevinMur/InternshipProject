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
    private RomanNumeralCalculatorService calculator;

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ResponseEntity<RomanNumeral> addCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                       @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.add(numeralOne, numeralTwo);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subtract")
    public ResponseEntity<RomanNumeral> subtractCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                            @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.subtract(numeralOne, numeralTwo);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/multiply")
    public ResponseEntity<RomanNumeral> multiplyCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                            @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.multiply(numeralOne, numeralTwo);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/divide")
    public ResponseEntity<RomanNumeral> divideCalculation(@RequestParam("numeralOne") final String numeralOne,
                                                          @RequestParam("numeralTwo") final String numeralTwo) {
        final RomanNumeral response = calculator.divide(numeralOne, numeralTwo);
        return ResponseEntity.ok(response);
    }
}
