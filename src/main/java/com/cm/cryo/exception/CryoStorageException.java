package com.cm.cryo.exception;

@SuppressWarnings("serial")
public class CryoStorageException  extends Exception{
public CryoStorageException(String message, Exception exception) {
	super(message,exception);
}
}
