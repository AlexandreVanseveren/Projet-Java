package Classe;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Article extends Gestion {

    private String description;
    private String categories;

    public Article(String description) {
        this.description = description;
    }

    public Article(String description, String categories) {
        this.description = description;
        this.categories = categories;

    }


    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void ajoutArticle(){
        Connection con = Connect.openConnection();;
        try {
            int xid= recuperation(con, "PK_categories",getCategories(), "categories","Cat_des");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO articles VALUE (?,?,?)");
            stmt.setInt(1,0);
            stmt.setString(2, getDescription());
            stmt.setInt(3,xid);
            stmt.executeUpdate();
            messageOk();
        } catch(Exception e) {
            System.out.println(e);

        }
    }

    public void modificationArticle(String changement, String attribut){
        Connection con = Connect.openConnection();;
        modification(con,"articles",changement,attribut,recuperation(con,"PK_article",getDescription(),"articles","Art_des"),"PK_article" );
    }

    public void suppressionArticle() {
        Connection con = Connect.openConnection();;
        int xid=recuperation(con,"PK_categories", getCategories(),"categories","Cat_des");
        int id=recuperationComplexe(con,"PK_article", getDescription(), xid, "articles");

        try {
            String query = "DELETE FROM articles WHERE PK_article = " + id + "";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            messageOk();
        } catch (Exception e) {
            System.out.println(e);
            messagePb();
        }
    }
}

