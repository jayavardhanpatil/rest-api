package com.rest.registerpage.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlConnection {

	Statement stmnt;
	ResultSet result;
	public static Connection connection;
	public Connection dbconnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Patil");
		return connection;
	}
	
	
	public boolean CreateProfiletable() throws ClassNotFoundException, SQLException{

		try {
			stmnt = connection.createStatement();
			String query = "CREATE TABLE IF NOT EXISTS users(id INT(11) NOT NULL AUTO_INCREMENT,"
					+ " username VARCHAR(16) NOT NULL,"
					+ " email VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (id),"
					+ " UNIQUE KEY username (username,email)";
			stmnt.executeUpdate(query);
			return true;
		}catch (SQLException e){
        	e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return false;
	}
	
	public ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException{
		
		try {
			stmnt = connection.createStatement();
			result = stmnt.executeQuery(query);
			
		}catch (SQLException e){
        	e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return result;
	}

}
