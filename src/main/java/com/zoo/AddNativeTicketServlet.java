package com.zoo;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNativeTicket")
public class AddNativeTicketServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int TicketID = (int) (Math.random() * 100000000);
		String NoAdult = req.getParameter("NoAdult");
		String NoChildren = req.getParameter("NoChildren");
		String AdultUnitprice = "";
		String ChildUnitprice = "";

		try {
			Connection con = DBConnect.getConn();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery("select * from tickettype where TicketType='Native Adult'");
			if (rs1.next()) {
				AdultUnitprice = rs1.getString(3);
			}

		} catch (Exception e) {
			System.out.println(e);

		}

		try {
			Connection con = DBConnect.getConn();
			Statement st = con.createStatement();
			ResultSet rs2 = st.executeQuery("select * from tickettype where TicketType='Native Child'");
			if (rs2.next()) {
				ChildUnitprice = rs2.getString(3);
			}

		} catch (Exception e) {
			System.out.println(e);

		}

		try {
			Connection con = DBConnect.getConn();
			PreparedStatement ps = con.prepareStatement(
					"insert into ticindian(TicketID,NoAdult,NoChildren,AdultUnitprice,ChildUnitprice) values(?,?,?,?,?)");
			ps.setInt(1, TicketID);
			ps.setString(2, NoAdult);
			ps.setString(3, NoChildren);
			ps.setString(4, AdultUnitprice);
			ps.setString(5, ChildUnitprice);

			ps.executeUpdate();
			resp.sendRedirect("addNativeTicket.jsp?msg=valid");
		} catch (Exception e) {
			System.out.println(e);
			resp.sendRedirect("addNativeTicket.jsp?msg=invalid");
		}

	}
}
