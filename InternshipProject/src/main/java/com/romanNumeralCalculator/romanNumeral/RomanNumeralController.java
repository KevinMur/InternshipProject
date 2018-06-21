package com.romanNumeralCalculator.romanNumeral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.romanNumeralCalculator.utils.RomanNumeralConverter;
import com.romanNumeralCalculator.utils.RomanNumeralValidator;

@Controller
public class RomanNumeralController {
	
	@Autowired
	private RomanNumeralValidator validator;
	
	@Autowired
	private RomanNumeralConverter converter;
	
	/**
	 * @param numeralOne
	 * 		the first roman numeral received from the http GET request to be used in the calculation
	 * @param numeralTwo
	 * 	the second roman numeral received from the http GETT request to be used in the calculation
	 * @return
	 * 	if both roman numerals pass validation the a http status 200 is returned with a roman numeral object with the added value
	 *  else a http status 400 is returned
	 */
	@RequestMapping(method = RequestMethod.GET,  value = "/add")
	public ResponseEntity<RomanNumeral> addNumerals(@RequestParam("numeralOne") String numeralOne, @RequestParam("numeralTwo") String numeralTwo) {	
		int result = 0;
		RomanNumeral romanNumeralOne = new RomanNumeral(numeralOne);
		RomanNumeral romanNumeralTwo = new RomanNumeral(numeralTwo);
		RomanNumeral response = new RomanNumeral();
		if(validator.validate(romanNumeralOne.getNumeralValue()) && validator.validate(romanNumeralTwo.getNumeralValue())) {
			result = converter.convertNumeralToNumber(romanNumeralOne.getNumeralValue()) + 
					 converter.convertNumeralToNumber(romanNumeralTwo.getNumeralValue());

			response.setNumericValue(result);
			response.setNumeralValue(converter.convertNumberToNumeral(result));
			response.setRequestSuccess(true);
			return new ResponseEntity<RomanNumeral>(response, HttpStatus.OK);
		}

		return new ResponseEntity<RomanNumeral>(response, HttpStatus.BAD_REQUEST);
	}
}
