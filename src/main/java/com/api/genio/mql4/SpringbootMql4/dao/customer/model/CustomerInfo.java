package com.api.genio.mql4.SpringbootMql4.dao.customer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerInfo {

	private int customerId;
	private String customerCode;
	private String firstName;
	private String lastName;
	private int addressId;
	private String address;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp UpdatedDate;
	private String UpdatedBy;

}
