package com.phoenix.exceptions;

public class SeviceException extends Exception{
private String errorMessage;
	
	public SeviceException(String errorMessage) {
		super(errorMessage);
	}

}
