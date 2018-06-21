package com.romanNumeralCalculator.utils

import static org.junit.Assert.*

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import com.romanNumeralCalculator.utils.RomanNumeralValidator

import spock.lang.Specification
import spock.lang.Unroll

class ValidatorTest extends Specification{

	def numeralInput, validationResult

	def RomanNumeralValidator romanNumeralValidator = new RomanNumeralValidator();
	@Unroll
	def "validator should return #validationResult for  roman numeral: #numeralInput"(){
		given: "an inavlid roman numeral is put into the validator"
			def response = romanNumeralValidator.validate(numeralInput)
		expect: "response should be correct"
			response == validationResult
		where:
			numeralInput | validationResult
				"1"		 |		false
				"A"		 |		false
				"IA2"	 |		false
				"IIV"	 |		false
				"IIX"	 |		false
				"VV"	 |		false
				"VX"	 |		false
				"IIII"	 |		false
				"LL"	 |		false
				"CCD"	 |		false
				"XXL"	 | 		false
				"DD"	 |		false
				"DM"	 |		false
				"CCCC"	 |		false
				"XXC"	 |		false
				"MMMMM"  |		false
				"I"		 |		true
				"III"	 |		true
				"IV"	 |		true
				"V"		 |		true
				"VIII"	 |		true
				"IX"	 |		true
				"XV"	 |		true
				"XVIII"	 |		true
				"XC"	 |		true
				"XCIX"	 |		true
				"CD"	 |		true
				"DCCC"	 |		true
				"MMMM"	 |		true
				"CM"	 |		true				
	}
}
