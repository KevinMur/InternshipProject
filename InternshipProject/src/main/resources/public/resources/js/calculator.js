
$('document').ready(function(){
    $(document).on('click', '#addButton', function(){
		addNumerals();
        return false;
	});
/*
    $(document).on("keyup", "#numeralInput1", function(){
        addNumerals();
	});
    
    $(document).on("keyup", "#numeralInput2", function(){
        addNumerals();
	});
*/
});

function addNumerals(){   
    var numeralOne = $("#numeralInputOne").val();
    var numeralTwo = $("#numeralInputTwo").val();
    console.log(numeralOne);
    console.log(numeralTwo);
	$.ajax({
		type: 'GET',
		url: "/add",
		contentType: "application/json",
		dataType: "json",
		data: {
			numeralOne: numeralOne,
			numeralTwo : numeralTwo
		},
		success: function(numeral){
			console.log(numeral);
            $("#calculationResult").text("Result: " + numeral.romanNumeral);
            $("#validationText").empty();
		},
        error: function(){
        	$("#calculationResult").empty();
            $("#validationText").text("Incorrect Numeral Entered!");
        }
	});
}