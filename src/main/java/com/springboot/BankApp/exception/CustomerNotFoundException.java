package com.springboot.BankApp.exception;

public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException() {
		super("Customer Not Found");
	}
}
