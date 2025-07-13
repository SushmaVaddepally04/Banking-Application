package com.springboot.BankApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name="admin_table")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;

	@Override
	public String toString() {
		return "Admin [id=" + adminId + ", name=" + name + ", password=" + password + "]";
	}

	public int getId() {
		return adminId;
	}

	public void setId(int id) {
		this.adminId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(int id, String name, String password) {
		super();
		this.adminId = id;
		this.name = name;
		this.password = password;
	}

	public Admin() {
		super();

	}

}
