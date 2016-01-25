package com.prep.cci.stackandqueue;

public class StackFullException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public StackFullException() {}
	public StackFullException(String msg) {
		super(msg);
	}
}
