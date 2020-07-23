package com.api.genio.mql4.SpringbootMql4.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.genio.mql4.SpringbootMql4.controller.model.CustomerDataInfo;
import com.api.genio.mql4.SpringbootMql4.controller.model.CustomerDataInfoList;
import com.api.genio.mql4.SpringbootMql4.controller.model.QryCustomerResponse;
import com.api.genio.mql4.SpringbootMql4.dao.customer.ICustomerInfoDAO;
import com.api.genio.mql4.SpringbootMql4.dao.customer.model.CustomerInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerInfoDAO customerDAO;

	@Override
	public QryCustomerResponse getCustomerInfo(String customerId, String uuid) {
		QryCustomerResponse result = new QryCustomerResponse();
		CustomerDataInfoList custList = new CustomerDataInfoList();
		List<CustomerDataInfo> customerDataList = new ArrayList<CustomerDataInfo>();
		CustomerDataInfo customerDataInfo = new CustomerDataInfo();
		result.setTransectionId(uuid);
		try {
			CustomerInfo customerInfoResponse = customerDAO.getCustomerInfo(customerId);
			if (customerInfoResponse != null) {
				BeanUtils.copyProperties(customerInfoResponse, customerDataInfo);
				customerDataInfo.setCreatedDate(customerInfoResponse.getCreatedDate().toString());
				customerDataInfo.setUpdatedDate(customerInfoResponse.getUpdatedDate().toString());

				customerDataList.add(customerDataInfo);
				custList.setCustomerDataInfo(customerDataList);

				result.setCustomerDataInfoList(custList);
				result.setErrorCode("ER00001");
				result.setErrorMsg("Success.");

				System.out.println("##############################");
				System.out.println(new ObjectMapper().writeValueAsString(customerInfoResponse));
				System.out.println("##############################");

			} else {
				result.setErrorCode("ER10001");
				result.setErrorMsg("Data Not Found.");
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();

			result.setErrorCode("ER90009");
			result.setErrorMsg("JSON Error.");
		} catch (SQLException e) {
			e.printStackTrace();

			result.setErrorCode("ER00011");
			result.setErrorMsg("SQL Error.");
		} catch (Exception e) {
			e.printStackTrace();

			result.setErrorCode("ER90500");
			result.setErrorMsg("Internal Failure.");
		}
		return result;
	}

}
