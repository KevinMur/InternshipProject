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
    public ResponseEntity<RomanNumeral> addCalculation(@RequestParam("numeralExpression") String numeralExpression) {
        numeralExpression = numeralExpression.replace("%2B", "+");
        final RomanNumeral response = calculator.add(numeralExpression);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subtract", headers = "Accept=application/json")
    public ResponseEntity<RomanNumeral> subtractCalculation(@RequestParam("numeralExpression") final String numeralExpression) {
        final RomanNumeral response = calculator.subtract(numeralExpression);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/multiply", headers = "Accept=application/json")
    public ResponseEntity<RomanNumeral> multiplyCalculation(@RequestParam("numeralExpression") final String numeralExpression) {
        final RomanNumeral response = calculator.multiply(numeralExpression);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/divide", headers = "Accept=application/json")
    public ResponseEntity<RomanNumeral> divideCalculation(@RequestParam("numeralExpression") String numeralExpression) {
        numeralExpression = numeralExpression.replace("%2F", "/");
        final RomanNumeral response = calculator.divide(numeralExpression);
        return ResponseEntity.ok(response);
    }
}
