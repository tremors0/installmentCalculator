package org.installmentCalculator.logic;


/**
 * This class calculates month installment, total amount off money which
 * 	client will pay and RPSN
 * @author Jan Pavlu
 * @version 0.5
 * @TODO implement RSPN calculation
 */


public class InstallmentCalculator {
	
	/**CONSTANT*/
	private static final int MONTHS_IN_YEAR = 12;
	
	/**Instance variables*/
	private float rate;
	private int insurancePrice;
	
	
	/**Constructor with default values*/
	public InstallmentCalculator() {
		this.rate = 0.069f;
		this.insurancePrice = 200;
	}
	
	
	/**Constructor with user defined values*/
	public InstallmentCalculator(float rate, int insurancePrice) {
		this.rate = rate;
		this.insurancePrice = insurancePrice;
	}
	
	
	/***************** GETTERS AND SETTERS *****************/
	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	public int getInsurancePrice() {
		return insurancePrice;
	}


	public void setInsurancePrice(int insurancePrice) {
		this.insurancePrice = insurancePrice;
	}


	/**
	 * Calculates month installment
	 * @param amountOfMoney		Amount of money user borrowed
	 * @param countOfMonths		For how many months client will pay for the loan
	 * @return					month installment
	 */
	public double calculateMonthInstallment(int amountOfMoney, int countOfMonths,
											boolean insurance) {
		double monthInstallment = 0;
		
		double interestRate =  1.0 + (rate/MONTHS_IN_YEAR);
		
		monthInstallment = amountOfMoney * (Math.pow(interestRate, countOfMonths) * (interestRate - 1)) /
								 (Math.pow(interestRate, countOfMonths) - 1); 
	    
		if (insurance) {
			monthInstallment += insurancePrice;
		}
		
		return monthInstallment;
	}
	
	
	/**
	 * 
	 * Calculates total amount of money client will pay for a loan
	 * @param amountOfMoney		Amount of money user borrowed
	 * @param countOfMonths		For how many months client will pay for the loan
	 * @return					total amount of money client will pay
	 */
	public double calculateTotalSum(int amountOfMoney, int countOfMonths, 
									boolean insurance) {
		double monthInstallment = calculateMonthInstallment(amountOfMoney, countOfMonths,
															insurance);
		double totalSum = monthInstallment * countOfMonths;
		return totalSum;
	}
}
