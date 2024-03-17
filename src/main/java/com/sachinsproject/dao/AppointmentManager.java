package com.sachinsproject.dao;

import java.sql.Connection;
import java.sql.Date;
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
	
	public static boolean addAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection conn = connector.getDbConnection();
		
		int status = 0;
		String query2 = "INSERT INTO customers (patientName, NICNo, PINCode, phoneNo) VALUES (?,?,?,?);";
		
		ResultSet rs1 = getCustomerFromDBUsingNIC(conn, appointment);
		
		if(rs1.next()) {
			// there is a record for this customer, just add the appointment table
			
			Integer customerID = Integer.parseInt(rs1.getString("customerID"));
			
			status = insertAppointmentToDB(conn,customerID,appointment);
				
		}else {
			
			 PreparedStatement ps2 = conn.prepareStatement(query2);
			 ps2.setString(1,appointment.getPatientName());
			 ps2.setString(2, appointment.getNICNo());
			 ps2.setString(3,appointment.getPINCode());
			 ps2.setString(4,appointment.getPhoneNo());
			 
			 ps2.executeUpdate();
			 
			 ResultSet rs2 = getCustomerFromDBUsingNIC(conn,appointment);
			 
			 if(rs2.next()) {
				 
				 Integer customerID = Integer.parseInt(rs2.getString("customerID"));
				 
				 status = insertAppointmentToDB(conn,customerID,appointment);
				 
				 
			 }
			
		}
		

		conn.close();
		
		return status>0;
		
	}
	
	
	private static ResultSet getCustomerFromDBUsingNIC(Connection conn,Appointment appointment) {
		
		String query = "select * from customers where NICNo = ?";
		ResultSet rs = null;
		
		try {
			
			PreparedStatement ps1 = conn.prepareStatement(query);
			ps1.setString(1,appointment.getNICNo());
			rs = ps1.executeQuery();
			return rs;
			
		} catch (Exception e) {
			
			return rs;
		}
		
		
	}
	
	private static int insertAppointmentToDB(Connection conn,Integer customerID,Appointment appointment) {
		
		String query = "INSERT INTO appointments (customerId, testId, doctorId, appointmentDate, description, status) VALUES (?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps3 = conn.prepareStatement(query);
			ps3.setInt(1,customerID);
			ps3.setInt(2,appointment.getTestId());
			ps3.setInt(3, appointment.getDoctorId());
			ps3.setString(4,appointment.getAppointment_datetime());
			ps3.setString(5,appointment.getDescription());
			ps3.setString(6,"Scheduled");
			
			return ps3.executeUpdate();
			
		} catch (Exception e) {
			return 0;
		}
		
		
		
	}
	
}
