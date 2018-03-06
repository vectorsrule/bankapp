package bankapplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import bankapplication.Admin;

public class RunBank {
	/**
	 * Things to do
	 * Scanner sc = new Scanner();
	 * Sysout please enter your name
	 * String s = scan.next();
	 * @param args
	 */
	Scanner scanner = new Scanner(System.in);
	static Bank b= new Bank();

//	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RunBank rb = new RunBank();
			System.out.println("1. Open an Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Check Balance");
			System.out.println("5. Admin Login");
			System.out.println("6. Employee Login");
			System.out.println("7. exit");
			rb.theMenu();
	}
	public void theMenu( ) {
			System.out.println("Enter Option : ");
			int option =  scanner.nextInt();
			
			switch(option) {
			
			case 1: 
				createAccount(); 
			//	System.out.println("Enter amount to open account:");
//				double accountNumber =b.openAccount(scanner.nextDouble());
//				if(accountNumber!=0)
//					System.out.println("Here is you account number: " +accountNumber);
//				else
//					System.out.println("Fail to create account for user");
//				
				break;
			case 2:
				System.out.println("Enter account number than  the amount in next line:");
				int choice = scanner.nextInt();
				for (int o = 0; o < Bank.getCustomers1().size(); o++) {
					if (Bank.getCustomers1().get(o).getAccount().getAccountNumber() == choice) {
						Bank.getCustomers1().get(o);
						boolean depositStatus = Customer.deposit(scanner.nextInt(),scanner.nextDouble()); //make this access a specific user using scanner
						if(depositStatus!= false ) //you will need getters and other methods from the bank to make this access a specific account
							System.out.println("Deposited"); //ask your roommates for help, dont be shy!
						else
							System.out.println("Fails to deposit");
					}
				}
				break;
			case 3: 
				System.out.println("Enter account number than  the amount in next line:");
				int choice2 = scanner.nextInt();
				for (int o = 0; o < Bank.getCustomers1().size(); o++) {
					if (Bank.getCustomers1().get(o).getAccount().getAccountNumber() == choice2) {
						Bank.getCustomers1().get(o);
						boolean withdrawStatus = Customer.deposit(scanner.nextInt(),scanner.nextDouble()); //make this access a specific user using scanner
						if(withdrawStatus!= false ) //you will need getters and other methods from the bank to make this access a specific account
							System.out.println("Withdrawn"); //ask your roommates for help, dont be shy!
						else
							System.out.println("Fails to withdraw");
					}
				}
				break;
			case 4: 
				System.out.println("Enter account number:");
				int accountNum = scanner.nextInt();
				double balance = Bank.getCuz(accountNum).getAccount().getBalance();
				if(balance == -1 )
					System.out.println("Account Number Not Found");
				else
					System.out.println("Balance : " +balance);
				
				break;
			case 5: 
				System.out.println("Admin login");
				Admin a = new Admin();
				a.adminMenu(); //added type cast to int/switched accounts to accountNumbers??
				break;
			case 6: System.exit(0);
				
			default: System.out.println("Invalid Option !!");
			}
			
		}


	
		// TODO Auto-generated method stub
		public void createAccount() {
			System.out.println("Make a new account please \n");
			System.out.println("Please type in your UsernameName");
			String name = scanner.next();
			System.out.println("Type in social security number");
			int ssn = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please type in password");
			String password=scanner.nextLine();
			
			
			if(ssnCheck(ssn)) {
			LockedUser lu = new LockedUser(name,password,ssn);
			Bank.addLu(lu);
			
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lockedUsers.dat"))){
				
				//System.out.println("Done");
				oos.writeObject(lu);
				System.out.println("Done");
				System.out.println(lu);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lockedUsers.dat"))){
				
				LockedUser locker = (LockedUser) ois.readObject();
				
				System.out.println("Found: " + locker);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	Bank.getBank().getspecificCustomer().getAccount().setBalance(); for deposit and wthdraw
		//Bank.getBank().addLu();   going to add to the array of locked users, serilialized.
			// checking to make sure all information is correct. Validation checks.
				
			}
		 
				
		}
		public boolean ssnCheck(int ssn) {
			
			for(Customer c: Bank.getCustomers1()) {
				if(c.getSsn() == ssn) {
					System.out.println("Give me unique social security number");
					return true;
				}
			}
			return false;
			
			
		}
		
		// Need to return back to menu after file serialized.
	/*	public LockedUser(String name, String password, int ssn) {
			super();
			this.name = name;
			this.password = password;
			this.ssn = ssn;
			this.type = "locked";
		}*/

}
