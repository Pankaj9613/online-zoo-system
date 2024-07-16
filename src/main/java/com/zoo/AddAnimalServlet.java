package com.zoo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddAnimal")
@MultipartConfig
public class AddAnimalServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String AnimalName = req.getParameter("AnimalName");
        String CageNumber = req.getParameter("CageNumber");
        String FeedNumber = req.getParameter("FeedNumber");
        String Breed =req.getParameter("Breed");
        String Description = req.getParameter("Description");
        Part photo = req.getPart("pic");
       
        try {
            Animal a=new Animal(AnimalName, CageNumber, FeedNumber, Breed, Description);
            AnimalDAO.addAnimal(a, photo,getServletContext());
            resp.sendRedirect("addAnimal.jsp?msg=valid");

        } catch (Exception e) {
            resp.getWriter().println("Error " + e.getMessage());
        }
	}
}