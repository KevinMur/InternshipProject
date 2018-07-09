package com.ericsson.romannumeralcalculator.converter

import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralConverterSpec extends Specification{

    def numeral, expectedNumber, number, expectedNumeral

    def Converter converter = new Converter();

    @Unroll
    def "converter should be able correctly convert a numeral that contains a substitution rule to its correct number"(){
        when: "the converter is passed a numeral that contains a substitution rule"
        def converterOutput = converter.convertNumeralToNumber(numeral);

        then: "converter should output the expected result"
        converterOutput  == expectedNumber

        where:
        numeral         |       expectedNumber
        "IV"            |               4
        "IX"            |               9
        "XL"            |               40
        "XC"            |               90
        "CD"            |               400
        "CM"            |               900
    }

    @Unroll
    def "converter should correctly convert numeral: #numeral into #expectedNumber"(){
        when: "the converter is passed a numeral"
        def converterOutput = converter.convertNumeralToNumber(numeral)

        then: "converter should output the expected result"
        converterOutput  == expectedNumber

        where:
        numeral		|	expectedNumber
        "I"	        |		1
        "V"	        |		5
        "VIII"	        |		8
        "X"	        |		10
        "XIV"	        |		14
        "XX"	        |		20
        "XLIX"	        |		49
        "L"	        |		50
        "C"	        |		100
        "CL"	        |		150
        "D"	        |		500
        "M"	        |		1000
        "MCMLXII"       |	        1962
    }

    @Unroll
    def "converter should correct convert #number into #expectedNumeral"(){
        when: "the converter is passed a number"
        def converterOutput = converter.convertNumberToNumeral(number)

        then: "converter should output the expected result"
        converterOutput == expectedNumeral

        where:
        number	|     expectedNumeral
        1	|         "I"
        4	|	  "IV"
        5	|         "V"
        8	|	  "VIII"
        9	|	  "IX"
        10	|         "X"
        12	|         "XII"
        14	|	  "XIV"
        20	|	  "XX"
        40	|	  "XL"
        50	|	  "L"
        90	|	  "XC"
        100	|	  "C"
        150	|	  "CL"
        130	|	  "CXXX"
        400	|	  "CD"
        500     |         "D"
        670	|	  "DCLXX"
        1000    |	  "M"
        1962    |	  "MCMLXII"
    }
}
