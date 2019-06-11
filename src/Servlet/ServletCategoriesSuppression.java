package Servlet;

import Classe.Categories;
import Classe.Gestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCategoriesSuppression",urlPatterns = {"/CategoriesSuppression"})
public class ServletCategoriesSuppression extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //instancie pour les methode
        Gestion gestion= new Gestion();
        // recuperation parametre
        String description = request.getParameter("description");
        //instancie pour les methode
        Categories categories= new Categories(description);
        // execution methode
        categories.suppressionCategories();
        // creation des array list
        ArrayList<String> categorie = gestion.arrayCategories();

        // envoye des array list avec le moyen de les recup
        request.setAttribute("listCategory", categorie);
        this.getServletContext().getRequestDispatcher("/vue/Categories.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/Categories.jsp").forward(request, response);

    }
}
