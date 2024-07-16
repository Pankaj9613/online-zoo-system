package com.zoo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UpdateTicket")
public class UpdateTicketServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String TicketType = req.getParameter("TicketType");
		String Price = req.getParameter("Price");
        String tid = req.getParameter("tid");
        
        try {
            
            Ticket t=new Ticket();
            t.setTid(Integer.parseInt(tid));
            t.setTicketType(TicketType);
            t.setPrice(Price);
                                   
            TicketDAO.updateTicket(t);

            resp.sendRedirect("editTicket.jsp?msg=valid&tid="+tid);

        } catch (Exception e) {
            resp.getWriter().println("Error " + e.getMessage());
        }
	}
}