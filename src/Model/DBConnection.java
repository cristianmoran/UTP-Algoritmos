package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBConnection {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/marcacion_asistencia";
    private final String username = "root";
    private final String password = "316497069";

    public Connection openConnection() {
        try {
            Class. forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e);
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }
        return null;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
 public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    
    
}
}