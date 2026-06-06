/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 02
 */
public class DatabaseConnectionTest {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("TEST_DB_URL");

    private static final String USER = dotenv.get("TEST_DB_USER");

    private static final String PASSWORD = dotenv.get("TEST_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
