package com.cg.bam.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bam.dao.BankAccountDAO;
import com.cg.bam.dao.BankAccountDAOImpl;
import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BankAccountException;


public class BankAccountServiceImpl implements BankAccountService{

	BankAccountDAO dao  = new BankAccountDAOImpl();
	
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		dao.createAccount(customer);		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.deposit(mobileNo, amount);
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.withdraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		dao.fundTransfer(sender, reciever, amount);
		
	}

	@Override
	public boolean validateName(String name) throws BankAccountException {
		// TODO Auto-generated method stub
		if(name == null)
			throw new BankAccountException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,10}");
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.out.println("Name invalid!(Should Start with Capital letter and minimum length should be 3....)");
		return m.matches();
		
	}

	@Override
	public boolean validateAge(float age)  throws BankAccountException {
		try{
			// TODO Auto-generated method stub
			if(age == 0)
				throw new BankAccountException("Age cannot be  null");
			else if(age >100)
				throw new BankAccountException("Age cannot be  greater than 100");
			else if(age < 0)
				throw new BankAccountException("Age cannot be a negative number");
			else if(age >17)
				return true;
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean validateMoileNo(String mobileNo) throws BankAccountException{
		try{
			// TODO Auto-generated method stub
			if(mobileNo == null)
				throw new BankAccountException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid!(Should start  with 6,7,8,9 and length should be 10.....");
			return m.matches();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws BankAccountException {
		// TODO Auto-generated method stub
		if(amount == 0)
			throw new BankAccountException("Null value found");
		String am = String.valueOf(amount);
		if(!am.matches("\\d{1,9}\\.\\d{0,4}"))
			System.out.println("Invalid Amount!(Should be greater than 0");
		return (am.matches("\\d{1,9}\\.\\d{0,4}"));
	}

	@Override
	public boolean validateAccount(String mobileNo) throws BankAccountException {
		// TODO Auto-generated method stub
		return dao.validateAccount(mobileNo);
	}
}
