package com.sachinsproject.dao;

import java.sql.*;

public interface DbConnector {

	Connection getDbConnection() throws ClassNotFoundException, SQLException;
	
}
