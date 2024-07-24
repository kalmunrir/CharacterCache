package com.kalmunrir.charactercache.Database.DAOs;

import com.kalmunrir.charactercache.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String location = App.class.getResource("database.bdb").toExternalForm();

    public static boolean isOk(){
        return checkConnection() && checkDrivers();
    }

    private static boolean checkConnection() {
        try (Connection conn = connect()) {
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not start SQLite drivers"
            );
            return false;
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + location);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not connect to the database"
            );
        }
        return conn;
    }
}
