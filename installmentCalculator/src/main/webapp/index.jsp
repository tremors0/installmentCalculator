<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="cs">

<head>
	<title>Splatkova kalkulacka</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="scripts/main.js"></script>
</head>

<body>
		
	<div class = "wrapper">

		<div class = "content left">
			<h2>Expres půjčku schválíme online do 5 minut</h2>
	    	
	    	<h3> Kolik si chci půjčit</h3>
	    	<div class = sliderWrapper>
		    	<div class = "slider amountOfMoney"></div>
		    	<p class = "limits"> 20 000 Kč <span class = "max_limit"> 800 000 Kč</span></p>
	    	</div>
	    	<div class = inputTextWrapper>
		    	<input type = "text" class = "inputText amountOfMoneyInput" name = "amountOfMoney">
		    	<span class = "bold moveDown"> Kč </span>
	    	</div>
	    	
	    	<h3> Na jak dlouho? </h3>
    		
    		<div class = sliderWrapper>
		    	<div class = "slider instalmentTime"></div>
		    	<p class = "limits"> 24 měsíců <span class = "max_limit"> 96 měsíců</span></p>
	    	</div>
	    	<div class = inputTextWrapper>
	    		<input type = "text" class = "inputText instalmentTimeInput" name = "instalmentTime">
	    		<span class = "bold moveDown"> měsíců </span>
	    		<p id = monthsToYears><p>
	    	</div>
	    	
	    	
	    	<h3> Pojištění proti neschopnosti splácet</h3>
	        <input type="radio" name = "insurance" value="withInsurance" id = "radioInput1">
	        	<label for = "radioInput1"> S pojištěním</label>
	      	<input type="radio" name = "insurance" value="withoutInsurance" id = "radioInput2" checked="checked">
	      		<label for = "radioInput2"> Bez pojištění</label>
	    	
	    	<div id = "moreInformation">
		    	<p>Úroková sazba od <span class = "bold"> XXX % </span>, RSPN od <span class = "bold"> XXX % </span>, 
		    		pojištění <span class = "bold"> XXX Kč/měsíčně </span>, poplatek za sjednání 
		    		online <span class = "bold"> 0 Kč</span>, celkem zaplatíte <span class = "bold"> XXX Kč </span></p>
		    	
		    	<p> Výše uvedené splátky je pouze orientační a od výsledné schválené výše splátky se může lišit.</p>
	    	</div>
	    	
		</div>
		
		<div class = "content right">
			<p id = "montPaymentTitle"> Měsíčně zaplatíte </p>
			<p> <span id = "monthPayment"> XXX </span> </p>
			<div id = "continue"> <a href = "#" title="pokracovat"> POKRAČOVAT </a> </div>
			<p id = "telephoneLink"><a href = "#">nebo Vám zavoláme </a> </p> 
		</div>
		
		<footer id = "footer"> </footer>
	</div>
</body>
</html>
