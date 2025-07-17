package com.springboot.BankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BankApp.entity.Records;
import com.springboot.BankApp.exception.CustomerNotFoundException;
import com.springboot.BankApp.exception.InsufficientFundsException;
import com.springboot.BankApp.exception.MinBalanceException;
import com.springboot.BankApp.exception.RecordNotFoundException;
import com.springboot.BankApp.service.RecordService;

@RestController
public class RecordController {
	@Autowired
	private RecordService rs;
	//Saving a record
	@PostMapping("/record/{accno}/{recordType}")
	public Records saveRecord(@RequestBody Records r, @PathVariable Long accno,@PathVariable int recordType ) throws CustomerNotFoundException, MinBalanceException, InsufficientFundsException {
		return rs.saveRecordByAccno(r,accno,recordType);
	}
	//Get a record by tid
	@GetMapping("/getrecord/{tid}")
	public Records getRecord(@PathVariable Long tid) throws RecordNotFoundException {
		return rs.getRecordByTid(tid);
	}
	//getting latest 10 records
	@GetMapping("/allrecords/{accno}")
	public List<Records> getRecordsByAccno(@PathVariable Long accno) throws RecordNotFoundException{
		return rs.get10RecordsByAccno(accno);
		
	}
}
