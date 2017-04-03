package org.installmentCalculator.output;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**
 * Prepares output object which going to be send to front-end. 
 * It formats numbers to form, which will be used on website
 * @author Jan Pavlu
 * @version 1.0
 */

public class Output {
	
	private int monthInstallment;
	private String totalSumOfMoney;
	private String rpsn;
	
	/**JAX-RS need empty constructor*/
	public Output() {
		
	}
	
	
	/** Constructor */
	public Output(double monthInstallment, double totalSumOfMoney, double rpsn) {
		this.monthInstallment = (int) monthInstallment;
		this.rpsn = formatDouble(rpsn);
		this.totalSumOfMoney = formatDouble(totalSumOfMoney);
	}
	
	/**
	 * Formats double to desired format - 100000.15615 -> 100 000,15
	 * @param numberToFormat		number, which going to be formated
	 * @return						formated number (String)
	 */
	public String formatDouble(double numberToFormat) {
		DecimalFormatSymbols spaceSymbol = new DecimalFormatSymbols();
		spaceSymbol.setGroupingSeparator(' ');
		DecimalFormat decimalFormat = new DecimalFormat("###,##0.00", spaceSymbol);
		String formatedNumber = decimalFormat.format(numberToFormat);
		return formatedNumber;
	}
	
	/***************** GETTERS AND SETTERS *****************/
	public int getMonthInstallment() {
		return monthInstallment;
	}


	public void setMonthInstallment(int monthInstallment) {
		this.monthInstallment = monthInstallment;
	}


	public String getTotalSumOfMoney() {
		return totalSumOfMoney;
	}


	public void setTotalSumOfMoney(String totalSumOfMoney) {
		this.totalSumOfMoney = totalSumOfMoney;
	}


	public String getRSPN() {
		return rpsn;
	}


	public void setRSPN(String rpsn) {
		this.rpsn = rpsn;
	}
	
}
