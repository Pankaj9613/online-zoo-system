package com.zoo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class AnimalDAO {
	private Connection con;

	public AnimalDAO(Connection con) {
		super();
		this.con = con;
	}

	// Insert Animal
	public static void addAnimal(Animal a, Part part, ServletContext ctx) throws Exception {
		Connection con = DBConnect.getConn();
		PreparedStatement ps = con.prepareStatement(
				"INSERT into animal(AnimalName,CageNumber,FeedNumber,Breed,Description) VALUES(?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, a.getAnimalName());
		ps.setString(2, a.getCageNumber());
		ps.setString(3, a.getFeedNumber());
		ps.setString(4, a.getBreed());
		ps.setString(5, a.getDescription());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		String id = rs.getString(1);
		ps = con.prepareStatement("update animal set photo=? where id=?");
		ps.setString(1, id + ".jpg");
		ps.setString(2, id);
		ps.executeUpdate();
		fileCopy(ctx, part, id + ".jpg");

		con.close();
		System.out.println("All done with Animal");
	}

	public static void fileCopy(ServletContext ctx, Part part, String filename) throws Exception {
		Files.copy(part.getInputStream(), Paths.get(ctx.getRealPath("/images2/"), filename),
				StandardCopyOption.REPLACE_EXISTING);
	}

	// Edit animal
	public Animal getAnimalById(int id) {
		Animal a = null;

		try {
			String sql = "select * from animal where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Animal();
				a.setId(rs.getInt(1));
				a.setAnimalName(rs.getString(2));
				a.setCageNumber(rs.getString(3));
				a.setFeedNumber(rs.getString(4));
				a.setBreed(rs.getString(5));
				a.setPhoto(rs.getString(6));
				a.setDescription(rs.getString(7));
				a.setCreationDate(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static List<String> getAnimalNames() throws Exception {
		List<String> list = new ArrayList<String>();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement().executeQuery("select AnimalName from animal");
		while (rs.next()) {
			list.add(rs.getString("AnimalName"));
		}
		con.close();
		return list;
	}

	public static List<Animal> getAnimal(boolean sort, boolean desc) throws Exception {
		List<Animal> list = new ArrayList<Animal>();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM animal order by id");
		
		while (rs.next()) {
			Animal a = new Animal();
			a.setId(rs.getInt("id"));
			a.setAnimalName(rs.getString("AnimalName"));
			a.setCageNumber(rs.getString("CageNumber"));
			a.setFeedNumber(rs.getString("FeedNumber"));
			a.setBreed(rs.getString("Breed"));			
			a.setPhoto(rs.getString("photo"));
			a.setDescription(rs.getString("Description"));
			a.setCreationDate(rs.getString("CreationDate"));
			list.add(a);
		}
		con.close();
		return list;
	}

	public static List<Animal> findByName(String AnimalName) throws Exception {
		List<Animal> list = new ArrayList<Animal>();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement()
				.executeQuery("SELECT * FROM animal WHERE AnimalName like '%" + AnimalName + "%'");
		while (rs.next()) {
			Animal p = new Animal();
			p.setId(rs.getInt("id"));
			p.setAnimalName(rs.getString("AnimalName"));
			p.setCageNumber(rs.getString("CageNumber"));
			p.setFeedNumber(rs.getString("FeedNumber"));
			p.setBreed(rs.getString("Breed"));
			p.setPhoto(rs.getString("photo"));
			p.setDescription(rs.getString("Description"));
			p.setCreationDate(rs.getString("CreationDate"));
			list.add(p);
		}
		con.close();
		return list;
	}

	public static Animal findByID(String id) throws Exception {
		Animal a = new Animal();
		Connection con = DBConnect.getConn();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM animal WHERE id='" + id + "'");
		rs.next();
		a.setId(rs.getInt("id"));
		a.setAnimalName(rs.getString("AnimalName"));
		a.setCageNumber(rs.getString("CageNumber"));
		a.setFeedNumber(rs.getString("FeedNumber"));
		a.setBreed(rs.getString("Breed"));
		a.setPhoto(rs.getString("photo"));
		a.setCreationDate(rs.getString("CreationDate"));
		con.close();
		return a;
	}

	public static void removeProduct(String prodid) throws Exception {

	}

	//Update Animal
	public static void updateAnimal(Animal a) throws Exception {
		Connection con = DBConnect.getConn();
		PreparedStatement ps = con
				.prepareStatement("UPDATE animal set AnimalName=?,CageNumber=?,FeedNumber=?,Breed=?,Description=? where id=?");
		ps.setString(1, a.getAnimalName());
		ps.setString(2, a.getCageNumber());
		ps.setString(3, a.getFeedNumber());
		ps.setString(4, a.getBreed());
		ps.setString(5, a.getDescription());
		ps.setInt(6, a.getId());

		ps.executeUpdate();
		con.close();
		System.out.println("Animal Updated..!!");
	}
}
