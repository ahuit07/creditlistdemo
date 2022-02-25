/**
 * 
 */
package com.interest.demo.repository.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.interest.demo.repository.InterestRepository;
import com.interest.demo.rowmapper.CreditListRowMapper;
import com.interest.demo.vo.BusinessErrorException;
import com.interest.demo.vo.CreditInputVO;
import com.interest.demo.vo.CreditOutputVO;

/**
 * @author AGG
 * @date Feb 22, 2022
 * @Desc Interest Repository Implementation
 */
@Repository
public class InterestRepositoryImpl implements InterestRepository {

	private static final String ERROR_SMS = "An error occurred while processing your request, please try again later.";

	protected static final String INSERT_CREDIT_SQL = "INSERT INTO TBLCREDIT  (AMOUNT, TERMS, RATE, RATEAMOUNT, TOTALAMOUNT) VALUES(?, ?, ?, ?, ?)";

	private static final String INSERT_CREDIT_DETAIL_SQL = "INSERT INTO TBLCREDITDETAIL (IDCREDIT, AMOUNTDETAIL, PAYMENT_DAY, PAYMENT_NUMBER) VALUES(?, ?, ?, ?)";

	private static final String QUERY_CREDIT_DETAIL_SQL = "SELECT AMOUNTDETAIL, PAYMENT_DAY, PAYMENT_NUMBER FROM TBLCREDITDETAIL WHERE IDCREDIT = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CreditOutputVO> creteCreditList(CreditInputVO creditInputVO) {
		List<CreditOutputVO> listaDemo = null;
		try {
			Integer newKey = createCredit(creditInputVO);

			listaDemo = jdbcTemplate.query(QUERY_CREDIT_DETAIL_SQL, new CreditListRowMapper(), new Object[] { newKey });
		} catch (Exception e) {
			throw new BusinessErrorException(ERROR_SMS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return listaDemo;
	}

	/**
	 * @author AGG
	 * @date Feb 23, 2022
	 * @Desc Save data
	 * @return void
	 */
	private Integer createCredit(CreditInputVO creditInputVO) {
		Integer newKey = 0;

		/**
		 * Get total rate
		 */
		BigDecimal bigDecimalRate = new BigDecimal(
				creditInputVO.getAmount() * (creditInputVO.getRate() / 100) * creditInputVO.getTerms()).setScale(2,
						RoundingMode.HALF_UP);
		Double totalRateAmount = bigDecimalRate.doubleValue();

		/**
		 * Total plus rate
		 */
		BigDecimal bigDecimalTotal = new BigDecimal(totalRateAmount + creditInputVO.getAmount()).setScale(2,
				RoundingMode.HALF_UP);
		Double totalAmount = bigDecimalTotal.doubleValue();

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(INSERT_CREDIT_SQL,
						Statement.RETURN_GENERATED_KEYS);
				ps.setDouble(1, creditInputVO.getAmount());
				ps.setInt(2, creditInputVO.getTerms());
				ps.setDouble(3, creditInputVO.getRate());
				ps.setDouble(4, totalRateAmount);
				ps.setDouble(5, totalAmount);
				return ps;
			}
		}, keyHolder);

		newKey = keyHolder.getKey().intValue();

		/**
		 * Weekly Amount
		 */
		BigDecimal bigDecimalWeek = new BigDecimal(totalAmount / creditInputVO.getTerms()).setScale(2,
				RoundingMode.HALF_UP);

		Double weekAmount = bigDecimalWeek.doubleValue();

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime week = today.plusDays(7);

		for (int i = 0; i < creditInputVO.getTerms(); i++) {

			jdbcTemplate.update(INSERT_CREDIT_DETAIL_SQL, new Object[] { newKey, weekAmount, week, i + 1 });

			week = week.plusDays(7);
		}

		return newKey;
	}

}
