package org.installmentCalculator.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import logic.InstallmentCalculator;

/**
 * Root resource 
 */
@Path("/")
public class CalculatorResource {

	InstallmentCalculator calculater = new InstallmentCalculator();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("installment/{a}/{b}/{c}")
    public String calculate(
            @PathParam("a") String amountOfMoneyString,
            @PathParam("b") String countOfMonthsString,
            @PathParam("c") String insuranceString) {
    	
    	int amountOfMoney = Integer.parseInt(amountOfMoneyString);
    	int countOfMonths = Integer.parseInt(countOfMonthsString);
    	
    	double monthInstallment = calculater.calculateMonthInstallment(amountOfMoney, countOfMonths);
    	System.out.println("Mesicni splatka: " + monthInstallment);
    	
    	double totalSum = calculater.calculateTotalSum(amountOfMoney, countOfMonths);
    	System.out.println("Celkova suma: " + totalSum);
    	
    	return amountOfMoney + ", " + countOfMonths + ", " + insuranceString;
    }
}
