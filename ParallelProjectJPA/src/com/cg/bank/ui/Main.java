package com.cg.bank.ui;

import java.util.Scanner;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;
import com.cg.bank.service.BankService;
import com.cg.bank.service.BankServiceImpl;


public class Main {
	public static void main(String args[]) throws BankException{
		
		BankService service = new BankServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		String name,mobileNo;
		float age;
		double amount;
		int ch = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer;
			switch(ch){
				case 1 :	/*
					 * This case function will accept the parameters and call the service layer method and return the bean
					 * object which is populated by the information of the given customer object in
					 * parameter
					 */						
						do{
							do{
							System.out.println("Enter customer name : ");
							name = sc.next();
							if(service.validateName(name))
								break;
							}while(true);
							
							do{
							System.out.println("Enter mobile no. : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo))
								break;
							}while(true);
							do{
							System.out.println("Enter age : ");
							age = sc.nextFloat();
							if(service.validateAge(age))
								break;
							}while(true);
							do{
							System.out.println("Enter initial amount : ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}while(true);
							if(!service.validateAccount(mobileNo))
								break;
							else
								System.out.println("Account already exists with this number!");
							
						}while(true);
						
						customer = new Customer();
						customer.setName(name);
						customer.setMobileNo(mobileNo);
						customer.setAge(age);
						customer.setInitialBalance(amount);
						service.createAccount(customer);
						System.out.println("Added");
						break;
						
			
					
				case 2 :/*
					 * This case function will accept the parameters and call the service layer method and return the bean
					 * object which is populated by the information of the given mobileNo and amount in
					 * parameter
					 */	
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							System.out.println("Enter the amount you want to deposit");
							amount = sc.nextDouble();
							if(service.validateAccount(mobileNo)){
								if(service.validateMoileNo(mobileNo)){
									if(service.validateAmount(amount)){
										break;
									}
									else{
										System.out.println("Enter a valid amount!");
									}	
								}
								else{
									System.out.println("Enter a valid mobile number!");
									}
							}
							else{
								System.out.println("Account does not exists! Check number!");
							}
							
						}while(true);
						
						service.deposit(mobileNo, amount);		
					
						break;
					
				case 3 :/*
					 * This case function will accept the parameters and call the service layer method and return the bean
					 * object which is populated by the information of the given mobileNo and amount in
					 * parameter
					 */	
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							System.out.println("Enter the amount you want to withdraw : ");
							amount = sc.nextDouble();
							if(service.validateAccount(mobileNo)){
								if(service.validateMoileNo(mobileNo)){
									if(service.validateAmount(amount)){
										break;
									}	
								}
								else{
									System.out.println("Enter a valid mobile number!");
									}
							}
							else{
								System.out.println("Account does not exists! Check number!");
							}
						}while(true);	
					service.withdraw(mobileNo, amount);
						
					break;
				
				case 4 :/*
					 * This case function will accept the parameters and call the service layer method and return the bean
					 * object which is populated by the information of the given mobileNo of sender, receiver  and amount in
					 * parameter
					 */	
						String mobileNoReciever;
						do{
							do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo))
								break;
							}while(true);
							do{
							System.out.println("Enter the amount you want to transfer : ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}while(true);
							do{
							System.out.println("Enter receivers mobile number : ");
							mobileNoReciever = sc.next();
							if(service.validateMoileNo(mobileNoReciever))
								break;
							}while(true);
							if(!mobileNo.equals(mobileNoReciever)){
								if(service.validateAccount(mobileNo)){								
									if(service.validateAccount(mobileNoReciever)){								
										break;
									}
									else{
										System.out.println("Cannot find account linked to: "+mobileNoReciever+ "Check mobile number!");
									}
								}
								else{
									System.out.println("Cannot find account linked to: "+mobileNo +"Check mobile number!");
								}
							}
							else{
								System.out.println("Senders and receivers mobile number cannot be same!");
							}							
						}while(true);
						
					service.fundTransfer(mobileNo, mobileNoReciever, amount);
					
					break;
					
				case 5 :/*
					 * This case function will accept the parameters and call the service layer method and return the bean
					 * object which is populated by the information of the given mobileNo in
					 * parameter
					 */	
						do{
							System.out.println("Enter the moible id to check balance");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)){
								if(service.validateAccount(mobileNo))
									break;
								else
									System.out.println("Cannot find account linked to: "+ mobileNo);
							}
						}while(true);
						
						System.out.println("Current Amount " + service.checkBalance(mobileNo));
						
					break;
					
				case 6 :
						System.out.println("Application terminated");
					break;
					
				default : System.out.println("Invalid input!");
			}
			
		}while(ch != 6);
		sc.close();
		
	}
}
