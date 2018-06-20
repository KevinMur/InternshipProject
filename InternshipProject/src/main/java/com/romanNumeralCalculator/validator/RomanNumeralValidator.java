package com.romanNumeralCalculator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralValidator {
	
	private static final String ROMAN_NUMERAL_REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	
	public boolean validator(String romanNumeral) {
		Pattern pattern = Pattern.compile(ROMAN_NUMERAL_REGEX);
		Matcher matcher = pattern.matcher(romanNumeral);	
		return matcher.matches();			
	}
}
