package Classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Gestion {
        // methode recuperation d'id en fonction d'une colonne
        public  int recuperation(Connection con,String nomid, String nom, String nomTable,String nomcolonne){
            int id = 0;

            try {

                String query = "SELECT " + nomid + " FROM " + nomTable + " WHERE "+ nomcolonne+"=\'" + nom + "\'";
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet idQuery=stmt.executeQuery();
                while(idQuery.next()) {
                    id = idQuery.getInt(1);
                }
                messageOk();
            } catch(Exception e) {
                System.out.println(e);;
            }

            return id;

        }

    // methode recuperation d'id en fonction de deux colonnes
    public  int recuperationComplexe(Connection con,String nomid,String des, int cat, String nomTable){
        int id = 0;

        try {

            String query = "SELECT " + nomid + " FROM " + nomTable + " WHERE Art_des = \'" + des + "\' AND FK_cat = " + cat + "";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet idQuery=stmt.executeQuery();
            while(idQuery.next()) {
                id = idQuery.getInt(1);
            }
            messageOk();
        } catch(Exception e) {
            System.out.println(e);
        }

        return id;

    }

        // methode modification
        public void modification(Connection con, String nomTable, String changement, String attribut, int id,String nomid)
        {
            try {
                String query ="Update " + nomTable + " Set " +attribut + "=\'" + changement + "\' WHERE " + nomid +" =" + id + "";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.executeUpdate();
                messageOk();
            } catch(Exception e) {
                System.out.println(e);
            }

        }

        // methode suppression
        public void suppression(Connection con, String nomTable, String nom, String nomcolonne)
        {


            try {
                String query = "DELETE FROM " + nomTable + " WHERE " + nomcolonne + " = \'" + nom + "\'";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.executeUpdate();
                messageOk();
            } catch (Exception e) {
                System.out.println(e);
                messagePb();
            }
        }


    // methode verification

    public boolean verification(Connection con, String nom, String nomTable){
        boolean verif = false;
        try {
            int id=0;
            String query = "SELECT id FROM " + nomTable + " WHERE Cat_des = \'" + nom + "\'";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet requete=stmt.executeQuery();
            while(requete.next()) {
                id = requete.getInt(1);
            }
            if (id==0){
                verif=true;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println(verif);
        return verif;

    }


        // methode message 1
        public void messageOk(){
            System.out.println("Operation reussie : ");
        }

        // methode message 2
        public void messagePb(){
            System.out.println("Echec : ");
        }

        //methode fabrication des array
        public ArrayList arraySurTable (String nomTable, String attribut){
            Connection con = Connect.openConnection();
            ArrayList<String> array = new ArrayList<String>();

            try {
                String query = "SELECT " + attribut + " FROM " + nomTable + "";
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet requete=stmt.executeQuery();
                while (requete.next()){
                    String nom=requete.getString(1);
                    array.add(nom);
                }

            } catch(Exception e) {
                System.out.println(e);
            }

            return array;
        }

        //methode selection des categories

        public ArrayList arrayCategories(){
            ArrayList<String> array = new ArrayList<String>();
            array=arraySurTable("categories","Cat_des" );

            return array;
        }

        //methode selection des article

        public ArrayList arrayArticle(){
            ArrayList<String> array = new ArrayList<String>();
            array=arraySurTable("articles","Art_des" );


            return array;
        }

        //methode selection des articles sur une categorie
        public ArrayList arrayArticlemodifié(String nomcat){
            Connection con = Connect.openConnection();
            ArrayList<String> array = new ArrayList<String>();
            int id = recuperation(con ,"PK_categories",nomcat,"categories","Cat_des");

            try {
                String query = "SELECT Art_des FROM articles where FK_cat = "+id+"";
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet requete=stmt.executeQuery();
                while (requete.next()){
                    String nom=requete.getString(1);
                    array.add(nom);
                }

            } catch(Exception e) {
                System.out.println(e);
            }


            return array;
        }

          //methode selection des articles avec la categorie
        public ArrayList arrayArticleentier(){
            Connection con = Connect.openConnection();
            ArrayList<String> array = new ArrayList<String>();

            try {
                String query = "SELECT Art_des, Cat_des FROM articles LEFT JOIN categories ON articles.FK_cat = categories.PK_categories ";
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet requete=stmt.executeQuery();
                while (requete.next()){
                    String nom=requete.getString(1);
                    array.add(nom);
                    String nom1=requete.getString(2);
                    array.add(nom1);
                }

            } catch(Exception e) {
                System.out.println(e);
            }


            return array;
        }

}
