<%@ page import="java.util.ArrayList" %>
<%@ page import="Classe.Categories" %><%--
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
    ArrayList<String> listcat = new ArrayList<String>();
    listcat = (ArrayList<String>) request.getAttribute("listCategory");

%>

<head>
    <title>Categories</title>
</head>
<body>
<form action="../Article" method="post">
    <input type="submit" value="Article" class="btn btn-primary btn-lg btn-block">
</form>

<h1>Categories</h1>

<h2> Ajout</h2>
<form action="../CategoriesAjout" method="post">
    Description: <input type="text" name="description" />
    <input type="submit" value="ajout" name = "ajoutCategories"/>
</form>

<h2> Suppression</h2>
<form action="../CategoriesSuppression" method="post">
    <select name="description">

    <% if(request.getAttribute("listCategory") != null) {
        for(int b = 0; b < listcat.size(); b++) {
            Categories categorie = new Categories(listcat.get(b));
    %>


        <option value="<%=categorie.getDescription()%>"><%=categorie.getDescription()%></option>


        <%
                }};
        %>

    </select>
    <input type="submit" value="suppression" name="suppressioncategories"/>
</form>

<h2> Modification</h2>
<form action="../CategoriesModifier" method="post">

    <select name="description">

        <% if(request.getAttribute("listCategory") != null) {
            for(int a = 0; a < listcat.size(); a++) {
                Categories categorie2 = new Categories(listcat.get(a));
        %>


        <option value="<%=categorie2.getDescription()%>"><%=categorie2.getDescription()%></option>


        <%
                }};
        %>

    </select>
    Nouvelle description: <input type="text" name="changement" />

    <input type="submit" value="modification" name="modificationcategories"/>
</form>

<h2>Categorie</h2>
<table>
    <thead>
    <tr>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <% if(request.getAttribute("listCategory") != null) {
        for(int i = 0; i < listcat.size(); i++) {
        Categories categorie1 = new Categories(listcat.get(i));

    %>


    <tr>
        <td><%=categorie1.getDescription()%></td>

    </tr>
    <%
        }};
    %>
    </tbody>
</table>


</body>
</html>
