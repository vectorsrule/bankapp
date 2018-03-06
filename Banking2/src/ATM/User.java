package ATM;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	/*
	 * First name
	 */
	
	private String firstName;
	/*
	 * Last Name name
	 */
	
	private String lastName;
	/*
	 * ID
	 */
	
	private String uuid;
	/*
	 * MD5 hash of user pin
	 */
	
	private byte pinHash[];
	/*
	 * list of accounts
	 */
	
	private ArrayList<Account> accounts;
	
	public User(String firstName, String lastName, String pin, Bank theBank) {
		//set users name
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		//store the pins md5 hash 
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		this.uuid = theBank.getNewUserUUID();
		
		this.accounts = new ArrayList<Account>();
		
		//System.out.printlnf();
		
	}

}
