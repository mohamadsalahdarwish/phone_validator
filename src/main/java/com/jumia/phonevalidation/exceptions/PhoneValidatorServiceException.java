package com.jumia.phonevalidation.exceptions;

public class PhoneValidatorServiceException extends RuntimeException{
 
	private static final long serialVersionUID = 1348771109171435607L;

	public PhoneValidatorServiceException(String message)
	{
		super(message);
	}
}
