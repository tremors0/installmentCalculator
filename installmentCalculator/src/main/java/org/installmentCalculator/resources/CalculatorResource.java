package org.installmentCalculator.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.installmentCalculator.logic.InstallmentCalculator;
import org.installmentCalculator.output.Output;

/**
 * Root resource 
 */
@Path("/")
public class CalculatorResource {

	InstallmentCalculator calculator = new InstallmentCalculator();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("installment/{a}/{b}/{c}")
    public String calculate(@PathParam("a") String amountOfMoneyString,
        					@PathParam("b") String countOfMonthsString,
        					@PathParam("c") String insuranceString) {
    	
    	int amountOfMoney = Integer.parseInt(amountOfMoneyString);
    	int countOfMonths = Integer.parseInt(countOfMonthsString);
    	
    	double monthInstallment = calculator.calculateMonthInstallment(amountOfMoney, countOfMonths);
    	double totalSum = calculator.calculateTotalSum(amountOfMoney, countOfMonths);
    	double RSPN = 0.0;
    	
    	/*create output*/
    	Output output = new Output(monthInstallment, totalSum, RSPN);
    	
    	System.out.println("Mesicni platba: " + output.getMonthInstallment());
    	System.out.println("Celkova suma: " + output.getTotalSumOfMoney());
    	
    	return output.getMonthInstallment() + ", " + output.getTotalSumOfMoney()  + ", " + insuranceString;
    }
}
