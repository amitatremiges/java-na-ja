package com.test;

import java.sql.*;


public class Example {
    public static void main(String[] args) {
        String userID = args[0]; // Assume user input is provided as a command-line argument

        // Fixed: Parameterized query
        String query = "SELECT username FROM users WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "username", "password");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userID); // Set the value of the parameter

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Hello, " + username + "!");
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
