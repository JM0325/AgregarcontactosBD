
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/clientesprofe";
    private static final String user = "root";
    private static final String pass = "";
    public static Connection conectar(){
        Connection conex = null;
        try {
            Class.forName(driver);
            conex = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException ex){
            System.out.println("No existe la base de datos");
        }catch(SQLException ex){
//            ex.printStackTrace();
        }
        return conex;
    }
}
