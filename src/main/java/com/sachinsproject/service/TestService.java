package com.sachinsproject.service;

import java.sql.SQLException;
import java.util.List;

import com.sachinsproject.dao.TestManager;
import com.sachinsproject.model.Test;

public class TestService {

	public List <Test> getAllTests() throws SQLException,ClassNotFoundException  {
		return TestManager.getAllTests();
	}
	
}
