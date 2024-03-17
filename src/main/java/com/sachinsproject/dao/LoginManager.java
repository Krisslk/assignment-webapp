package com.sachinsproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sachinsproject.model.Login;
import com.sachinsproject.model.Test;

public class LoginManager {

	public static Login tryTechnicianLogin(String username,String password) throws SQLException, ClassNotFoundException {
		
		Login loginObj = new Login();
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection conn = connector.getDbConnection();
		
		String query = "select * from users where username = ? and password = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		
			loginObj.setUserID(rs.getInt("userID"));
			loginObj.setUsername(rs.getString("username"));
			loginObj.setUserType(rs.getString("userType"));
		
		}
		
		return loginObj;
		
	}
	
}
