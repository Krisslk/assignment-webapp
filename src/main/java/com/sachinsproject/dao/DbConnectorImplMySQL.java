package com.sachinsproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySQL implements DbConnector {
	
	@Override
	public Connection getDbConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://172.17.0.3:3306/webapp";
		String userName = "root";
		String password = "g9700981";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}
	
}
