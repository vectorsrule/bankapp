package bankapplication;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankApp;

public interface AccountDao {
	
	public void createAccountDB(Account account);
	
	public Account retrieveAccountDB(Account account);
	
	public ArrayList<Account> retrieveAccountDB();
	
	public void updateAccountDB(Account account);
	
	public void deleteAccountDB(Account account);
	

}
