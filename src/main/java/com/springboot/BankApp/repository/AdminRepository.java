package com.springboot.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.BankApp.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
}