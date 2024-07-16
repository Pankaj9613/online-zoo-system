package com.zoo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UpdateAnimal")
@MultipartConfig
public class UpdateAnimalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AnimalName = req.getParameter("AnimalName");
        String CageNumber = req.getParameter("CageNumber");
        String FeedNumber = req.getParameter("FeedNumber");
        String id = req.getParameter("id");
        String Breed = req.getParameter("Breed");
        String Description = req.getParameter("Description");
        
        try {
            if (!req.getPart("pic").getSubmittedFileName().isEmpty()) {
                Part photo = req.getPart("pic");
                AnimalDAO.fileCopy(getServletContext(), photo, id + ".jpg");
            }
            Animal a=new Animal();
            a.setId(Integer.parseInt(id));
            a.setAnimalName(AnimalName);
            a.setCageNumber(CageNumber);
            a.setFeedNumber(FeedNumber);
            a.setBreed(Breed);
            a.setDescription(Description);
                       
            AnimalDAO.updateAnimal(a);

            resp.sendRedirect("editAnimal.jsp?msg=valid&id="+id);

        } catch (Exception e) {
            resp.getWriter().println("Error " + e.getMessage());
        }

    }

}
