package com.ericsson.romannumeralcalculator.romannumeral

import com.ericsson.romannumeralcalculator.exceptions.ValidationException

import spock.lang.Specification
class CalculatorServiceSpec extends Specification{

    def RomanNumeralCalculatorService calculator = new RomanNumeralCalculatorService();

    def "calulator returns correct result for addition of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.calculate("X", "II", "ADD")

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == "XII"
    }

    def numeralOne, numeralTwo, expectedResult

    def "calulator returns correct result for subtraction of two roman numerals"(){


        when: "two numerals are put into the calculator"
        def result = calculator.calculate(numeralOne, numeralTwo, "SUBTRACT")

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
        def result = calculator.calculate("X", "9", "ADD")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }
}
