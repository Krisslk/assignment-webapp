package com.sachinsproject.service;

import java.sql.SQLException;

import com.sachinsproject.dao.LoginManager;
import com.sachinsproject.model.Login;


public class LoginService {

	public Login tryTechnicianLogin(String username,String password) throws SQLException,ClassNotFoundException  {
		return LoginManager.tryTechnicianLogin(username, password);
	}
	
}
