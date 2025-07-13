package com.springboot.BankApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.BankApp.entity.Records;

@Repository
public interface RecordRepository extends JpaRepository<Records,Long> {

	List<Records> findTop10ByCustomerAccnoOrderByTimeDesc(Long accno);

}
