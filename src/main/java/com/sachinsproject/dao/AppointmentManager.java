package com.sachinsproject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.sachinsproject.model.Appointment;

public class AppointmentManager {

	public static List<Appointment> getAllCustomerAppointmentStatus(String NICNo,String PINCode) throws SQLException, ClassNotFoundException {
	
		DbConnector connector = new DbConnectorImplMySQL();
		Connection conn = connector.getDbConnection();
		
		String query = "select appointments.*,doctors.*,tests.* from customers join appointments on customers.customerID = appointments.customerId join doctors on appointments.doctorId = doctors.doctorId join tests on appointments.testId = tests.testID where customers.NICNo = ? and customers.PINCode = ?";
	
		PreparedStatement ps = conn.prepareStatement(query);
	
		ps.setString(1,NICNo);
		ps.setString(2,PINCode);
		
		ResultSet rs = ps.executeQuery();
		
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		
		while(rs.next()) {
									
			Appointment appointment = new Appointment();
				
			appointment.setAppointmentId(rs.getInt("appointmentID"));
			appointment.setCustomerId(rs.getInt("customerId"));	
			appointment.setTestId (rs.getInt("testId"));
			appointment.setTestName (rs.getString("testName"));
			appointment.setDoctorId (rs.getInt("doctorId"));
			appointment.setDoctorName (rs.getString("doctorName"));
			appointment.setAppointment_datetime(rs.getString("appointmentDate"));
			appointment.setDescription(rs.getString("description"));
			appointment.setStatus(rs.getString("status"));
			
			appointmentsList.add(appointment);
					
		}
		
		
		ps.close();
		conn.close();
	
		
		return appointmentsList;

	}
	
}
