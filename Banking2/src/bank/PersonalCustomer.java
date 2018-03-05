package bank;

public class PersonalCustomer extends Customer {
	
	
	private String homePhone;
	private String workPhone;
	
	public PersonalCustomer(String name) {
		
		super(name);
		
		
	}
	
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setId(double id) {
		this.id = id;
	}

}
