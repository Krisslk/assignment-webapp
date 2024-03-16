package com.sachinsproject.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sachinsproject.model.Appointment;
import com.sachinsproject.service.AppointmentService;


public class AppointmentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getParameter("action");
    	
    	if(action.equals("view-appointment-status")) {
    		showAppointmentStatusCheckPage(request, response);
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
	
	private void getAllCustomerAppointmentStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		AppointmentService appointmentServ = new AppointmentService();
		
		try {
			
			String NICNo = request.getParameter("NICNo");
			String PINCode = request.getParameter("PINCode");
			
			List <Appointment> appointments = appointmentServ.getAllCustomerAppointmentStatus(NICNo,PINCode);
			
			System.out.println(appointments);
			
		} catch (Exception e) {
			
			System.out.println("iwariiiiiiiiiiiii");
			
		}
		
		
	}
	
	
	
}
