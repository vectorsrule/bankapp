package bankapplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Employee extends Customer {
	private Account account; //customer can have an account
	private String name;
	private String password; // last name CHANGE IT
	private int ssn;   //fields
	private String type;
	transient Scanner scanner = new Scanner(System.in);
	
	
	
	public Employee() {
		super();
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Employee(String name, String password, int ssn) {
		super();
		this.name = name;
		this.password = password;
		this.ssn = ssn;
		this.type = "employee";
	}
	protected boolean approvedAccount(Account account ){
		System.out.println("Enter the account number of the user you want to approve");
		int decision = scanner.nextInt();
		boolean check = false;
		for(int i = 0; i < Bank.getLu().size(); i++) {
			if(Bank.getLu().get(i).getAccount().getAccountNumber() == decision) {
				Customer c = new Customer(Bank.getLu().get(i).getName(), Bank.getLu().get(i).getPassword(),Bank.getLu().get(i).getSsn());
//( String name, String password, int ssn)
				Bank.getCustomers1().add(c);
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notLockedUsers.dat"))){
					
					oos.writeObject(c);
					System.out.println("Done");
					System.out.println(c);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notLockedUser.dat"))){
					
					Customer notLocked = (Customer) ois.readObject();
					
					System.out.println("Found: " + notLocked );
					
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
				check = true;
				return check;
		}
			
			
		}
		return check;
	}
	protected boolean lockingAccount(int accountNumber){
		System.out.println("Enter the account number of the user you want to lock-in");
		String decision = scanner.nextLine();
		boolean check = false;
		RunBank rb = new RunBank();
		for(int i = 0; i < rb.b.getCustomers1().size(); i++) {
			if(rb.b.getCustomers1().get(i).getAccount().getAccountNumber() == accountNumber) {
				LockedUser lu = new LockedUser(rb.b.getCustomers1().get(i).getName(), rb.b.getCustomers1().get(i).getPassword(),rb.b.getCustomers1().get(i).getSsn());
//						( String name, String password, int ssn)
				rb.b.getLu().add(lu);
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notLockedUsers.dat"))){
					
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
				
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notLockedUser.dat"))){
					
					Customer notLocked = (Customer) ois.readObject();
					
					System.out.println("Found: " + notLocked );
					
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
				return check;
		}
			
			
		}
		return check;
	}
	
	public void adminMenu(){
		
		for(Customer c: Bank.getCustomers1()) {
			System.out.println(c.getName()+"\n"+c.getPassword()+"\n"+c.getSsn());
			//gets access to everything in customers
			
		}
		System.out.println("1. Approve: ");
		System.out.println("2. Check Customer Accounts");
		System.out.println("3. Remove Account");
		System.out.println("4. Exit");
		int choice=scanner.nextInt();
		
		System.out.println("Enter the account number of choice");
		
		int aN = scanner.nextInt();
		
		switch(choice) {
		
		case 1 : approvedAccount(Bank.getUnapproved(aN).getAccount());
		break;
		
		case 2: 
			for(Customer c: Bank.getCustomers1()) {
				System.out.print(c.getAccount().getAccountNumber()+"\n"+c.getAccount().getBalance());
			}
			break;
			
		case 3: 
			lockingAccount( Bank.getCuz(aN).getAccount().getAccountNumber());
			break;
		case 4:
			RunBank.main(null);
			
		}
		
		//disply admin stuff
		
	}
	
	
	
	
}

	
	
	
	



