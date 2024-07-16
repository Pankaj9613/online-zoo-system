package com.zoo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/contact")
public class AddContactServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String emailid = req.getParameter("emailid");
		String contact = req.getParameter("contact");
		String message = req.getParameter("message");
		String msgDate = req.getParameter("msgDate");
		String isRead = req.getParameter("isRead");
		String password = req.getParameter("password");
		
		
		ContactDtls cd = new ContactDtls(name,emailid,contact,message,msgDate,isRead,password);
		ContactDAO dao = new ContactDAO(DBConnect.getConn());
		
		boolean f = dao.addContact(cd);
		
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("successMsg", "Your Contact Query has been Send.");
			resp.sendRedirect("contact.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went Wrong..!!");
			resp.sendRedirect("contact.jsp");
		}	
	}
}
