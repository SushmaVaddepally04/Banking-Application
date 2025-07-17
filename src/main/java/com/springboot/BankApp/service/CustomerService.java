package com.springboot.BankApp.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.BankApp.entity.Customer;
import com.springboot.BankApp.exception.CustomerNotFoundException;
import com.springboot.BankApp.exception.MinBalanceException;
import com.springboot.BankApp.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository crepo;

	@Autowired
	public CustomerService(CustomerRepository crepo) {
		this.crepo = crepo;
	}

	public Customer saveCustomer(Customer customer) throws MinBalanceException {
		if (customer.getBalance() < 1000) {
			throw new MinBalanceException();
		}
		return crepo.save(customer);
	}

	public Customer fetchCustomerByAccno(Long accNumber) throws CustomerNotFoundException {
		return crepo.findById(accNumber).orElseThrow(() -> new CustomerNotFoundException());
	}

	public Customer updateCustomer(Customer updated) throws CustomerNotFoundException {
		Customer c = fetchCustomerByAccno(updated.getAccno());
		c.setAddress(updated.getAddress());
		c.setName(updated.getName());
		c.setDob(updated.getDob());
		c.setIdproof(updated.getIdproof());
		crepo.save(c);
		return c;
	}

	public Long deleteCustomer(Long accno) throws CustomerNotFoundException {
		Customer c = fetchCustomerByAccno(accno);
		c.setBalance(0);
		crepo.deleteById(accno);
		return accno;
	}

	// service method for updating password by customer
	public String updatePasswordByAccno(Long accno, String updatedPassword) throws CustomerNotFoundException {
		Customer c = fetchCustomerByAccno(accno);
		c.setPassword(updatedPassword);
		crepo.save(c);
		return "Customer with " + accno + " password updated successfully";
	}

	// Fetching all the customers
	public List<Customer> getAllCustomers() {
		return crepo.findAll();
	}

	// Validating a customer
	public String validateCustomer(Long accno, String password) throws CustomerNotFoundException {
		Customer fetched = fetchCustomerByAccno(accno);
		if (fetched.getAccno().equals(accno)) {
			if (fetched.getPassword().equals(password)) {
				return "Login Successful";
			}
			return "Please Enter Correct Password";
		}
		return "Wrong Credentials";
	}
}
