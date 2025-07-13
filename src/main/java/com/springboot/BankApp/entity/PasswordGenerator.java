
package com.springboot.BankApp.entity;

import java.security.SecureRandom;

public class PasswordGenerator {

	// Define characters allowed in the password
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";

	// Secure random number generator
	private static SecureRandom random = new SecureRandom();

	public static String generateRandomPassword(int length) {
		StringBuilder password = new StringBuilder(length);

		// Generate password by randomly picking characters from CHARACTERS
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			password.append(CHARACTERS.charAt(randomIndex));
		}

		return password.toString();
	}
}