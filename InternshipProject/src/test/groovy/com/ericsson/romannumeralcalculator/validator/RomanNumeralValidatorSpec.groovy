package com.ericsson.romannumeralcalculator.validator

import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralValidatorSpec extends Specification{

    def numeralInput, validationResult

    def Validator romanNumeralValidator = new Validator();

    @Unroll
    def "validator should return false if numerals 'I', 'X' or 'C' occur more than three times in a row"(){
        when: 'invalid numeral passed to validator'
        def response = romanNumeralValidator.validate(numeralInput)

        then: "response should be false"
        response == false

        where:
        numeralInput << ["IIII", "XXXX", "CCCC"]
    }

    @Unroll
    def "validator should return false if numerals 'V', 'L' or 'D' occur more than once in a row"(){
        when: 'invalid numeral passed to validator'
        def response = romanNumeralValidator.validate(numeralInput)

        then: "response should be false"
        response == false

        where:
        numeralInput << ["VV", "LL", "DD"]
    }


    @Unroll
    def "validator should return false if format of numeral is invalid: #numeralInput"(){
        when: 'invalid numeral passed to validator'
        def response = romanNumeralValidator.validate(numeralInput)

        then: "response should be false"
        response == false

        where:
        numeralInput << [
            "I1",
            "XA",
            "IIV",
            "IIIV",
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
