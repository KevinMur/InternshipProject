package com.ericsson.romannumeralcalculator.converter

import org.junit.Test

import com.ericsson.romannumeralcalculator.converter.RomanNumeralConverter

import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralConverterSpec extends Specification{

	def numeral, expectedNumber, number, expectedNumeral
	
	def RomanNumeralConverter converter = new RomanNumeralConverter();
	
	@Unroll
	def "converter should correctly convert numeral: #numeral into #expectedNumber"(){
		when: "the converter is passed a numeral"
			def converterOutput = converter.convertNumeralToNumber(numeral)
	
		then: "converter should output the expected result"
			converterOutput  == expectedNumber
		where:
			numeral		|	expectedNumber
				"I"	|		1
				"IV"	|		4
				"V"	|		5
				"VIII"	|		8
				"IX"	|		9
				"X"	|		10
				"XII"	|		12
				"XIV"	|		14
				"XX"	|		20
				"XL"	|		40
				"XLIX"	|		49
				"L"	|		50
				"XC"	|		90
				"C"	|		100
				"CL"	|		150
				"CXXX"	|		130
				"D"	|		500
				"CD"	|		400
				"DCLXX"	|		670
				"CM"	|		900
				"M"	|		1000
				"MCMLXII"|	1962
				"MMMCM"	|		3900
	
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
                            49	|	  "XLIX"
                            50	|	  "L"
                            90	|	  "XC"
                            100	|	  "C"
                            150	|	  "CL"
                            130	|	  "CXXX"
                            500	|	  "D"
                            400	|	  "CD"
                            670	|	  "DCLXX"
                            900	|	  "CM"
                            1000|	  "M"
                            1962|	  "MCMLXII"
                            3900|	  "MMMCM"			
	}
}
