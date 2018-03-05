package bankp;

public class EmployeeCustomer extends Customer {
	
	private String contactPerson;
	private String contactOfficePhone; 
	
	public EmployeeCustomer(String name) {
		super(name);
		
		
	}
	

	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactOfficePhone() {
		return contactOfficePhone;
	}
	public void setContactOfficePhone(String contactOfficePhone) {
		this.contactOfficePhone = contactOfficePhone;
	}
	

}
