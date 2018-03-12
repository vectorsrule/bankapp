package bankapplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory(){
		
		
		
	}
	
	public static synchronized ConnectionFactory getInstance(){
		
		if (cf==null){
			
			cf = new ConnectionFactory();
			
		}
		
		return cf;
		
	}
	
	public Connection getConnection(){
		
		Connection conn = null;
		
		try {
			System.out.println("Successful connection....");
			Properties prop = new Properties();
			prop.load(new FileReader("C:\\Users\\PETER\\Desktop\\BankingAppFinal\\bankapp\\Banking2\\src\\main\\resources\\database.properties"));
			//Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("psw"));
		} catch (SQLException e) {
			System.out.println("SQL not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		
		return conn;
		
	}

}
