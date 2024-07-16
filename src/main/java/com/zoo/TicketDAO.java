package com.zoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
	private Connection con;

	public TicketDAO(Connection con) {
		super();
		this.con = con;
	}
	
	//Get data from database to manage ticket type.
	public static List<Ticket> getTicket(boolean sort, boolean desc) throws Exception {
		List<Ticket> list = new ArrayList<Ticket>();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tickettype order by tid");
		
		while (rs.next()) {
			Ticket t = new Ticket();
			t.setTid(rs.getInt("tid"));
			t.setTicketType(rs.getString("TicketType"));
			t.setPrice(rs.getString("Price"));
			list.add(t);
		}
		con.close();
		return list;
	}
	
	//Edit Ticket 
	public Ticket getTicketById(int tid) {
		Ticket t = null;

		try {
			String sql = "select * from tickettype where tid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new Ticket();
				t.setTid(rs.getInt(1));
				t.setTicketType(rs.getString(2));
				t.setPrice(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	//Update Ticket
		public static void updateTicket(Ticket t) throws Exception {
			Connection con = DBConnect.getConn();
			PreparedStatement ps = con
					.prepareStatement("UPDATE tickettype set TicketType=?,Price=? where tid=?");
			ps.setString(1, t.getTicketType());
			ps.setString(2, t.getPrice());
			ps.setInt(3, t.getTid());

			ps.executeUpdate();
			con.close();
			System.out.println("Ticket Updated..!!");
		}
}
