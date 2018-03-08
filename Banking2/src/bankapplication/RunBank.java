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
	

//	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RunBank rb = new RunBank();
		Bank.startBank();

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
				System.out.println("Enter the account number than amount to deposit in next line:");
				int accountNum1 = scanner.nextInt();
				double amount = scanner.nextDouble();
				for (int o = 0; o < Bank.getCustomers1().size(); o++) {
					if (Bank.getCustomers1().get(o).getAccount().getAccountNumber() == accountNum1) {
						boolean depositStatus = Customer.deposit(accountNum1,amount); //make this access a specific user using scanner
						if(depositStatus == true ) { //you will need getters and other methods from the bank to make this access a specific account
							System.out.println("Deposited");
							RunBank rb = new RunBank();
							rb.theMenu();
						}//ask your roommates for help, dont be shy!
						else {
						System.out.println("Fails to deposit");
						RunBank rb = new RunBank();
						rb.theMenu();
						}
						//pass another user from admin, and do deposit TODAYYYYY
					}
				}
				break;
			case 3: 
				System.out.println("Enter account number than amount to withdraw in next line:");
				int accountNum2 = scanner.nextInt();
				double amount2 = scanner.nextDouble();
				for (int o = 0; o < Bank.getCustomers1().size(); o++) {
					if (Bank.getCustomers1().get(o).getAccount().getAccountNumber() == accountNum2) {
						Bank.getCustomers1().get(o);
						boolean withdrawStatus = Customer.withdraw(accountNum2,amount2); //make this access a specific user using scanner
						if(withdrawStatus== true ){ //you will need getters and other methods from the bank to make this access a specific account
							System.out.println("Withdrawn");
							RunBank rb = new RunBank();
							rb.theMenu();
						}//ask your roommates for help, dont be shy! //you will need getters and other methods from the bank to make this access a specific account
						else {
						System.out.println("Fails to withdraw");
						RunBank rb = new RunBank();
						rb.theMenu();
						}
						
					}
				}
				break;
			case 4: 
				System.out.println("Enter account number:");
				int accountNum = scanner.nextInt();
				double balance = Bank.getCuz(accountNum).getAccount().getBalance(); //JAVA NULL POINTER HERE
				if(balance <= 0 )
					System.out.println("Account Number Not Found");
				else
					System.out.println("Balance : " +balance);
				
				break;
			case 5: // make check to make sure person is admin, by user name
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
			System.out.println("Make a select account type please \n");
			String type = scanner.next();
			System.out.println("Please type in your Username");
			String name = scanner.next();
			scanner.nextLine();
			System.out.println("Type in social security number");
			int ssn = scanner.nextInt();//add a regex
			scanner.nextLine();
			System.out.println("Please type in password");
			String password=scanner.next();
			Account ac = new Account();
			
			
			if(ssnCheck(ssn)) {
			LockedUser lu = new LockedUser(name,password,ssn);
			Bank.addLu(lu);
			System.out.println("User added");
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
			theMenu(); //resets menu	
			}
			 else
				System.out.println("User not added");
		 
				
		}
		public boolean ssnCheck(int ssn) {
			
			for(Customer c: Bank.getCustomers1()) {
				System.out.println(c.getSsn()+ " "+ ssn );
				if(c.getSsn() == ssn) {
					
					System.out.println("Give me unique social security number");
					return false;
				}
			}
			return true;
			
			
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
