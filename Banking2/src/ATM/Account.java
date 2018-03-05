package ATM;

import java.util.ArrayList;

public class Account {
	
	private String name; //account name
	
	private double balance; //current balance
	
	private String uuid; //acount ID #
	
	private User holder; //user object that owns this account
	
	private ArrayList<Transaction> transactions;

}
