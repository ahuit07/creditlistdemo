/**
 * 
 */
package com.interest.demo.configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author AGG
 * @date 23 feb. 2022
 * @Desc Data Base health checker
 */
@Component("DatabaseCheck")
public class DataBaseHealthCheck implements HealthIndicator {

	private static final String QUERY_COUNT_TEST = "select count(1) from TBLCREDIT";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Health health() {
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.execute(QUERY_COUNT_TEST);
		} catch (SQLException ex) {
			return Health.outOfService().withException(ex).build();
		}
		return Health.up().build();
	}
}
