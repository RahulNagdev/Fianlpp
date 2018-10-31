package com.cg.bank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dao.ICustomerDAO;
import com.cg.bank.dto.Customer;
@Service("customerservice")
@Transactional

public class CustomerServiceImpl implements ICustomerService{
@Autowired
ICustomerDAO customerdao;

	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		customerdao.createAccount(customer);
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		
	}

}
