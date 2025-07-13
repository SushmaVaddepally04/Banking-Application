package com.springboot.BankApp.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(Long tid) {
		super("record with Tid "+tid+" Not found");
	}
}
