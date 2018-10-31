package com.cg.bank.dao;

import com.cg.bank.dto.Customer;

public interface BankDao {

	public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);

	public boolean validateAccount(String mobileNo);		
}
