package com.revature.driver;

import com.revature.pojo.BankApp;

import bankapplication.AccountDaoImpl;
import bankapplication.AccountDao;

public class Driver {

	public static void main(String[] args) {
		
		//ConnectionFactory.getInstance().getConnection();
		
		BankApp myCard = new BankApp(0, "Is this working", "It better");
		
		AccountDao fcd = new AccountDaoImpl();
		
		fcd.createFlashCard(myCard);
		
		System.out.println(fcd.retrieveFlashCardById(121));
		
		System.out.println("everything fine");

	}

}
