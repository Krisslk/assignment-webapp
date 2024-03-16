package com.sachinsproject.service;

import com.sachinsproject.dao.AppointmentManager;
import com.sachinsproject.model.Appointment;

import java.util.*;

public class AppointmentService {

	public List <Appointment> getAllCustomerAppointmentStatus(String NICNo,String PINCode) {
		return AppointmentManager.getAllCustomerAppointmentStatus(NICNo,PINCode);
	}
	
}
