package com.springboot.BankApp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.BankApp.entity.Customer;
import com.springboot.BankApp.entity.Records;
import com.springboot.BankApp.exception.CustomerNotFoundException;
import com.springboot.BankApp.exception.InsufficientFundsException;
import com.springboot.BankApp.exception.MinBalanceException;
import com.springboot.BankApp.exception.RecordNotFoundException;
import com.springboot.BankApp.repository.RecordRepository;

@Service
public class RecordService {
	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private CustomerService cs;
	public Records saveRecordByAccno(Records r,Long accno,int recordType) throws CustomerNotFoundException, MinBalanceException, InsufficientFundsException
	{
		Customer c=cs.fetchCustomerByAccno(accno);
		// 1 is withdrawl
		if(recordType==1)
		{
			double res=c.getBalance()-r.getAmount();
			if(res>=0)
			 c.setBalance(res);
			else
				throw new InsufficientFundsException("InsufficientFunds");
		}
		else if(recordType==2)
		{
			c.setBalance(c.getBalance()+r.getAmount());
		}
		r.setCustomer(c);// setting a customer for a transaction
		cs.saveCustomer(c); // statement for updating customer balnc
		r.setTime(LocalDateTime.now());
		return recordRepository.save(r);// saving the transaction persistantly
		
	}
	public Records getRecordByTid(Long Tid) throws RecordNotFoundException {
		return recordRepository.findById(Tid).orElseThrow(()->new RecordNotFoundException(Tid));
		
	}
	public List<Records> get10RecordsByAccno(Long accno) {
		return recordRepository.findTop10ByCustomerAccnoOrderByTimeDesc(accno);
		
	}
}
