package org.installmentCalculator.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.installmentCalculator.logic.InstallmentCalculator;
import org.installmentCalculator.output.Output;

/**
 * Root resource - process request from client and return result
 * @author Jan Pavlu
 * @version 0.5
 * @TODO  Vracet objekt typu Response
 */

@Path("/")
public class CalculatorResource {
	
	
	/**Instance variables*/
	InstallmentCalculator calculator = new InstallmentCalculator();

    
    @GET
    @Produces("application/json")
    @Path("{a}/{b}/{c}")
    /**
     * Process requests from client and returns result
     * @param amountOfMoneyString		amount of money user borrowed
     * @param countOfMonthsString		for how long is going to repay the debt
     * @param insuranceString			does user have insurance?
     * @return							month installment, total sum of money user will pay, RSPN as JSON
     */
    public Output calculate(@PathParam("a") String amountOfMoneyString,
        					@PathParam("b") String countOfMonthsString,
        					@PathParam("c") String insuranceString) {
    	
    	int amountOfMoney = Integer.parseInt(amountOfMoneyString);
    	int countOfMonths = Integer.parseInt(countOfMonthsString);
    	boolean insurance = Boolean.parseBoolean(insuranceString);
    	
    	double monthInstallment = calculator.calculateMonthInstallment(amountOfMoney, countOfMonths, insurance);
    	double totalSum = calculator.calculateTotalSum(amountOfMoney, countOfMonths, insurance);
    	double RSPN = 0.0;
    	
    	/*create output*/
    	Output output = new Output(monthInstallment, totalSum, RSPN);
    	
    	System.out.println("Mesicni platba: " + output.getMonthInstallment());
    	System.out.println("Celkova suma: " + output.getTotalSumOfMoney());
    	
    	return output;
    }
}
