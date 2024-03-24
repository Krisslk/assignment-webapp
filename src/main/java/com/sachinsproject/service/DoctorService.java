package com.sachinsproject.service;

import java.sql.SQLException;
import java.util.List;

import com.sachinsproject.dao.DoctorManager;
import com.sachinsproject.model.Doctor;


public class DoctorService {

	public List <Doctor> getAllDoctors() throws SQLException,ClassNotFoundException  {
		return DoctorManager.getAllDoctors();
	}
	
}
