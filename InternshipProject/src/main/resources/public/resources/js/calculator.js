
var numeralOne, numeralTwo;

$('document').ready(function(){
	$(document).on('click', '#addButton', function(){
		if(validateInputs()){
			addNumerals();
		}
		return false;
	});

	$(document).on('click', '#subtractButton', function(){
		if(validateInputs()){
			subtractNumerals();
		}
		return false;
	});
	
	$(document).on('click', '#multiplyButton', function(){
		if(validateInputs()){
			multiplyNumerals();
		}
		return false;
	});
	
	$(document).on('click', '#divideButton', function(){
		if(validateInputs()){
			divideNumerals();
		}
		return false;
	});
});

function validateInputs(){
	numeralOne = $("#numeralInputOne").val();
	numeralTwo = $("#numeralInputTwo").val();
	if(numeralOne == "" || numeralTwo == ""){
		$("#validationText").text("Both Fields Are Required !");
		$("#calculationResult").empty();
		return false;
	}
	return true;
}

function addNumerals(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/add",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralOne: numeralOne,
			numeralTwo : numeralTwo
		},
		success: function(numeral){
			console.log(numeral);
			$("#calculationResult").text("Result: " + numeralOne + " + " + numeralTwo + " = " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function subtractNumerals(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/subtract",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralOne: numeralOne,
			numeralTwo : numeralTwo
		},
		success: function(numeral){
			console.log(numeral);
			$("#calculationResult").text("Result: " + numeralOne + " - " + numeralTwo + " = " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function multiplyNumerals(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/multiply",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralOne: numeralOne,
			numeralTwo : numeralTwo
		},
		success: function(numeral){
			console.log(numeral);
			$("#calculationResult").text("Result: " + numeralOne + " * " + numeralTwo + " = " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function divideNumerals(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/divide",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralOne: numeralOne,
			numeralTwo : numeralTwo
		},
		success: function(numeral){
			console.log(numeral);
			$("#calculationResult").text("Result: " + numeralOne + " / " + numeralTwo + " = " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}