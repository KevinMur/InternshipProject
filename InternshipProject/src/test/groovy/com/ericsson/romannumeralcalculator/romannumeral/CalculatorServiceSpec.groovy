package com.ericsson.romannumeralcalculator.romannumeral

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.ericsson.romannumeralcalculator.exceptions.ValidationException
import com.ericsson.romannumeralcalculator.validator.Validator

import spock.lang.Specification

@SpringBootTest
class CalculatorServiceSpec extends Specification{

    @Autowired
    RomanNumeralCalculatorService calculator

    @Autowired
    Validator validator


    def "calulator returns correct result for addition of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.add("X", "II")

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == "XII"
    }

    def "calculator throws a validation exception when an invalid numeral is entered in addition"(){
        when: "a valid and an invalid numeral are entered to be calculated"
        def result = calculator.add("X", "9")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }


    def numeralOne, numeralTwo, expectedResult

    def "calulator returns correct result for subtraction of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.subtract(numeralOne, numeralTwo)

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == expectedResult

        where:
        numeralOne   |      numeralTwo      |       expectedResult
        "X"          |        "II"          |           "VIII"
        "V"          |        "X"           |            "-V"
        "X"          |        "X"           |            "Nulla"
    }

    def "calculator throws a validation exception when an invalid numeral is entered in subtraction"(){
        when: "a valid and an invalid numeral are entered to be calculated"
        def result = calculator.subtract("X", "9")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }


    def "calulator returns correct result for multiplication of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.multiply("X", "II")

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == "XX"
    }

    def "calculator throws a validation exception when an invalid numeral is entered in multiplication"(){
        when: "a valid and an invalid numeral are entered to be calculated"
        def result = calculator.multiply("X", "9")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }

    def "calulator returns correct result for division of two roman numerals"(){
        when: "two numerals are put into the calculator"
        def result = calculator.divide(numeralOne, numeralTwo)

        then: "a roman numeral object is returned with the correct numeral value"
        result.getNumeralValue() == expectedResult

        where:
        numeralOne  |       numeralTwo      |       expectedResult
        "X"         |           "II"        |            "V"
        "II"        |           "X"         |            "Nulla"
    }

    def "calculator throws a validation exception when an invalid numeral is entered in division"(){
        when: "a valid and an invalid numeral are entered to be calculated"
        def result = calculator.divide("X", "9")

        then: "a validation exception will be thrown"
        thrown(ValidationException)
    }
}
