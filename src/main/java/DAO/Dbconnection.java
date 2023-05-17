package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	public static Connection getConnection() {
		String dbuser = "root";
		String dbpassword = "";
		String dblocal  = "jdbc:mysql://localhost:3306/mymagic";
		
		try {
			Connection connection = null;
			connection = DriverManager.getConnection(dblocal, dbuser, dbpassword);
			System.out.println("Conexão concluída! ");
		}catch(SQLException error) {
			error.printStackTrace();
			System.out.println("Sem conexão com banco! ");
		}
		
		return null;
		
	}
	

}
