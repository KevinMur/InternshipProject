
var numeralExpression;

$('document').ready(function(){
	$(document).on('click', '#calculateButton', function(){
		if(validateInput()){	
			return true;
		}
		return false;
	});
});

function validateInput(){
	var expressionRegex = new RegExp("(^[A-Z]+)(\\s*)([+\-\/*])(\\s*)([A-Z]+$)");
	numeralExpression = $('#numeralInput').val();

	numeralExpression = numeralExpression.trim();

	if(numeralExpression == ""){
		$("#calculationResultText").text("Field Required!").css('color', 'red');		
		return false;
	}else if(!expressionRegex.test(numeralExpression)){
		$("#calculationResultText").text("Incorrect Format!").css('color', 'red');
		return false;
	}

	if(numeralExpression.includes("+")){
		addOperation();
	}else if(numeralExpression.includes("-")){
		subtractOperation();
	}else if(numeralExpression.includes("*")){
		multiplyOperation();
	}else if(numeralExpression.includes("/")){
		divideOperation();
	}

	$("#calculationResultText").empty();
	return true;
}

function addOperation(){ 
	$.ajax({
		type: 'GET',
		url: "/calculator/add",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralExpression : numeralExpression
		},
		success: function(numeral){		
			$("#calculationResultText").text(numeralExpression + " = " + numeral.numeralValue).css('color', 'black');			
		},
		error: function(){
			$("#calculationResultText").text("Incorrect Numeral Entered!").css('color', 'red');
		}
	});
}

function subtractOperation(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/subtract",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralExpression: numeralExpression
		},
		success: function(numeral){
			$("#calculationResultText").text(numeralExpression + " = " + numeral.numeralValue).css('color', 'black');	
		},
		error: function(){
			$("#calculationResultText").text("Incorrect Numeral Entered!").css('color', 'red');
		}
	});
}

function multiplyOperation(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/multiply",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralExpression: numeralExpression
		},
		success: function(numeral){
			$("#calculationResultText").text(numeralExpression + " = " + numeral.numeralValue).css('color', 'black');	
		},
		error: function(){
			$("#calculationResultText").text("Incorrect Numeral Entered!").css('color', 'red');
		}
	});
}

function divideOperation(){   
	$.ajax({
		type: 'GET',
		url: "/calculator/divide",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralExpression: numeralExpression
		},
		success: function(numeral){
			$("#calculationResultText").text(numeralExpression + " = " + numeral.numeralValue).css('color', 'black');	
		},
		error: function(){
			$("#calculationResultText").text("Incorrect Numeral Entered!").css('color', 'red');
		}
	});
}