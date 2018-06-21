package com.romanNumeralCalculator.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConverter {
	
	public int convertNumeralToInt(String numeral) {
		int convertedTotal = 0, currentValue = 0, previousValue = 0;
		
		Map<Character, Integer> valueMap = new HashMap<>();
		valueMap.put('M', 1000);
		valueMap.put('D', 500);
		valueMap.put('C', 100);
		valueMap.put('L', 50);
		valueMap.put('X', 10);
		valueMap.put('V', 5);
		valueMap.put('I', 1);

		for(int i = numeral.length()-1; i >= 0; i--) {
			currentValue = valueMap.get(numeral.charAt(i));
			if(currentValue < previousValue) {
				convertedTotal -= currentValue;
			}else {
				convertedTotal += currentValue;
			}
			previousValue = currentValue;
		}		
		return convertedTotal;
	}
}
