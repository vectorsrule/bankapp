package bankapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class AccountDaoImpl implements AccountDao {

	public void createAccountDB(Account account) {
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "INSERT INTO ACCOUNTA (accountNumber, accountBalance) VALUES('"+account.getAccountNumber()+"', '"+account.getBalance()+"')";
			
			int rowsAffected = statement.executeUpdate(sql);
			
			System.out.println("Rows updated " + rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public Account retrieveAccountDB(Account account) {
Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "SELECT * FROM ACCOUNTA (accountNumber, accountBalance) WHERE('"+account.getAccountNumber()+"', '"+account.getBalance()+"')";
			
			int rowsAffected = statement.executeUpdate(sql);
			
			System.out.println("Rows updated " + rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	
	@Override
	public ArrayList<Account> retrieveAccountDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccountDB(Account account) {
Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "UPDATE ACCOUNTA SET (accountNumber, accountBalance) "
			+ "WHERE(accountNumber = '"+account.getAccountNumber()+"', AND accountBalance = '"+account.getBalance()+"')";
			
			int rowsAffected = statement.executeUpdate(sql);
			
			System.out.println("Rows updated " + rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccountDB(Account account) {
Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "DELETE FROM ACCOUNTA(accountNumber, accountBalance) "
			+ "WHERE(accountNumber = '"+account.getAccountNumber()+"', AND accountBalance = '"+account.getBalance()+"')";
			
			int rowsAffected = statement.executeUpdate(sql);
			
			System.out.println("Rows updated " + rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}


	

