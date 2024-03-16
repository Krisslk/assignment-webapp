package com.sachinsproject.model;

public class Appointment {
	
	private int appointmentId;
	private int userId;
	private String appointment_datetime;
	private String description;
	
	public Appointment() {
		
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAppointment_datetime() {
		return appointment_datetime;
	}

	public void setAppointment_datetime(String appointment_datetime) {
		this.appointment_datetime = appointment_datetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
