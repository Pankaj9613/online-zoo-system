package com.zoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ForeignTicDAO {
	
	private Connection con;

	public ForeignTicDAO(Connection con) {
		super();
		this.con = con;
	}

	//Add Native Ticket
  	public static void addForeignTicket(TicketForeign t) throws Exception {
  		Connection con = DBConnect.getConn();
  		PreparedStatement ps = con.prepareStatement("insert into ticforeigner(TicketID,NoAdult,NoChildren,AdultUnitprice,ChildUnitprice) values(?,?,?,?,?)");
  			ps.setInt(1, t.getTicketID());
  			ps.setString(2, t.getNoAdult());
  			ps.setString(3, t.getNoChildren());
  			ps.setString(4, t.getAdultUnitprice());
  			ps.setString(5, t.getChildUnitprice());
  			 			
  			int i=ps.executeUpdate();
  			con.close();
  			System.out.println("All done Ticket");
  	}
	
  //Get data from database to manage ticket type.
  	public static List<TicketForeign> getTicketForeign(boolean sort, boolean desc) throws Exception {
  		List<TicketForeign> list = new ArrayList<TicketForeign>();
  		Connection con = DBConnect.getConn();
  		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM ticforeigner order by id");
  		
  		while (rs.next()) {
  			TicketForeign t = new TicketForeign();
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
  	
  	 //Delete Foreign Ticket
  		public boolean deleteForeignTic(int id) {
  			boolean f = false;
  			try {
  				
  				String sql = "delete from ticforeigner where id=?";
  				PreparedStatement ps = con.prepareStatement(sql);
  				ps.setInt(1, id);
  				
  				int i=ps.executeUpdate();
  				if(i==1) {
  					f=true;
  			 }
  			} catch (Exception e) {
  				e.printStackTrace();
  			}		
  			return f;
  		}

}
