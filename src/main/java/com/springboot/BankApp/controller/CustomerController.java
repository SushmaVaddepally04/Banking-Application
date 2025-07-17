package com.springboot.BankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BankApp.entity.Customer;
import com.springboot.BankApp.exception.CustomerNotFoundException;
import com.springboot.BankApp.exception.MinBalanceException;
import com.springboot.BankApp.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cs;

	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody Customer customer) throws MinBalanceException {
		
		return cs.saveCustomer(customer);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return cs.getAllCustomers();
	}

	@PutMapping("/customer")
	public Customer updateUser(@RequestBody Customer updateCustomer) throws CustomerNotFoundException {
		return cs.updateCustomer(updateCustomer);
	}

	@GetMapping("/customer/{accno}")
	public Customer getCustomer(@PathVariable Long accno) throws CustomerNotFoundException {
		return cs.fetchCustomerByAccno(accno);
	}

	@DeleteMapping("/customer/{accno}")
	public String deleteCustomer(@PathVariable Long accno) throws CustomerNotFoundException {
		Long no = cs.deleteCustomer(accno);
		return "Customer with id " + no + " deleted";
	}

	@PutMapping("/customer/{accno}/{password}")
	public String updatePassword(@PathVariable Long accno, @PathVariable String password)
			throws CustomerNotFoundException {
		return cs.updatePasswordByAccno(accno, password);
	}

	@PostMapping("/validateCustomer/{accno}/{password}")
	public String validateCustomer(@PathVariable Long accno, @PathVariable String password)
			throws CustomerNotFoundException {
		return cs.validateCustomer(accno, password);
	}
}
