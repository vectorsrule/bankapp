package BankApp;

public class RunUserAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserAccess.getStaticMember();
		
		UserAccess userAccess= new UserAccess();
		userAccess.getInstanceMember(); // members accessed using Object
		
		

	}

}
