package com.calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralValidator {
	
	private static final String ROMAN_NUMERAL_REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	
	/**
	 * @param romanNumeral
	 * 	the roman numeral to be validated
	 * @return
	 * 	return true or false depending on the result of the roman numeral being checked against the regex
	 */
	public boolean validate(final String romanNumeral) {
		final Pattern pattern = Pattern.compile(ROMAN_NUMERAL_REGEX);
		final Matcher matcher = pattern.matcher(romanNumeral);	
		return matcher.matches();			
	}
}