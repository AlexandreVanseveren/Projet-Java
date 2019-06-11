<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Classe.Categories" %>
<%@ page import="Classe.Article" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 05-06-19
  Time: 03:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    //recuperation des listes
    ArrayList<String> listCat = new ArrayList<String>();
    listCat = (ArrayList<String>) request.getAttribute("listCategory");

    ArrayList<String> listArt = new ArrayList<String>();
    listArt= (ArrayList<String>) request.getAttribute("listArticle");

    ArrayList<String> listArtComp = new ArrayList<String>();
    listArtComp= (ArrayList<String>) request.getAttribute("listArticleComp");

    ArrayList<String> listArtTrie = new ArrayList<String>();
    listArtTrie= (ArrayList<String>) request.getAttribute("listArticleTrie");

%>

<head>
    <title>Article</title>
</head>
<body>
<form action="../Categories" method="post">
    <input type="submit" value="Categories" class="btn btn-primary btn-lg btn-block">
</form>

<h1>Articles </h1>

<h2> Ajout</h2>
<form action="../ArticleAjout" method="post">
    Description: <input type="text" name="description" />

    <select name="categories">

        <%if(request.getAttribute("listCategory") != null) {
            for(int b = 0; b < listCat.size(); b++) {
                Categories categorie = new Categories(listCat.get(b));
        %>


        <option value="<%=categorie.getDescription()%>"><%=categorie.getDescription()%></option>


        <%
                }};
        %>

    </select>
    <input type="submit" value="ajout" name="ajoutarticles"/>
</form>

<h2> Suppression</h2>
<form action="../ArticleSuppression" method="post">

    <select name="description">

        <% if(request.getAttribute("listArticle") != null) {
            for(int v = 0; v < listArt.size(); v++) {
                Article article = new Article(listArt.get(v));
        %>


        <option value="<%=article.getDescription()%>"><%=article.getDescription()%></option>


        <%
                }};
        %>

    </select>


    <select name="categories">

        <% if(request.getAttribute("listCategory") != null) {
            for(int b = 0; b < listCat.size(); b++) {
                Categories categorie = new Categories(listCat.get(b));
        %>


        <option value="<%=categorie.getDescription()%>"><%=categorie.getDescription()%></option>


        <%
                }};
        %>

    </select>

    <input type="submit" value="suppression" name="suppressionarticless"/>
</form>

<h2> Modification </h2>
<form action="../ArticleModifier" method="post">

    <select name="description">

        <% if(request.getAttribute("listArticle") != null) {
            for(int c = 0; c < listArt.size(); c++) {
                Article article = new Article(listArt.get(c));
        %>


        <option value="<%=article.getDescription()%>"><%=article.getDescription()%></option>


        <%
                }};
        %>

    </select>


    <select name="categories">

        <% if(request.getAttribute("listCategory") != null) {
            for(int i = 0; i < listCat.size(); i++) {
                Categories categorie1 = new Categories(listCat.get(i));
        %>


        <option value="<%=categorie1.getDescription()%>"><%=categorie1.getDescription()%></option>


        <%
                }};
        %>

    </select>
    Nouvelle description: <input type="text" name="changement" />

    <input type="submit" value="modification" name="modificationarticles"/>
</form>





<h2>Article</h2>
<table>
    <thead>
    <tr>
        <th>Description</th>
        <th>Categories</th>
    </tr>
    </thead>
    <tbody>
    <% if(request.getAttribute("listArticleComp") != null) {
        for(int i = 0; i < listArtComp.size(); i=i+2) {
            Article article1 = new Article(listArtComp.get(i), listArtComp.get(i+1));


    %>


    <tr>
        <td><%=article1.getDescription()%></td>
        <td><%=article1.getCategories()%></td>
    </tr>
    <%
            }};
    %>
    </tbody>
</table>


<h2>Trier la liste article en fonction de la categories</h2>
<form action = "/Trie" method = "post">
    <select name="categories">

        <% if(request.getAttribute("listCategory") != null) {
            for(int c = 0; c < listCat.size(); c++) {
                Categories categorie2 = new Categories(listCat.get(c));
        %>


        <option value="<%=categorie2.getDescription()%>"><%=categorie2.getDescription()%></option>


        <%
                }};
        %>

    </select>

    <input type="submit" value="trier" name="trier"/>
</form>


<h2>ArticleTrie</h2>
<table>
    <thead>
    <tr>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <% if(request.getAttribute("listArticleTrie") != null) {
        for(int i = 0; i < listArtTrie.size(); i++) {
            Article article2 = new Article(listArtTrie.get(i));

    %>


    <tr>
        <td><%=article2.getDescription()%></td>

    </tr>
    <%
            }};
    %>
    </tbody>
</table>


</body>
</html>
