package net.codejava;

import java.sql.*;

public class RetriveData {
	
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/employeedb";
		String username = "root";
		String password = "root";
		 
		try(Connection conn = DriverManager.getConnection(dbURL, username, password)) {
		 
			String sql = "SELECT * FROM employee";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			 
			int count = 0;
			 
			while (result.next()){
				int empid=result.getInt(1);
			    String name = result.getString(2);
			    String address = result.getString(3);
			    
			 
			    String output = "employee #%d:%d: %s - %s";
			    System.out.println(String.format(output, ++count,empid, name, address));
			}
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

	}

}
