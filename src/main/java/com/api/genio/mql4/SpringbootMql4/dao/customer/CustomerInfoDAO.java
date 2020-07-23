package com.api.genio.mql4.SpringbootMql4.dao.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.genio.mql4.SpringbootMql4.dao.customer.model.CustomerInfo;
import com.api.genio.mql4.SpringbootMql4.dao.customer.model.CustomerInfoRowMapper;

@Repository
public class CustomerInfoDAO implements ICustomerInfoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public CustomerInfo getCustomerInfo(String customerId) throws SQLException, Exception {
		CustomerInfo result = new CustomerInfo();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * ");
		sb.append(" from customer ");
		sb.append(" where cust_id = :customerId ");

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", customerId);
		RowMapper<CustomerInfo> rowMapper = new CustomerInfoRowMapper();
		List<CustomerInfo> preResult = this.jdbcTemplate.query(sb.toString(), parameterSource, rowMapper);

		if (preResult != null && preResult.size() > 0) {
			result = preResult.get(0);
		} else {
			result = null;
		}

		return result;
	}

}
