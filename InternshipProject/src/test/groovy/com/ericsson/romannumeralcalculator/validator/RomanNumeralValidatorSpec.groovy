package com.ericsson.romannumeralcalculator.validator

import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralValidatorSpec extends Specification{

    def numeralInput, validationResult

    def Validator romanNumeralValidator = new Validator();

    @Unroll
    def "validator should return false for invalid numeral roman numeral: #numeralInput"(){
        when: 'invalid numeral passed to validator'
        def response = romanNumeralValidator.validate(numeralInput)

        then: "response should be false"
        response == false

        where:
        numeralInput << [
            "1",
            "A",
            "IA2",
            "IIV",
            "IIX",
            "VV",
            "VX",
            "IIII",
            "LL",
            "CCD",
            "XXL",
            "DD",
            "DM",
            "CCCC",
            "XXC",
            "MMMMM"
        ]
    }

    @Unroll
    def "validator should return true for valid numeral roman numeral: #numeralInput"(){
        when: "a valid roman numeral is put into the validator"
        def response = romanNumeralValidator.validate(numeralInput)

        then: "response should be true"
        response == true

        where:
        numeralInput <<[
            "I",
            "III",
            "IV",
            "V",
            "VIII",
            "IX",
            "XV",
            "XVIII",
            "XC",
            "XCIX",
            "CD",
            "DCCC",
            "MMMM",
            "CM"
        ]
    }
}
