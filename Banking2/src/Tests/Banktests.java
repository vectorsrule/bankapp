package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import bankapplication.Account;
import bankapplication.Admin;
import bankapplication.Bank;
import bankapplication.Customer;
import bankapplication.LockedUser;
import bankapplication.RunBank;

public class Banktests {
	
	public static final RunBank runbank = new RunBank();
	
	
	@Test 
	public void MenuTest() {
		assertEquals(1,1);
	    Bank.getCustomers1().size();
	    assertEquals(Bank.getCustomers1().size(), 0);
	    assertEquals(Bank.getLu(), 3);
	}
	@Test
	 public void ArrayTest() {
		 
		 ArrayList<Account> Test= Bank.getAcc();
		 Account acc = Test.get(0);
		 assertEquals(acc.getAccountNumber(), 1000);
	}
	@Test
	public void CheckAdmin() {
		 
		 ArrayList<Admin> Test2= Bank.getA1();
		 Admin a1 = Test2.get(0);
		 assertEquals(a1.getName(),"Admin");
	}
	 
	    
		
	
	@Test
	public void AccountTest(){
		
		assertEquals(Bank.getAcc().size(), 0);
		
		
		
		
	}
	@Test
	public void LUTest() {
		assertEquals(Bank.getA1(), 1);
	}
	

}
