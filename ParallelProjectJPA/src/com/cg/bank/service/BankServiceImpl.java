package com.cg.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bank.dao.BankDao;
import com.cg.bank.dao.BankDaoImpl;
import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;


public class BankServiceImpl implements BankService{
	BankDao dao;
	
	public BankServiceImpl() throws BankException {
		dao = new BankDaoImpl();
	}

	//------------------------ 1. Wallet Application --------------------------
	/****************************************************************************************************************
	 - Function Name	:	createAccount(Customer customer)
	 - Input Parameters	:	Customer customer
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	adding customer account to database calls dao method createAccount(Customer customer)
	 ****************************************************************************************************************/
	
	@Override
	public void createAccount(Customer customer) {
		dao.createAccount(customer);	
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	deposit(String mobileNo, double amount)
	 - Input Parameters	:	MonileNo and Amount
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	calls dao method deposit(String mobileNo, double amount) 
	 ********************************************************************************************************/
	@Override
	public void deposit(String mobileNo, double amount) {
		dao.deposit(mobileNo, amount);
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	withdraw(String mobileNo, double amount)
	 - Input Parameters	:	MonileNo and Amount
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	calls dao method withdraw(String mobileNo, double amount) 
	 ********************************************************************************************************/
	@Override
	public void withdraw(String mobileNo, double amount) {
		dao.withdraw(mobileNo, amount);
	}
	//------------------------ 1. Wallet Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	checkBalance(String mobileNo)
			 - Input Parameters	:	MonileNo
			 - Return Type		:	double
			 - Author			:	CAPGEMINI
			 - Creation Date	:	10/30/2018
			 - Description		:	calls dao method checkBalance(String mobileNo)
			 ********************************************************************************************************/

	@Override
	public double checkBalance(String mobileNo) {
		return dao.checkBalance(mobileNo);
	}
	//------------------------ 1. Wallet Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	fundTransfer(String sender, String reciever, double amount)
	 - Input Parameters	:	Sender's Mobile No.,Receiver's Mobile No. and Amount
	 - Return Type		:	void
	 - Author			:	CAPGEMINI
	 - Creation Date	:	10/30/2018
	 - Description		:	calls dao method fundTransfer(String sender, String reciever, double amount)
	 ********************************************************************************************************/

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		dao.fundTransfer(sender, reciever, amount);
		
	}

	/*******************************************************************************************************
	 - Function Name	: validateName(String name)
	 - Input Parameters	: Name
	 - Return Type		: Boolean
	 - Throws		    : BAnkException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 10/30/2018
	 - Description		: validates the Customer Name
	 ********************************************************************************************************/
		
	public boolean validateName(String name) throws BankException {		//Checking for valid name
		if(name == null)
			throw new BankException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,10}");
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.out.println("Name invalid! Name should start with a capital letter and contain only alphabets");
		return m.matches();	
	}
	/*******************************************************************************************************
	 - Function Name	: validateAge(float age)
	 - Input Parameters	: Age
	 - Return Type		: Boolean
	 - Throws		    : BankException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 10/30/2018
	 - Description		: validates the Customer Age
	 ********************************************************************************************************/
	@Override
	public boolean validateAge(float age)  throws BankException {		//Checking for valid age
		try{
			if(age == 0)
				System.out.println("Age cannot be  null");
			else if(age >100)
				System.out.println("Age cannot be  greater than 100");
			else if(age < 0)
				System.out.println("Age cannot be a negative number");
			else if(age <=17)
				System.out.println("Minimum age to open account is 18");
			else if(age >17)
				return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}
	/*******************************************************************************************************
	 - Function Name	: validateMoileNo(String mobileNo)
	 - Input Parameters	: MobileNo
	 - Return Type		: Boolean
	 - Throws		    : BAnkException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 10/30/2018
	 - Description		: validates the Customer's Mobile No.
	 ********************************************************************************************************/
	
	@Override
	public boolean validateMoileNo(String mobileNo) throws BankException{		//Checking for valid mobile number
		try{
			if(mobileNo == null)
				throw new BankException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid! Enter a valid Indian number (6-9) of 10 digits");
			return m.matches();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}
	/*******************************************************************************************************
	 - Function Name	: validateAmount(double amount)
	 - Input Parameters	: amount
	 - Return Type		: Boolean
	 - Throws		    : BAnkException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 10/30/2018
	 - Description		: validates the Amount.
	 ********************************************************************************************************/
	
	@Override
	public boolean validateAmount(double amount) throws BankException {			//Checking for valid transaction amount
		String am = String.valueOf(amount);
		if(amount == 0){
			System.out.println("Null value found! Amount cannot be zero");
			return false;
		}
		else if(!am.matches("\\d{3,9}\\.\\d{0,4}")){
			System.out.println("Invalid Amount! Enter a valid numeric value");
			return false;
		}
		else{
			return (am.matches("\\d{3,9}\\.\\d{0,4}"));
		}
		
	}

	@Override
	public boolean validateAccount(String mobileNo) {		
		return dao.validateAccount(mobileNo);	
	}

}
