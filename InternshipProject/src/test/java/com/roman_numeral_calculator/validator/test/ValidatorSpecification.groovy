package com.roman_numeral_calculator.validator.test

import static org.junit.Assert.*

import com.roman_numeral_calculator.validator.RomanNumeralValidator
import org.junit.Test
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ValidatorSpecification extends Specification {
	
	def numeralInput, validationResult
	
	@Unroll
	def "validator return false for  roman numeral: #numeralInput"(){
		given: "an inavlid roman numeral is put into the validator"
			def response = RomanNumeralValidator.validator(numeralInput)
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
	}

}
