package com.springboot.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.BankApp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
