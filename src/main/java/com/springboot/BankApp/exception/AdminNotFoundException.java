
package com.springboot.BankApp.exception;

public class AdminNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(int id) {
		super("Admin with id " + id + " not Found");
	}
}