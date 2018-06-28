
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
	console.log(numeralOne)
	console.log(numeralTwo)
	if(numeralOne == "" || numeralTwo == ""){
		$("#validationText").text("Both Fields Required!!");
		$("#calculationResult").empty();
		return false;
	}
	return true;
}

function addNumerals(){   
	numeralOne = $("#numeralInputOne").val();
	numeralTwo = $("#numeralInputTwo").val();
	console.log(numeralOne);
	console.log(numeralTwo);
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
			$("#calculationResult").text("Result: " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function subtractNumerals(){   
	numeralOne = $("#numeralInputOne").val();
	numeralTwo = $("#numeralInputTwo").val();
	console.log(numeralOne);
	console.log(numeralTwo);
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
			$("#calculationResult").text("Result: " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function multiplyNumerals(){   
	numeralOne = $("#numeralInputOne").val();
	numeralTwo = $("#numeralInputTwo").val();
	console.log(numeralOne);
	console.log(numeralTwo);
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
			$("#calculationResult").text("Result: " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}

function divideNumerals(){   
	numeralOne = $("#numeralInputOne").val();
	numeralTwo = $("#numeralInputTwo").val();
	console.log(numeralOne);
	console.log(numeralTwo);
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
			$("#calculationResult").text("Result: " + numeral.numeralValue);
			$("#validationText").empty();
		},
		error: function(){
			$("#calculationResult").empty();
			$("#validationText").text("Incorrect Numeral Entered!");
		}
	});
}