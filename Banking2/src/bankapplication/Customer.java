package bankapplication;

import java.io.Serializable;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6801120831533554290L;
	private Account account; //customer can have an account
	private String name;
	private String password;
	private int ssn; //distinct
	private String type;
	
	public Customer() {//instantiate
		this.name = "";
		this.password = "";
		this.ssn = 0;
		this.type = "regular"; //locked
	} 
	

	public Customer(String name, String password, int ssn) {
		//super();
		this.account = new Account();
		this.name = name;
		this.password = password;
		this.ssn = ssn;
		this.type="regular";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Account getAccount() {
		return account;
	}
	public static boolean deposit(int accountNumber, double amount) { //deposit feature that points at account number along with how much you'd like to deposit
		boolean status=false;
		if(amount> 0) { // if amount is greater than zero than only you can perform deposit
		for(int i = 0;i < Bank.getCustomers1().size() ;i++) { //for loop to search if the account number is valid.
				if(Bank.getCustomers1().get(i).getAccount().getAccountNumber()==accountNumber) {//searching the counter for only existing accounts
					
					Bank.getCustomers1().get(i).getAccount().setBalance(Bank.getCustomers1().get(i).getAccount().getBalance() +amount);//adds deposit to current amount in account
					status = true;
			
				}
						
		}
		}
		return status;//status = 0 -->invalid amount or invalid account number
					   //status 1 -->deposited
	}
	public static boolean withdraw(int accountNumber, double amount) {
		boolean status=false;
		if(amount> 0 && amount <10000) { // if amount is greater than zero than only you can perform withdraw, cannot withdraw more than 10,000$ at a time
		for(int i = 0;i < Bank.getCustomers1().size() ;i++) { //for loop to search if the account number is valid.
				if(Bank.getCustomers1().get(i).getAccount().getAccountNumber()==accountNumber) {//searching the counter for only existing accounts
					
					Bank.getCustomers1().get(i).getAccount().setBalance(Bank.getCustomers1().get(i).getAccount().getBalance() -amount);//adds deposit to current amount in account
					status = true;
				
				}
						
		}
		}
		return status;//status = 0 -->invalid amount or invalid account number
					   //status 1 -->deposited
		
		
	}

}
