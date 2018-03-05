package BankApp;

public class UserAccessWithin {
	
	public void getInstanceMember() {
		System.out.println("Instance Member ");
		
	}
	public static void getStaticMember() {
		System.out.println("Static Member ");
		
		
	}
	
	public static void main(String args[]) {
		
		UserAccessWithin userAccess = new UserAccessWithin();
		userAccess.getInstanceMember(); //main being static can access non static with object
		
		getStaticMember();
		
		
	}

}
