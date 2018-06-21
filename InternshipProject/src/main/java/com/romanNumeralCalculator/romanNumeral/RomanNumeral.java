package com.romanNumeralCalculator.romanNumeral;

public class RomanNumeral {

	private String numeralValue;
	private int numericValue;
	private boolean requestSuccess;
	
	public RomanNumeral() {
		numeralValue = "";
		numericValue = 0;
		requestSuccess = false;
	}
	public RomanNumeral(String romanNumeral) {
		this.numeralValue = romanNumeral;
	}
	
	public int getNumericValue() {
		return numericValue;
	}
	
	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}
	
	public String getNumeralValue() {
		return numeralValue;
	}
	
	public void setNumeralValue(String numeralValue) {
		this.numeralValue = numeralValue;
	}
	
	public boolean getRequestsuccess() {
		return requestSuccess;
	}
	
	public void setRequestSuccess(boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
	}
}
