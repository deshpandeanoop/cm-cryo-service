package com.cm.cryo.exception;

@SuppressWarnings("serial")
public class CryoServiceException extends Exception {
public CryoServiceException(String message, Exception exception) {
	super(message,exception);
}
}
