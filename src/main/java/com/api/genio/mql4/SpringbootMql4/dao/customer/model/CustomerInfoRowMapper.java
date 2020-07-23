package com.api.genio.mql4.SpringbootMql4.dao.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerInfoRowMapper implements RowMapper<CustomerInfo> {
	@Override
	public CustomerInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerInfo modelInfo = new CustomerInfo();
		modelInfo.setCustomerId(rs.getInt("cust_id"));
		modelInfo.setCustomerCode(rs.getString("cust_code"));
		modelInfo.setFirstName(rs.getString("rname"));
		modelInfo.setLastName(rs.getString("sname"));
		modelInfo.setAddressId(rs.getInt("address_id"));
		modelInfo.setAddress(rs.getString("address"));
		modelInfo.setCreatedDate(rs.getTimestamp("created_date"));
		modelInfo.setCreatedBy(rs.getString("created_by"));
		modelInfo.setUpdatedDate(rs.getTimestamp("Updated_date"));
		modelInfo.setUpdatedBy(rs.getString("Updated_by"));

		return modelInfo;
	}

}