package com.zoo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
				
		ContactDAO dao = new ContactDAO(DBConnect.getConn());
		ContactDtls u = dao.loginAdmin(email, pass);
		
		HttpSession session = req.getSession();
		
		if(u!=null) {
			session.setAttribute("username", email);
			session.setAttribute("validMsg", "Logged in Successfully");
			resp.sendRedirect("login.jsp");			
		}
		else {
			session.setAttribute("invalidMsg", "Invalid Credential, Try Again..");
			resp.sendRedirect("login.jsp");			
		}
	}	
}