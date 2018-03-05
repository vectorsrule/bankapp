package BankApp;

public class Overload {
	
	public void sayHello() {
		System.out.println("Hello Everyone");
	}
	
	public void sayHello(String name) {
		System.out.println("Hello " +name);
	}
	public void sayHello(int name) {
		System.out.println("Hello " +name);
	}
//overload template, more than one method same name with difference in parameters(number or data type)
}
