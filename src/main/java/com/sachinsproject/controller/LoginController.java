package com.sachinsproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sachinsproject.model.Login;
import com.sachinsproject.service.LoginService;

public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(false);
		 if(session != null) {
		 session.removeAttribute("login");
		 }
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String message = "";
		String username = req.getParameter("TechUsername");
		String pass = req.getParameter("TechPass");
		Login login = new Login();
		LoginService loginServ = new LoginService();
		
		try {
			
			login = loginServ.tryTechnicianLogin(username,pass);
			
			if(login.getUserID()>0) {
				
				   HttpSession session = req.getSession(true);
				   session.setAttribute("login", login);
				   
				   if(login.getUserType().equals("Technician")) {
					   resp.sendRedirect("/webapp/appointments?action=view-dashboard-technician");
				   }
				
			}else {

					req.setAttribute("message","invalid username or password");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);	

			}
			
		} catch (Exception e) {
			message = e.getMessage();
			req.setAttribute("message",message);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);	
			
		}
		
		
	}
	
}
