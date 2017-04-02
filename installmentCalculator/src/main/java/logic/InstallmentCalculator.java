package logic;

public class InstallmentCalculator {
	
	public static final float RATE = 0.069f; /**Same as is shown on web site*/
	public static final int MONTHS_IN_YEAR = 12;
	
	
	public double calculateMonthInstallment(int amountOfMoney, int countOfMonths) {
		double monthInstallment = 0;
		
		double interestRate =  1.0 + (RATE/MONTHS_IN_YEAR);
		
		monthInstallment = amountOfMoney * (Math.pow(interestRate, countOfMonths) * (interestRate - 1)) /
								 (Math.pow(interestRate, countOfMonths) - 1); 
	
		return monthInstallment;
	}
	
	
	public double calculateTotalSum(int amountOfMoney, int countOfMonths) {
		double monthInstallment = calculateMonthInstallment(amountOfMoney, countOfMonths);
		double totalSum = monthInstallment * countOfMonths;
		return totalSum;
	}
}
