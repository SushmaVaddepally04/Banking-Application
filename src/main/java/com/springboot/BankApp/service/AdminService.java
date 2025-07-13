package com.springboot.BankApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.BankApp.entity.Admin;
import com.springboot.BankApp.exception.AdminNotFoundException;
import com.springboot.BankApp.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	public AdminService(AdminRepository arepo) {
		this.arepo = arepo;
	}

	private AdminRepository arepo;

	// creating admin
	public Admin createAdmin(Admin admin) {
		Admin savedArepo = arepo.save(admin);
		return savedArepo;
	}

	// updating admin
	public Admin updateAdmin(Admin updateAdmin, int id) {
		Admin admin = fetchAdmin(id);
		Admin updated = null;
		if (admin != null) {
			admin.setName(updateAdmin.getName());
			admin.setPassword(updateAdmin.getPassword());
			updated = arepo.save(admin);
		}
		return updated;
	}

	// reading admin
	public Admin fetchAdmin(int id) {
		Optional<Admin> res = arepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		}
		return null;
	}

	//delete admin
	public String deleteAdmin(int id) {
		arepo.deleteById(id);
		return "Admin with id " + id + " deleted";
	}
	//Validating Admin
	public String validateAdmin(Admin admin, int id) throws AdminNotFoundException {
		Admin fetched = fetchAdmin(id);
		String uname = admin.getName();
		String password = admin.getPassword();
		if (fetched.getName().equals(uname)) {
			if (fetched.getPassword().equals(password))
				return "Success";
			else
				return "Enter the Correct Password";
		}
		return "Wrong Credentials";

	}
}
