package Corso_Java.PrimoProgetto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connessione {
	
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/PrimoProgettoDB";
	static final String USER="root";
	static final String PASSWORD="root";
	
	
	private static Connection conn=null;
	
	static {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println(conn);
		
		} catch (ClassNotFoundException e) {
			System.out.println("Errore nei driver "+ e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("Connessione non avvenuta! "+ e.getMessage());
		}
	}
	
	public static Connection getConnection()
	{
		return conn;
	}
	
	
	private Connessione()
	{
		
	}
	
	

}
