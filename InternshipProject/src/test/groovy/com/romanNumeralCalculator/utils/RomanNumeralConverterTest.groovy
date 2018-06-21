package com.romanNumeralCalculator.utils

import static org.junit.Assert.*

import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralConverterTest extends Specification{

	def numeral, expectedOutput
	
	def RomanNumeralConverter converter = new RomanNumeralConverter();
	
	@Unroll
	def "converter should correctly convert numeral: #numeral into #expectedOutput"(){
		given: "the converter is passed a numeral"
			def intOutput = converter.convertNumeralToInt(numeral)
		expect: "converter output should math the expected result"
			intOutput == expectedOutput
		where:
			numeral		|	expectedOutput
				"I"		|		1
				"IV"	|		4
				"V"		|		5
				"VIII"	|		8
				"IX"	|		9
				"X"		|		10
				"XII"	|		12
				"XIV"	|		14
				"XX"	|		20
				"XL"	|		40
				"XLIX"	|		49
				"L"		|		50
				"XC"	|		90
				"C"		|		100
				"CL"	|		150
				"CXXX"	|		130
				"D"		|		500
				"CD"	|		400
				"DCLXX"	|		670
				"CM"	|		900
				"M"		|		1000
				"MCMLXII"	|	1962
				"MMMCM"	|		3900
	
	}
		

}
