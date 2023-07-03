/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cristian
 */
public class Controller {

    private DBConnection connection;

    public Controller() {
        connection = new DBConnection();
    }

    public void startConnection() {
        try {
            connection.openConnection();
        } catch (Exception e) {
            // Error handling
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.closeConnection();
        } catch (SQLException e) {
            // Error handling
            e.printStackTrace();
        }
    }

    public ResultSet validateUser(String user, String password) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM users WHERE user = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchEmployee(String code, String name, String document, String lastName) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM employee WHERE code = ? AND name = ? AND document = ? AND lastName = ?";
            Boolean notHaveQuery = code.equals("") && name.equals("") && document.equals("") && lastName.equals("");
            if (notHaveQuery) {
                query = "SELECT * FROM employee";
            }
            PreparedStatement statement = connection.prepareStatement(query);
            if (!notHaveQuery) {
                statement.setString(1, code);
                statement.setString(2, name);
                statement.setString(3, document);
                statement.setString(4, lastName);
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace();
        }
        return resultSet;
    }

}
