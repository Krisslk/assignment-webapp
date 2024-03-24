package com.sachinsproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sachinsproject.model.Test;

public class TestManager {

public static List<Test> getAllTests() throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection conn = connector.getDbConnection();
		
		String query = "select * from tests";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<Test> testsList = new ArrayList<Test>();
		
		while(rs.next()) {
			
			Test test = new Test();
		
			test.setTestId(rs.getInt("testID"));
			test.setTestName(rs.getString("testName"));
			
			testsList.add(test);
		}
		
		
		return testsList;
		
		
	}
	
}
