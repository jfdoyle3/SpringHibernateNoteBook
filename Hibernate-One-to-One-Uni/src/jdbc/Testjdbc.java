package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
			String jdbcUrl="jdbc:mysql://192.168.1.201:3306/hb-01-one-to-one-uni?useSSL=false";
			String user="jfdoyle3";
			String pass="F1ipp3r6467";
		
			try {
				System.out.println("Connecting to database: "+jdbcUrl);
				
				Connection myConn= DriverManager.getConnection(jdbcUrl, user, pass);
				
				System.out.println("Connection successful!!!");
				myConn.close();
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
	}

}
