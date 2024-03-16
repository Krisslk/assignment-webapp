package com.sachinsproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sachinsproject.model.Doctor;

public class DoctorManager {

	public static List<Doctor> getAllDoctors() throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection conn = connector.getDbConnection();
		
		String query = "select * from doctors";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<Doctor> doctorsList = new ArrayList<Doctor>();
		
		while(rs.next()) {
			
			Doctor doctor = new Doctor();
		
			doctor.setDoctorId(rs.getInt("doctorID"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setPhoneNo(rs.getString("phoneNo"));
			doctor.setMedicalId(rs.getInt("medicalId"));
			doctorsList.add(doctor);
		}
		
		
		return doctorsList;
		
		
	}
	
}
