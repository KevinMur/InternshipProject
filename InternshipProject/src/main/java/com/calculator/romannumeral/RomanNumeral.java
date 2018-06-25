package com.calculator.romannumeral;

/**
 * @author ekvumer
 * 
 *      Roman Numeral class 
 *      
 *
 */
public class RomanNumeral {

	private String numeralValue;
	private boolean requestSuccess;
	
	public RomanNumeral() {
		numeralValue = "";
		requestSuccess = false;
	}
	public RomanNumeral(final String romanNumeral) {
		this.numeralValue = romanNumeral;
	}
	
	public String getNumeralValue() {
		return numeralValue;
	}
	
	public void setNumeralValue(final String numeralValue) {
		this.numeralValue = numeralValue;
	}
	
	public boolean getRequestsuccess() {
		return requestSuccess;
	}
	
	public void setRequestSuccess(final boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
	}
}
