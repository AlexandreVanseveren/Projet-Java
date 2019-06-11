package Servlet;

import Classe.Gestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletTrie",urlPatterns = {"/Trie"})
public class ServletTrie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //instancie pour les methode
        Gestion gestion = new Gestion();

        // recuperation parametre
        String triage = request.getParameter("categories");

        // creation des array list
        ArrayList<String> articleTrie = gestion.arrayArticlemodifié(triage);
        ArrayList<String> categorie = gestion.arrayCategories();
        ArrayList<String> articles = gestion.arrayArticle();
        ArrayList<String> articlecomp = gestion.arrayArticleentier();

        // envoye des array list avec le moyen de les recup
        request.setAttribute("listArticleTrie",articleTrie);
        request.setAttribute("listArticle", articles);
        request.setAttribute("listArticleComp", articlecomp);
        request.setAttribute("listCategory", categorie);
        this.getServletContext().getRequestDispatcher("/vue/Article.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
