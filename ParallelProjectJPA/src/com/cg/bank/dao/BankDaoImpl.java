package com.cg.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;


public class BankDaoImpl implements BankDao{
	
	EntityManager manager;
	
	public BankDaoImpl(){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		manager =emf.createEntityManager();
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	createAccount(Customer customer)
	 - Input Parameters	:	Customer customer
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	Adding Customer Account
	 ********************************************************************************************************/

	public void createAccount(Customer customer){
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();	
		System.out.println("Customer added\nName: "+customer.getName()+"\nMobile number: "+customer.getMobileNo()+"\nAge: "+customer.getAge()+"\nBalance: "+customer.getInitialBalance());
	}
	//------------------------ 1. Wallet Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	deposit(String mobileNo, double amount)
		 - Input Parameters	:	MonileNo and Amount
		 - Return Type		:	void
		 - Author			:	CAPGEMINI
		 - Creation Date	:	10/30/2018
		 - Description		:	Depositing Amount
		 ********************************************************************************************************/
	@Override
	public void deposit(String mobileNo, double amount) {
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		amt=amt+amount;
		cust.setInitialBalance(amt);
		manager.getTransaction().commit();
		System.out.println("Amount deposited! New balance: "+amt);
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	withdraw(String mobileNo, double amount)
	 - Input Parameters	:	MonileNo and Amount
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	Withdrawing Amount
	 ********************************************************************************************************/

	@Override
	public void withdraw(String mobileNo, double amount) {
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		if(amt-amount>=500){
			amt=amt-amount;
			System.out.println(amt);
			cust.setInitialBalance(amt);
			manager.getTransaction().commit();
			System.out.println("Amount withdrawn! New balance: "+amt);
		}
		else{
			System.out.println("Cannot withdraw! Minimum balance of Rs.500 should be maintained");
		}
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	checkBalance(String mobileNo)
	 - Input Parameters	:	MonileNo
	 - Return Type		:	double
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	Checking Account Balance
	 ********************************************************************************************************/

	public double checkBalance(String mobileNo) {
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		System.out.println(amt);
		return amt;
		
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	fundTransfer(String sender, String reciever, double amount)
	 - Input Parameters	:	Sender's Mobile No.,Receiver's Mobile No. and Amount
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	Transfer of Amount
	 ********************************************************************************************************/

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		manager.getTransaction().begin();
		Customer cust1 = manager.find(Customer.class, sender);
		double amt1 =cust1.getInitialBalance();
		Customer cust2 = manager.find(Customer.class, reciever);
		double amt2 =cust2.getInitialBalance();
		if(amt1-amount>=500){
			amt1=amt1-amount;
			amt2=amt2+amount;
			cust1.setInitialBalance(amt1);
			cust2.setInitialBalance(amt2);
			manager.getTransaction().commit();
			System.out.println("Amount transferred!\nNew balance in "+sender+" account is "+amt1+"\nBalance in "+reciever+" account is "+amt2);
		}
		else{
			System.out.println("Cannot tranfer! Sender has to maintain minimum balance of Rs.500");
		}
	}
	
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	validateAccount(String mobileNo)
	 - Input Parameters	:	 Mobile No.
	 - Return Type		:	Boolean
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	Account Validation
	 ********************************************************************************************************/
	
	public boolean validateAccount(String mobileNo){
		Customer cust3=manager.find(Customer.class, mobileNo);
		if(cust3==null)
			return false;
		return true;
	}

}
