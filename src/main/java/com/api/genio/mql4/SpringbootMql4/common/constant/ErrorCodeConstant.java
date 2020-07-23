package com.api.genio.mql4.SpringbootMql4.common.constant;

public enum ErrorCodeConstant {
	NONE(""),
	SUCCESS ("00001"),
	DATA_NOT_FOUND ("10001");
	
	private final String name;
	
	private ErrorCodeConstant(String name) {
		this.name = name;
	}

}
