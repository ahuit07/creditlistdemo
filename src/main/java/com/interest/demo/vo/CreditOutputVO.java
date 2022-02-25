/**
 * 
 */
package com.interest.demo.vo;

import java.util.Date;

/**@author AGG
 * @date Feb 22, 2022
 * @Desc Credit List VO
 */
public class CreditOutputVO {
	private Integer payment_number;
    private Double amount;
    private Date payment_date;
	/**
	 * @return the payment_number
	 */
	public Integer getPayment_number() {
		return payment_number;
	}
	/**
	 * @param payment_number the payment_number to set
	 */
	public void setPayment_number(Integer payment_number) {
		this.payment_number = payment_number;
	}
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
	 * @return the payment_date
	 */
	public Date getPayment_date() {
		return payment_date;
	}
	/**
	 * @param payment_date the payment_date to set
	 */
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

}
