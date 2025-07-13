package com.springboot.BankApp.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accno;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String acctype;
	@Column(nullable = false)
	private double balance;
	@Column(nullable = false, unique = true)
	private String idproof;
	@Column(nullable = false)
	private Date dob;
	@Column(nullable = false)
	private Long mobileno;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String address;
	@OneToMany(mappedBy = "customer", targetEntity = Records.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Records> records;

	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	public Customer(Long accno, String name, String acctype, double balance, String idproof, Date dob, Long mobileno,
			String email, String password, String address, List<Records> records) {
		super();
		this.accno = accno;
		this.name = name;
		this.acctype = acctype;
		this.balance = balance;
		this.idproof = idproof;
		this.dob = dob;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
		this.address = address;
		this.records = records;
	}

	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", name=" + name + ", acctype=" + acctype + ", balance=" + balance
				+ ", idproof=" + idproof + ", dob=" + dob + ", mobileno=" + mobileno + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", records=" + records + "]";
	}

	public Customer() {
		super();
	}

}
