package com.romanNumeralCalculator.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConverter {

	public int convertNumeralToNumber(String numeral) {
		int convertedTotal = 0, currentValue = 0, previousValue = 0;

		Map<Character, Integer> valueMap = mapForConvertingNumerals();

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

	public String convertNumberToNumeral(int numeralValue) {
		String numeralOutput = "";
		Map<Integer, String> valueMap = mapForConvertingNumbers();
		while(numeralValue > 0) {
			for (Map.Entry<Integer, String> entry : valueMap.entrySet()){
				if (numeralValue >= entry.getKey()){
					numeralOutput += entry.getValue();
					numeralValue -= entry.getKey();
					break;
				}
			}
		}
		return numeralOutput;
	}

	private Map<Character, Integer> mapForConvertingNumerals(){
		Map<Character, Integer> valueMap = new HashMap<>();
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
		Map<Integer, String> valueMap = new LinkedHashMap<>();
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
