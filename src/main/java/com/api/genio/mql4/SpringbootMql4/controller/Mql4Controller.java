package com.api.genio.mql4.SpringbootMql4.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.genio.mql4.SpringbootMql4.controller.model.QryCustomerRequest;
import com.api.genio.mql4.SpringbootMql4.controller.model.QryCustomerResponse;
import com.api.genio.mql4.SpringbootMql4.service.ICustomerService;

@Controller
@RestController
@RequestMapping("/Mql4")
public class Mql4Controller {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/qryCustomer", method = RequestMethod.POST)
	public ResponseEntity<QryCustomerResponse> getCustomer(@RequestBody QryCustomerRequest request, @RequestHeader(name = "X-Username", required = false) String xUser, @RequestHeader(name = "X-LegacyUsername", required = false) String xLagacy,
			@RequestHeader(name = "X-Channel", required = false) String xChannel) throws Exception {
		String uuid = UUID.randomUUID().toString();

		QryCustomerResponse response = new QryCustomerResponse();
		try{
			response = customerService.getCustomerInfo(request.getCustomerId(), uuid);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
		

		
	}
}
