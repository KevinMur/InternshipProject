Feature: To be able to calculate roman numeral expressions

	Scenario: user makes a call to evaluate an add expression
	When the user enters a "add" operation with the expression "XIV+LX"
	Then the user recieves a HTTP OK response
	And a valid Roman Numeral response is returned with the correct numeral value "LXXIV"
	
	Scenario: user makes a call to evaluate a subtract expression
	When the user enters a "subtract" operation with the expression "X-V"
	Then the user recieves a HTTP OK response
	And a valid Roman Numeral response is returned with the correct numeral value "V"
	
	Scenario: user makes a call to evaluate a multiply expression
	When the user enters a "multiply" operation with the expression "II*IV"
	Then the user recieves a HTTP OK response
	And a valid Roman Numeral response is returned with the correct numeral value "VIII"
	
	Scenario: user makes a call to evaluate a divide expression
	When the user enters a "divide" operation with the expression "VIII/II"
	Then the user recieves a HTTP OK response
	And a valid Roman Numeral response is returned with the correct numeral value "IV"
	