package com.zoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NativeTicDAO {
	private Connection con;

	public NativeTicDAO(Connection con) {
		super();
		this.con = con;
	}

	
	// Get data from database to manage ticket type.
	public static List<TicketIndian> getTicketIndian(boolean sort, boolean desc) throws Exception {
		List<TicketIndian> list = new ArrayList<TicketIndian>();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM ticindian order by id");

		while (rs.next()) {
			TicketIndian t = new TicketIndian();
			t.setId(rs.getInt("id"));
			t.setTicketID(rs.getInt("TicketID"));
			t.setNoAdult(rs.getString("NoAdult"));
			t.setNoChildren(rs.getString("NoChildren"));
			t.setAdultUnitprice(rs.getString("AdultUnitprice"));
			t.setChildUnitprice(rs.getString("ChildUnitprice"));
			t.setPostingDate(rs.getString("PostingDate"));
			list.add(t);
		}
		con.close();
		return list;
	}
}
