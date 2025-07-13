package com.springboot.BankApp.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Records {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tid;
	@Column(nullable = false)
	private int recordType;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private LocalDateTime time;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accNumber")
	@JsonIgnore
	private Customer customer;

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public int getRecordType() {
		return recordType;
	}

	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Records [tid=" + tid + ", recordType=" + recordType + ", amount=" + amount + ", time=" + time
				+ ", customer=" + customer + "]";
	}

	public Records(Long tid, int recordType, double amount, LocalDateTime time, Customer customer) {
		super();
		this.tid = tid;
		this.recordType = recordType;
		this.amount = amount;
		this.time = time;
		this.customer = customer;
	}

	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}
}
