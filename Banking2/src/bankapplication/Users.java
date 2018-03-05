package bankapplication;

public class Users extends Customer {
	
	private Account account; //customer can have an account
	private String name;
	private String password; // last name CHANGE IT
	private int ssn;   //fields
	private String type;
	
	
	
	public Users() {
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


	public Users(String name, String password, int ssn) {
		super();
		this.name = name;
		this.password = password;
		this.ssn = ssn;
		this.type = "locked";
	}
	
	
	
	

}


