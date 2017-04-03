package org.installmentCalculator.logic;


/**
 * This class calculates month installment, total amount off money which
 * 	client will pay and RPSN
 * @author Jan Pavlu
 * @version 0.5
 * @TODO implement RSPN calculation
 */


public class InstallmentCalculator {
	
	public static final float RATE = 0.069f; /**Same as is shown on web site*/
	public static final int MONTHS_IN_YEAR = 12;
	
	
	/**
	 * Calculates month installment
	 * @param amountOfMoney		Amount of money user borrowed
	 * @param countOfMonths		For how many months client will pay for the loan
	 * @return					month installment
	 */
	public double calculateMonthInstallment(int amountOfMoney, int countOfMonths) {
		double monthInstallment = 0;
		
		double interestRate =  1.0 + (RATE/MONTHS_IN_YEAR);
		
		monthInstallment = amountOfMoney * (Math.pow(interestRate, countOfMonths) * (interestRate - 1)) /
								 (Math.pow(interestRate, countOfMonths) - 1); 
	    
		return monthInstallment;
	}
	
	
	/**
	 * 
	 * Calculates total amount of money client will pay for a loan
	 * @param amountOfMoney		Amount of money user borrowed
	 * @param countOfMonths		For how many months client will pay for the loan
	 * @return					total amount of money client will pay
	 */
	public double calculateTotalSum(int amountOfMoney, int countOfMonths) {
		double monthInstallment = calculateMonthInstallment(amountOfMoney, countOfMonths);
		double totalSum = monthInstallment * countOfMonths;
		return totalSum;
	}
}
