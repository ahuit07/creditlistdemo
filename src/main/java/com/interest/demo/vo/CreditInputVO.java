/**
 * 
 */
package com.interest.demo.vo;

/**@author AGG
 * @date Feb 22, 2022
 * @Desc Credit value object 
 */
public class CreditInputVO {
	private Double amount;
	private Integer terms;
	private Double rate;
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the terms
	 */
	public Integer getTerms() {
		return terms;
	}
	/**
	 * @param terms the terms to set
	 */
	public void setTerms(Integer terms) {
		this.terms = terms;
	}
	/**
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
		
}
