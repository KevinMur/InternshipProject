package com.romanNumeralCalculator.romanNumeral;

public class RomanNumeral {

	private String romanNumeral;
	private int numericValue;
	
	public RomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}
	
	public int getNumericValue() {
		return numericValue;
	}
	
	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}
	
	public String getRomanNumeral() {
		return romanNumeral;
	}
	
	public void setRomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}
}
