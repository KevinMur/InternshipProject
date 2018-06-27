package com.ericsson.romannumeralcalculator.romannumeral

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.ericsson.romannumeralcalculator.exceptions.ValidationException
import com.ericsson.romannumeralcalculator.validator.RomanNumeralValidator

import spock.lang.Specification

@SpringBootTest
class CalculatorServiceSpec extends Specification{

    @Autowired
    RomanNumeralCalculatorService calculator

    @Autowired
    RomanNumeralValidator validator

    def "calulator returns correct result for addition of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.add("X", "II")

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == "XII"
    }

    def numeralOne, numeralTwo, expectedResult

    def "calulator returns correct result for subtraction of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.subtract(numeralOne, numeralTwo)

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == expectedResult

        where:
        numeralOne   |      numeralTwo      |       expectedResult
        "X"      |        "II"          |           "VIII"
        "V"      |        "X"           |            "-V"
        "X"      |        "X"           |            "Nulla"
    }

    def "calculator throws a validation exception when an invalid numeral is entered"(){
        when: "a valid and an invalid numeral are entered to be calculated"
        def result = calculator.add("X", "9")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }
}
