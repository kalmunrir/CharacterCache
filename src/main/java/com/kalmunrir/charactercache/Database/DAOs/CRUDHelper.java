package com.kalmunrir.charactercache.Database.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDHelper {
    public static void create(String tablename) {
        
    }

    public static void read(String tablename) {

    }

    public static void update(String tablename) {

    }

    public static int delete(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?;";
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not delete entry id: " + id + " from " +
                            tableName + " because " + e.getCause()
            );
            return -1;
        }
    }
}
