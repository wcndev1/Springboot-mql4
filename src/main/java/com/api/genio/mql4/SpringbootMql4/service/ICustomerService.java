package com.api.genio.mql4.SpringbootMql4.service;

import com.api.genio.mql4.SpringbootMql4.controller.model.QryCustomerResponse;

public interface ICustomerService {
	QryCustomerResponse getCustomerInfo(String customerId, String uuid) throws Exception;
}
