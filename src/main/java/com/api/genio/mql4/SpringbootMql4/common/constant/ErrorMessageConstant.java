package com.api.genio.mql4.SpringbootMql4.common.constant;

public enum ErrorMessageConstant {
	NONE(""),
	SUCCESS("Success."),
	DATA_NOT_FOUND ("Data Not Found.");

	private final String name;
	
	private ErrorMessageConstant(String name) {
		this.name = name;
	}

}
