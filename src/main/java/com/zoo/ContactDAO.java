package com.zoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContactDAO{

	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	// Insert Contact Details here
	public boolean addContact(ContactDtls cd) {
		boolean f = false;
		try {
			String sql = "insert into contacts(name,emailid,contact,message) values(?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cd.getName());
			ps.setString(2, cd.getEmailid());
			ps.setString(3, cd.getContact());
			ps.setString(4, cd.getMessage());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}

	// Admin login Here
	public ContactDtls loginAdmin(String e, String p) {

		ContactDtls cd = null;
		try {
			String sql = "select * from admin where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e);
			ps.setString(2, p);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cd = new ContactDtls();
				cd.setEmailid(rs.getString(1));
				cd.setPassword(rs.getString(2));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cd;
	}
}