package com.cm.cryo.exception;

@SuppressWarnings("serial")
public class CryoDaoException extends Exception{
	public CryoDaoException(String message, Exception exception) {
		super(message,exception);
	}
}
