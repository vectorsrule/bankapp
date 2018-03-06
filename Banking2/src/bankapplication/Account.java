package bankapplication;

public class Account {

	//long represents integers group and memory and memory size is 8 bytes
private int accountNumber;
private double balance;
static private long accountNumberGenerator = 1000;  //since static it'll produce new value everytime account is created

//instance members are created every time object is made, gets initialized back to 1000, and reincrements gives 1001
//static members are generated only once, although you create n objects, meaning they wont get initialized back to 1000, so on every increment they produce a new value

//method with the same name is the constructor 
//object is invoked when constructor is present, no call needed
//it would execute by call if turned into a method
public Account() {
	accountNumber = (int) ++accountNumberGenerator;
	this.balance = 0;
	
}


public Account(double balance) { // they enter a balance at the beginning and that is their
	super();
	this.balance = balance;
	accountNumber = (int) ++accountNumberGenerator;
}


public int getAccountNumber() {
	return accountNumber;
}

public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

//public double getBalance(double accountNumber) {
//	for(int i = 0;i < Bank.getCustomers1().size();i++) { 
//		if(accountNumber == customers[i].getAccount().getAccountNumber()) {
//		
//			return customers[i].getAccount().getBalance();
//		}
//		}
//	System.out.println("No Account Found");
//	return -1;
//	
//}

}
