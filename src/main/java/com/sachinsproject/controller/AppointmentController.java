package com.sachinsproject.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sachinsproject.model.Appointment;
import com.sachinsproject.model.Doctor;
import com.sachinsproject.model.Test;
import com.sachinsproject.service.AppointmentService;
import com.sachinsproject.service.DoctorService;
import com.sachinsproject.service.TestService;


public class AppointmentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getParameter("action");
    	
    	if(action.equals("view-appointment-status")) {
    		showAppointmentStatusCheckPage(request, response);
    	}
    	
    	if(action.equals("book-appointment")) {
    		showBookAppointmentkPage(request,response);
    	}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("get-appointment-status")) {
			
			getAllCustomerAppointmentStatus(request,response);
			
		}
	}
	
	
	
	private void showAppointmentStatusCheckPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		RequestDispatcher rd = request.getRequestDispatcher("check-appointment-status.jsp");
		rd.forward(request, response);
		
	}
	
	private void showBookAppointmentkPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		
		DoctorService docService = new DoctorService();
		TestService testService = new TestService();
		
		try {
			
			List <Doctor> doctorsList = docService.getAllDoctors();
			List <Test> testsList = testService.getAllTests();
			
			request.setAttribute("doctorsList", doctorsList);
			request.setAttribute("testsList", testsList);
			
		} catch (Exception e) {
			
			message = e.getMessage();
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("book-appointment.jsp");
		rd.forward(request, response);
		
	}
	
	private void getAllCustomerAppointmentStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		AppointmentService appointmentServ = new AppointmentService();
		
		try {
			
			String NICNo = request.getParameter("NICNo");
			String PINCode = request.getParameter("PINCode");
			
			List <Appointment> appointmentsList = appointmentServ.getAllCustomerAppointmentStatus(NICNo,PINCode);

			request.setAttribute("appointmentsList", appointmentsList);
			
		} catch (Exception e) {
			
			message = e.getMessage();
			
		}
		
		request.setAttribute("message",message);
		
		RequestDispatcher rd = request.getRequestDispatcher("check-appointment-status.jsp?actions=view-appointment-status");
		rd.forward(request, response);		
		
	}
	
	
	
}
