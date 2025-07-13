package com.springboot.BankApp.exception;

public class MinBalanceException extends Exception {
	public MinBalanceException() {
		super("The Minimum balance is 1000 to register an account");
	}
}
