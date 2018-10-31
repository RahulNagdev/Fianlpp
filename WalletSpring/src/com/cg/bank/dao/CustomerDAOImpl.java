package com.cg.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.bank.dto.Customer;
@Repository("customerdao")
public class CustomerDAOImpl implements ICustomerDAO{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		em.persist(customer);
		em.flush();

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
