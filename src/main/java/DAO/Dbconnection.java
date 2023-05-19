package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	public static Connection getConnection()  {
		String dbuser = "root";
		String dbpassword = "";
		String dblocal  = "jdbc:mysql://localhost:3306/mymagic";
		Connection connection = null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dblocal, dbuser, dbpassword);
			System.out.println("Conexão concluída! ");
		}catch(SQLException error) {
			error.printStackTrace();
			System.out.println("Sem conexão com banco! ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	

}
