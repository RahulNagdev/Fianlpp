package com.cg.bam.ui;

import java.util.Scanner;

import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountServiceImpl;
//Main Method
public class Main {
	public static void main(String args[]) throws BankAccountException{
		//Service Object
		BankAccountServiceImpl service = new BankAccountServiceImpl();
		
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
				case 1 ://Add Customer
					
						do{//getting user details
							do{
							System.out.println("Enter customer name : ");
							name = sc.next();
							if(service.validateName(name))
								break;
							
							}while(true);
							do{System.out.println("Enter mobile no. : ");
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
							if(service.validateAccount(mobileNo)){
									System.out.println("Mobile No Already Exists");
								}else{
								break;
							}
							
						}while(true);
						
						customer = new Customer();
						
						customer.setName(name);
						customer.setMobileNo(mobileNo);
						customer.setAge(age);
						customer.setInitialBalance(amount);
						
						service.createAccount(customer);						
						System.out.println("New Customer Added");
											break;
						
				case 2 ://Deposit
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter the amount you want to deposit");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo)&& service.validateAmount(amount)){
								if(service.validateAccount(mobileNo))
									break;
							}
						}while(true);
						
						service.deposit(mobileNo, amount);						
					
					break;
					
				case 3 ://Withdraw
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter the amount you want to withdraw : ");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){
								if(service.validateAccount(mobileNo))
									break;
							}
						}while(true);
						
						service.withdraw(mobileNo, amount);
						
					break;
				
				case 4 ://Fund Transfer
						String mobileNoReciever;
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter the amount you want to transfer : ");
							amount = sc.nextDouble();
							
							System.out.println("Enter receivers mobile number : ");
							mobileNoReciever = sc.next();
							if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
								if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
									if(!mobileNo.equals(mobileNoReciever))
										break;
									else{
										System.out.println("Mobile No's cannot be Same");
									}
							}
						}while(true);
					service.fundTransfer(mobileNo, mobileNoReciever, amount);
					
					break;
					
				case 5 ://Balance Enquiry
						do{
							System.out.println("Enter the moible id to check balance");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)&&service.validateAccount(mobileNo))
								break;
						}while(true);
						
						System.out.println("Current Amount "+service.checkBalance(mobileNo));
						
					break;
					
				case 6 ://Exit
						System.out.println("Have a nice day..........");
					break;
				default : System.out.println("Invalid input!");
			}
			
		}while(ch != 6);
		
	}
}
