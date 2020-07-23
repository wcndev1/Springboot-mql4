package com.api.genio.mql4.SpringbootMql4.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDataInfo {

	private Integer customerId;
	private String customerCode;
	private String firstName;
	private String lastName;
	private Integer addressId;
	private String address;
	private String createdDate;
	private String createdBy;
	private String UpdatedDate;
	private String UpdatedBy;

}
