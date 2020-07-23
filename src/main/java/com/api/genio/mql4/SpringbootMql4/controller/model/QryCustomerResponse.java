package com.api.genio.mql4.SpringbootMql4.controller.model;

import com.api.genio.mql4.SpringbootMql4.common.model.ResponseInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QryCustomerResponse extends ResponseInfo {

	private CustomerDataInfoList customerDataInfoList;
}
