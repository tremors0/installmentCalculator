/**
 * This file includes all javasript a jquery functions
 * https://www.algoritmy.net/article/123/Anuita - vypocet anuity
 */

/**
 * Slider for amount of money
 * Updates input text - amount of money
 * */
$(function() {
	$( ".amountOfMoney" ).slider({
		orientation: "horizontal",
		range: "min",
   	    min: 20000,
   	    max: 800000,
   	    animate: true,
   	    slide: function (event, ui) {
   	    	$(".amountOfMoneyInput").val(formatNumber(ui.value));
   	    	// set default design for input text
   	    	var amount = document.getElementsByClassName("amountOfMoneyInput");
   	    	amount[0].style.border="1px solid #c5c5c5";
   	    },
   	    stop: function (event, ui) {
   	    	createRequest();
   	    }
	});
});


/**
 * Slider for installment time
 * Updates input text - installment time
 * */
$(function() {
	$( ".instalmentTime" ).slider({
		orientation: "horizontal",
		range: "min",
		min: 24,
		max: 96,
		animate: true,
		slide: function (event, ui) {
			$(".instalmentTimeInput").val(ui.value);
			// set default design for input text
			var amount = document.getElementsByClassName("instalmentTimeInput");
   	    	amount[0].style.border="1px solid #c5c5c5";
   	    	monthsToYearAndMonths(ui.value);
		},
		stop: function (event, ui) {
   	    	createRequest();
   	    }
	});
});


/**
 * Input text for amount of money
 * It updates slider when value is changed and correct
 * */
$(function() {
	$( ".amountOfMoneyInput" ).keyup (function() {
		var inputValue = parseInt($(this).val());
		if (!isNaN(inputValue)) {
			$(".amountOfMoney").slider( "option", "value", inputValue );
		}
	});
});


/**
 * Input text for amount of money
 * Function checks if value in input text box is correct, updates slider value
 * and its own value. It makes red border around input text if value is not correct
 */       
$(function() {
	$( ".amountOfMoneyInput" ).change (function() {
		var inputValue = parseInt($(this).val());
		
		if (isNaN(inputValue) || inputValue < 20000 || inputValue > 800000) {
			var amount = document.getElementsByClassName("amountOfMoneyInput");
			amount[0].style.borderColor="#FF0000";
			$(this).val("");
		} else {
			var amount = document.getElementsByClassName("amountOfMoneyInput");
			amount[0].style.border="1px solid #c5c5c5";
			$(".amountOfMoney").slider( "option", "value", inputValue );
			createRequest();
			$(this).val(formatNumber(inputValue));
		}	
	});
});


/**
 * Input text for installment time
 * It updates slider when value is changed and correct
 * */
$(function() {
	$( ".instalmentTimeInput" ).keyup (function() {
		var inputValue = parseInt($(this).val());
		if (!isNaN(inputValue)) {
			$(".instalmentTime").slider( "option", "value", inputValue );
		}
	});
});


/**
 * Input text for installment time
 * Function checks if value in input text box is correct, updates slider value
 * and its own value. It makes red border around input text if value is not correct
 */       
$(function() {
	$( ".instalmentTimeInput" ).change (function() {
		var inputValue = parseInt($(this).val());
		
		if (isNaN(inputValue) || inputValue < 24 || inputValue > 96) {
			var amount = document.getElementsByClassName("instalmentTimeInput");
			amount[0].style.borderColor="#FF0000";
			$(this).val("");
		} else {
			var amount = document.getElementsByClassName("instalmentTimeInput");
			amount[0].style.border="1px solid #c5c5c5";
			$(".instalmentTime").slider( "option", "value", inputValue );
			createRequest();
			$(this).val(inputValue);
		}	
	});
});
      

$(function(){
	$("#radioInput1").click(function(){
		if ($(this).is(':checked')) {
			createRequest();
		}
	});
});


$(function(){
	$("#radioInput2").click(function(){
		if ($(this).is(':checked')) {
			createRequest();
		}
	});
});


function createRequest () {
	var uriString = "/installmentCalculator/webapi/";
	
	var amountOfMoney = deleteWhitespaces($(".amountOfMoneyInput").val());
	
	if (amountOfMoney) {
		uriString +=  amountOfMoney + "/";
	} else {
		return;
	}
	
	var instalmentTime = $(".instalmentTimeInput").val();
	
	if (instalmentTime) {
		uriString += instalmentTime + "/";
	} else {
		return;
	}
	
	if ($("#radioInput2").is(':checked')) {
		uriString += "false";
	} else {
		uriString += "true";
	}
	
	sendRequest(uriString);
	console.log("URI: " + uriString);
}


function sendRequest(uriString) {
	$.getJSON(uriString, function(jd) {
		$("#monthPayment").text(formatNumber(jd.monthInstallment) + " Kč");
		$("#rpsn").text(jd.RSPN);
		$("#totalSum").text(jd.totalSumOfMoney + " Kč");
	});
}


function deleteWhitespaces(originValue) {
	return originValue.replace(/\s+/g, '');
}


/**
 * Formats number: 20000 -> 20 000 etc
 * @param number		value, which is formated
 * @returns formatted String
 */
function formatNumber (number) {
	var numberAsString = number + "";
	var regexp = /(^\d+)(\d{3})/;
	
	if (regexp.test(numberAsString)) {
		numberAsString = numberAsString.replace(regexp, '$1' + " " + '$2');
	}
	
	return numberAsString;
}


/**
 * Transform months to years and months and show it on web site
 * @param months	count of months
 * @returns
 */
function monthsToYearAndMonths(months) {
	var years = (months / 12) >> 0;
	var monthsLeft = months % 12;
	var yearExtensions = ["let", "rok", "roky", "roky", "roky", "let"];
	
	var indexInYearExtensions = years;
	if (indexInYearExtensions > 5) {
		indexInYearExtensions = 5;
	}
	
	var result = "";
	
	//if it is more than 12 months
	if (years != 0) {
		result += years + " " + yearExtensions[indexInYearExtensions];
	}
	
	var monthExtensions = ["měsíců", "měsíc", "měsíce", "měsíce", "měsíce", "měsíců"];
	var indexInMonthExtensions = monthsLeft;
	if (indexInMonthExtensions > 5) {
		indexInMonthExtensions = 5;
	}
	
	if (monthsLeft != 0) {
		result += " " + monthsLeft + " " + monthExtensions[indexInMonthExtensions];
	}
	
	document.getElementById('monthsToYears').innerHTML = result;
}