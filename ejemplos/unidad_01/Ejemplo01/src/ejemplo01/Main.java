/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Lorenzo González
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Connection connection = getConnection();


            String sql = "INSERT INTO Usuario (IdUsuario,login,nombre,ape1,ape2,password,fechaCreacion) VALUES (?,?,?,?,?,?,?)";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            java.util.Date ahora=new java.util.Date();

            preparedStatement.setInt(1,100);
            preparedStatement.setString(2,"lgonzalez");
            preparedStatement.setString(3,"Lorenzo");
            preparedStatement.setString(4,"González");
            preparedStatement.setString(5,"Pérez");
            preparedStatement.setString(6,"1234ñ@'\"");
            preparedStatement.setTimestamp(7, new Timestamp(ahora.getTime()));


            preparedStatement.executeUpdate();


            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    static private Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/hibernate1";
            String user = "hibernate1";
            String password = "hibernate1";
            String driver = "com.mysql.jdbc.Driver";


            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
