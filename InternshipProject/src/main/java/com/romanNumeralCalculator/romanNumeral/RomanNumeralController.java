package com.romanNumeralCalculator.romanNumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romanNumeralCalculator.validator.RomanNumeralValidator;

@RestController
public class RomanNumeralController {
	
	@Autowired
	private RomanNumeralValidator validator;
	
	@RequestMapping("/add/{numeralOne}/{numeralTwo}")
	public RomanNumeral addNumerals(@PathVariable("numeralOne") String numeralOne, @PathVariable("numeralTwo") String numeralTwo) {	
		RomanNumeral romanNumeralOne = new RomanNumeral(numeralOne);
		RomanNumeral romanNumeralTwo = new RomanNumeral(numeralTwo);
		if(validator.validator(romanNumeralOne.getRomanNumeral()) && validator.validator(romanNumeralTwo.getRomanNumeral())) {
			RomanNumeral test = new RomanNumeral("Valid");
			return test;
		}
		return null;
	}
}
