package Classe;

import java.sql.*;

public class Connect {
    static String driver ="com.mysql.cj.jdbc.Driver" ;
    static String connection_ip = "jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";



    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(connection_ip, username, password);
            } catch(Exception e) {
                System.out.println("Opening connection: "+ e);
            }
        } catch(Exception e) {
            System.out.println("Loading driver: "+ e);
        }
        return con;
    }
}
