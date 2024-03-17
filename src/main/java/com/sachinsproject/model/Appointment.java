package com.sachinsproject.model;

public class Appointment {
	
	private int appointmentId;
	private String NICNo;
	private String PINCode;
	private String PatientName;
	private String PhoneNo;
	private int CustomerId;
	private int testId;
	private String testName;
	private int doctorId;
	private String doctorName;
	private String appointment_datetime;
	private String description;
	private String status;
	
	public Appointment() {
		
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getNICNo() {
		return NICNo;
	}

	public void setNICNo(String nICNo) {
		NICNo = nICNo;
	}

	public String getPINCode() {
		return PINCode;
	}

	public void setPINCode(String pINCode) {
		PINCode = pINCode;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
