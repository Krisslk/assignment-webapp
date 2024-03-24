package com.sachinsproject.service;

import com.sachinsproject.dao.AppointmentManager;
import com.sachinsproject.model.Appointment;

import java.sql.SQLException;
import java.util.*;

public class AppointmentService {

	public List <Appointment> getAllCustomerAppointmentStatus(String NICNo,String PINCode) throws SQLException,ClassNotFoundException  {
		return AppointmentManager.getAllCustomerAppointmentStatus(NICNo,PINCode);
	}
	
	public Appointment getAppointmentDetails(int appointmentId) throws SQLException,ClassNotFoundException  {
		return AppointmentManager.getAppointmentDetails(appointmentId);
	}
	
	public List <Appointment> getAllAppointments() throws SQLException,ClassNotFoundException  {
		return AppointmentManager.getAllAppointments();
	}
	
	public Boolean addAppointment(Appointment appointment) throws SQLException,ClassNotFoundException  {
		return AppointmentManager.addAppointment(appointment);
	}
	
	public Boolean addTestResult(int userId,int appointmentId,String result) throws SQLException,ClassNotFoundException  {
		return AppointmentManager.addTestResult(userId, appointmentId, result);
	}
	
}
