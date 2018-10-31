package com.cg.bank.test;

import junit.framework.Assert;

import org.junit.Test;

import com.cg.bank.exception.BankException;
import com.cg.bank.service.BankService;
import com.cg.bank.service.BankServiceImpl;

public class TestClass {
	//TestClass cases for name
		@Test(expected=BankException.class)
	    public void test_ValidateName_null() throws BankException{
	        BankService service=new BankServiceImpl();
	        service.validateName(null);
	    }
	    
	    @Test
	    public void test_validateName_v1() throws BankException{
	    
	        String name="Aete121";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateName(name);
	        Assert.assertEquals(false,result);
	    }
	    @Test
	    public void test_validateName_v2() throws BankException{
	    
	        String name="Amita";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateName(name);
	        Assert.assertEquals(true,result);
	    }
	    @Test
	    public void test_validateName_v3() throws BankException{
	    
	        String name="amita";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateName(name);
	        Assert.assertEquals(false,result);
	    }
	    
	    //TestClass cases for Mobile number
	    @Test(expected=BankException.class)
	    public void test_ValidateMobNo_null() throws BankException{
	        BankService service=new BankServiceImpl();
	        service.validateMoileNo(null);
	    }
	    
	    @Test
	    public void test_validateMobNo_v1() throws BankException{
	        String mobNo="ABCD91828288";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateMoileNo(mobNo);
	        Assert.assertEquals(false,result);
	    }
	    @Test
	    public void test_validateMobNo_v2() throws BankException{
	    
	        String mobNo="9922974725";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateMoileNo(mobNo);
	        Assert.assertEquals(true,result);
	    }
	    @Test
	    public void test_validateMobNo_v3() throws BankException{
	    
	        String mobNo="992297";
	        BankService service=new BankServiceImpl();
	        boolean result= service.validateMoileNo(mobNo);
	        Assert.assertEquals(false,result);
	    }

}
