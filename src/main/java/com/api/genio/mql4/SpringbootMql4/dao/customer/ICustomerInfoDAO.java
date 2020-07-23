package com.api.genio.mql4.SpringbootMql4.dao.customer;

import java.sql.SQLException;

import com.api.genio.mql4.SpringbootMql4.dao.customer.model.CustomerInfo;

public interface ICustomerInfoDAO {

	CustomerInfo getCustomerInfo(String customerId) throws SQLException, Exception;

}
