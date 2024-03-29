package com.sachinsproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sachinsproject.model.Appointment;
import com.sachinsproject.model.Doctor;
import com.sachinsproject.model.Login;
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
    	
    	if(action.equals("view-book-appointment")) {
    		showBookAppointmentkPage(request,response);
    	}
    	
    	if(action.equals("view-dashboard-technician")) {
    		
    		showTechnicianDashboard(request,response);
			
    	}
    	
    	
    	if(action.equals("view-test-result-form")) {
    	
    		showResultAddForm(request,response);	
    		
    	}
    	
    	if(action.equals("view-test-report")) {
    		
    		showTestResultReport(request,response);
    	}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("get-appointment-status")) {
			
			getAllCustomerAppointmentStatus(request,response);
			
		}
		
		if(action.equals("book-appointment")) {
			BookCustomerAppointment(request,response);
		}
		
		if(action.equals("add-test-result")) {
			addTestResults(request,response);
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
	
	
	private void BookCustomerAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		Boolean successStatus = false;
		Appointment appointment = new Appointment();
		AppointmentService appointmentServ = new AppointmentService();

		try {
	
			appointment.setNICNo(request.getParameter("NICNo"));
			appointment.setPINCode(request.getParameter("PINCode"));
			appointment.setPatientName(request.getParameter("PatientName"));
			appointment.setPhoneNo(request.getParameter("PhoneNo"));
			appointment.setDescription(request.getParameter("desc"));
			appointment.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
			appointment.setTestId(Integer.parseInt(request.getParameter("testId")));
			appointment.setAppointment_datetime(request.getParameter("appointmentDate"));
			
			Boolean result = appointmentServ.addAppointment(appointment);
			
			if(result) {
				message = "Appointment Added Successfully!";
				successStatus = true;
			}else {
				message = "Unable to Add the appointment, please check your data";
				successStatus = false;
			}
		
			
		} catch (Exception e) {
			
			message = e.getMessage();
			
		}
		
		if(!successStatus) {
			
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
			
			
		}
		
		request.setAttribute("successStatus", successStatus);
		request.setAttribute("message",message);
		
		RequestDispatcher rd = request.getRequestDispatcher("book-appointment.jsp");
		rd.forward(request, response);		
		
	}
	
	
	
	private void showTechnicianDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = new Login();
		
		 HttpSession session = request.getSession(false);
		 login = (Login) session.getAttribute("login");
		 
		 if (session == null||login == null) {
			 
			 response.sendRedirect("/webapp/login");	
			 
		}else {
			
			String message = "";
			AppointmentService appointmentServ = new AppointmentService();
			
			if(login.getUserID()>0) {
				
				try {
					
					List <Appointment> appointmentsList = appointmentServ.getAllAppointments();
					
					request.setAttribute("appointmentsList", appointmentsList);
				
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
					
					message = e.getMessage();
					
				}
				
				
				request.setAttribute("message", message);
				request.setAttribute("username",login.getUsername());
				
				RequestDispatcher rd = request.getRequestDispatcher("technician-dashboard.jsp");
				rd.forward(request, response);	
				
			}else {
				
				 response.sendRedirect("/webapp/login");
				 
			}
			
		}
		
	}
	
	
	private void showResultAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Login login = new Login();
		String appointmentId = request.getParameter("appointmentId");
		String testName = request.getParameter("testName");
		
		 HttpSession session = request.getSession(false);
		 login = (Login) session.getAttribute("login");
		 
		 if (session == null||login == null||appointmentId == null) {
			 
			 response.sendRedirect("/webapp/login");	
			 
		}else {
			
			request.setAttribute("userId",login.getUserID());
			request.setAttribute("appointmentId",appointmentId);
			request.setAttribute("testName", testName);
			
			RequestDispatcher rd = request.getRequestDispatcher("add-test-result-form.jsp");
			rd.forward(request, response);	
			
		}
		
		
	}
	
	
	private void addTestResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		Boolean successStatus = false;
		AppointmentService appointmentServ = new AppointmentService();
		int userId = Integer.parseInt(request.getParameter("userId"));
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		String resultInpt = request.getParameter("result");
		String testName = request.getParameter("testName");
		
		try {
			
			successStatus = appointmentServ.addTestResult(userId,appointmentId,resultInpt);
			
			if(successStatus) {
				response.sendRedirect("/webapp/appointments?action=view-dashboard-technician");
			}else {
				message = "something unexpected happen, please check your data";
				request.setAttribute("message",message);
			}
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		if(!successStatus) {
			
			request.setAttribute("userId",userId);
			request.setAttribute("appointmentId",appointmentId);
			request.setAttribute("testName", testName);
			
			RequestDispatcher rd = request.getRequestDispatcher("add-test-result-form.jsp");
			rd.forward(request, response);	
		}
		
		
	}
	
	private void showTestResultReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		String message = "";
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		AppointmentService appointmentServ = new AppointmentService();
		Appointment appointment = new Appointment();
		
		try {
			appointment = appointmentServ.getAppointmentDetails(appointmentId);
			request.setAttribute("appointment",appointment);
			RequestDispatcher rd = request.getRequestDispatcher("test-results.jsp");
			rd.forward(request, response);	
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
	
	}
	
	
	
}
