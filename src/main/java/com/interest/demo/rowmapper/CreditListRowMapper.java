/**
 * 
 */
package com.interest.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.interest.demo.vo.CreditOutputVO;

/**
 * @author AGG
 * @date Feb 23, 2022
 * @Desc Map credit List
 */
public class CreditListRowMapper implements RowMapper<CreditOutputVO> {

	private static final String AMOUNT = "amountdetail";
	private static final String PAYMENT_DAY = "payment_day";
	private static final String PAYMENT_NUMBER = "payment_number";

	@Override
	public CreditOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CreditOutputVO creditOutputVO = new CreditOutputVO();
		creditOutputVO.setAmount(rs.getDouble(AMOUNT));
		creditOutputVO.setPayment_date(rs.getDate(PAYMENT_DAY));
		creditOutputVO.setPayment_number(rs.getInt(PAYMENT_NUMBER));

		return creditOutputVO;
	}

}
