package com.calculator.utils

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import com.calculator.utils.RomanNumeralValidator

import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralValidatorSpec extends Specification{

	def numeralInput, validationResult

	def RomanNumeralValidator romanNumeralValidator = new RomanNumeralValidator();
	
	@Unroll
	def "validator should return false for  roman numeral: #numeralInput"(){
		given: "an inavlid roman numeral is put into the validator"
			def response = romanNumeralValidator.validate(numeralInput)
		expect: "response should be false"
			response == false
		where:
			numeralInput << ["1", "A", "IA2", "IIV", "IIX",	
							"VV", "VX", "IIII", "LL", "CCD",	 		
							"XXL", "DD", "DM", "CCCC", "XXC",	 
							"MMMMM"]
						
	}
	
	@Unroll
	def "validator should return true for  roman numeral: #numeralInput"(){
		given: "a valid roman numeral is put into the validator"
			def response = romanNumeralValidator.validate(numeralInput)
		expect: "response should be true"
			response == true
		where:
			numeralInput <<["I", "III",	"IV", "V", "VIII",	 
							"IX", "XV",	"XVIII", "XC",	 
							"XCIX", "CD", "DCCC", "MMMM",	 
							"CM"] 
	}
}
