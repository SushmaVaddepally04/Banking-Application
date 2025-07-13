package com.springboot.BankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BankApp.entity.Admin;
import com.springboot.BankApp.exception.AdminNotFoundException;
import com.springboot.BankApp.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	@PostMapping("/admin")
	public Admin saveUser(@RequestBody Admin admin) {
		return service.createAdmin(admin);
	}
	@PutMapping("/updateadmin/{id}")
	public Admin updateUser(@RequestBody Admin updatedAdmin,@PathVariable int id) {
		return service.updateAdmin(updatedAdmin,id);
	}
	@GetMapping("/admin/{id}")
	public Admin getUser(@PathVariable int id) {
		return service.fetchAdmin(id);
	}
	@DeleteMapping("/admin/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteAdmin(id);
	}
	@PostMapping("/validateAdmin/{id}")
	public String validateAdmin(@RequestBody Admin updatedAdmin,@PathVariable int id) throws AdminNotFoundException {
		return service.validateAdmin(updatedAdmin,id);
	}
}
