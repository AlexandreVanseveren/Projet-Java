package Classe;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Categories extends Gestion{

    private String description;


    public Categories(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void ajoutCategories(){
        Connection con = Connect.openConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO categories (PK_categories,Cat_des) VALUE (?,?)");
            stmt.setInt(1,0);
            stmt.setString(2, getDescription());
            stmt.executeUpdate();
            messageOk();
        } catch(Exception e) {
            System.out.println(e);
        }

    }

    // methode modification
    public void modificationCategories(String changement, String attribut){
        Connection con = Connect.openConnection();
        modification(con,"categories",changement,attribut,recuperation(con,"PK_categories",getDescription(),"categories","Cat_des"),"PK_categories");


    }

    // methode suppression
    public void suppressionCategories() {
        Connection con = Connect.openConnection();
        suppression(con, "categories", getDescription(), "Cat_des" );


    }
}
