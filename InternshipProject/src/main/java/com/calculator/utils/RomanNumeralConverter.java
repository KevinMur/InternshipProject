package com.calculator.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ekvumer
 * 
 *      Class used to convert from numerals to numbers and vice-versa
 *
 */
public class RomanNumeralConverter {
	
	/**
	 * @param numeral
	 *     numeral that is going to be converted to a number
	 * @return
	 *     the number that the numeral entered represented
	 */
	public int convertNumeralToNumber(final String numeral) {
		int convertedTotal = 0;
		int currentValue = 0;
		int previousValue = 0;

		final Map<Character, Integer> valueMap = mapForConvertingNumerals();

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

	/**
	 * @param numeralValue
	 *     number that is going to be converted into a numeral
	 * @return
	 * 
	 *     the numeral string that is a representation of the number inputted
	 */
	public String convertNumberToNumeral(int numeralValue) {
		final StringBuilder numeralOutput = new StringBuilder();
		final Map<Integer, String> valueMap = mapForConvertingNumbers();
		while(numeralValue > 0) {
			for (final Map.Entry<Integer, String> entry : valueMap.entrySet()){
				if (numeralValue >= entry.getKey()){
				        numeralOutput.append(entry.getValue());
					numeralValue -= entry.getKey();
					break;
				}
			}
		}
		return numeralOutput.toString();
	}

	private Map<Character, Integer> mapForConvertingNumerals(){
		final Map<Character, Integer> valueMap = new HashMap<>();
		valueMap.put('M', 1000);
		valueMap.put('D', 500);
		valueMap.put('C', 100);
		valueMap.put('L', 50);
		valueMap.put('X', 10);
		valueMap.put('V', 5);
		valueMap.put('I', 1);	
		return valueMap;
	}

	private Map<Integer, String> mapForConvertingNumbers(){
		final Map<Integer, String> valueMap = new LinkedHashMap<>();
		valueMap.put(1000, "M");
		valueMap.put(900, "CM");
		valueMap.put(500, "D");
		valueMap.put(400, "CD");
		valueMap.put(100, "C");
		valueMap.put(90, "XC");
		valueMap.put(50, "L");
		valueMap.put(40, "XL");
		valueMap.put(10, "X");
		valueMap.put(9, "IX");
		valueMap.put(5, "V");
		valueMap.put(4, "IV");
		valueMap.put(1, "I");
		return valueMap;
	}
}
