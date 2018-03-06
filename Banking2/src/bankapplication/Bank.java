package bankapplication;

import java.util.ArrayList;

//import BankApp.Account;

public class Bank {
	
	private static ArrayList<Customer> customers1 = new ArrayList<Customer>();
	private static ArrayList<Admin>  a1 = new ArrayList<Admin>();
	private static ArrayList<Account> acc = new ArrayList<Account>();
	private static ArrayList<Transactions> t = new ArrayList<Transactions>();
	private static ArrayList<Employee> empl = new ArrayList<Employee>();
	private static ArrayList<Users> users = new ArrayList<Users>();
	private static ArrayList<LockedUser> lu = new ArrayList<LockedUser>();
	
	
	public static ArrayList<LockedUser> getLu() {
		return lu;
	}
	public static void setLu(ArrayList<LockedUser> lu) {
		Bank.lu = lu;
	}
	public static void addLu(LockedUser x) {
		lu.add(x);
	}
	public static LockedUser getUnapproved(int accountNum) {
		
		for(LockedUser lock: lu) {
			if(lock.getAccount().getAccountNumber()==accountNum) {
				return lock;
				
			}
			
		}
		return null;
		
	}
public static Customer getCuz(int accountNum) {
		
		for(Customer c: customers1) {
			if(c.getAccount().getAccountNumber()==accountNum) {
				return c;
				
			}
			
		}
		return null;
		
	}

	int customerCounter=0;
	

	public static ArrayList<Customer> getCustomers1() {
		return customers1;
	}
	public static ArrayList<Admin> getA1() {
		return a1;
	}
	public static ArrayList<Account> getAcc() {
		return acc;
	}
    public static ArrayList<Transactions> getT() {
		return t;
	}
	public static ArrayList<Employee> getEmpl() {
		return empl;
	}

	public static ArrayList<Users> getUsers() {
		return users;
	}

	public static Account[] getAccounts() {
		return accounts;
	}

	public int getCustomerCounter() {
		return customerCounter;
	}
	public void addCustomer(Customer C ) {
		customers1.add(C); //second picture needs to look like
		
	}

	private static Customer customers[] = new Customer[30]; //bank has multiple customers
	private static Account accounts[] = new Account[30];
	Admin a = new Admin("Admin", "aPassword", 5, "Admin");
	

	 // keep track of customer with acct
	//open account
	
	public double openAccount(int ssn,String name,String password,double openingBalance) {
		
		if(openingBalance >0 ) { //must be above zero to deposit
			
			if(customerCounter < customers.length) {
				customers[customerCounter]= new Customer(); //customer invokes constructor
				customers[customerCounter].getAccount().setBalance(openingBalance); 
				customerCounter ++;
				return customers[customerCounter -1].getAccount().getAccountNumber(); //successful creation of account
			}		
			
		}
		return 0;  // will return if fails to create account
	}
	
	public double getBalance(double accountNumber) {
		for(int i = 0;i < Bank.getCustomers1().size();i++) { 
			if(accountNumber == customers[i].getAccount().getAccountNumber()) {
			
				return customers[i].getAccount().getBalance();
			}
			}
		System.out.println("No Account Found");
		return -1;
		
	}
	
	public Customer getCustomer(double accountNumber) {
		
		for(Customer C : customers) {
			if(C.getAccount().getAccountNumber()== accountNumber) {
				return C;	
			}
		}
		return null;
		
	}
	
	
	
	
}

