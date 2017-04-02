/**
 * This file includes all javasript a jquery functions
 */

/**Slider for amount of money*/
$(function() {
	$( ".amountOfMoney" ).slider({
		orientation: "horizontal",
		range: "min",
   	    min: 20000,
   	    max: 800000,
   	    animate: true,
   	    slide: function (event, ui) {
   	    	$(".amountOfMoneyInput").val(formatNumber(ui.value));
   	    	var amount = document.getElementsByClassName("amountOfMoneyInput");
   	    	amount[0].style.border="1px solid #c5c5c5";
   	    }
	});
});


/**Slider for installment time*/
$(function() {
	$( ".instalmentTime" ).slider({
		orientation: "horizontal",
		range: "min",
		min: 24,
		max: 96,
		animate: true,
		slide: function (event, ui) {
			$(".instalmentTimeInput").val(ui.value);
			var amount = document.getElementsByClassName("instalmentTimeInput");
   	    	amount[0].style.border="1px solid #c5c5c5";
		}
	});
});
       
$(function() {
	$( ".amountOfMoneyInput" ).keyup (function() {
		var inputValue = parseInt($(this).val());
		if (!isNaN(inputValue)) {
			$(".amountOfMoney").slider( "option", "value", inputValue );
		}
	});
});

       
$(function() {
	$( ".amountOfMoneyInput" ).change (function() {
		var inputValue = parseInt($(this).val());
		
		if (isNaN(inputValue) || inputValue < 20000) {
			var amount = document.getElementsByClassName("amountOfMoneyInput");
			amount[0].style.borderColor="#FF0000";
			$(this).val("");
		} else {
			var amount = document.getElementsByClassName("amountOfMoneyInput");
			amount[0].style.border="1px solid #c5c5c5";
			$(".amountOfMoney").slider( "option", "value", inputValue );
			$(this).val(formatNumber(inputValue));
		}	
	});
});
       
       
function formatNumber (number) {
	var numberAsString = number + "";
	var regexp = /(^\d+)(\d{3})/;
	
	if (regexp.test(numberAsString)) {
		numberAsString = numberAsString.replace(regexp, '$1' + " " + '$2');
	}
	
	return numberAsString;
}