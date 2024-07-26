package com.kalmunrir.charactercache.Database.DAOs;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDHelper {
    public static ResultSet create(String tableName, String[] columnNames, Object[] values, int[] types) {
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");

        // Building the query
        for (int i = 0; i < columnNames.length; i++) {
            sql.append(columnNames[i]);
            if (i != columnNames.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(") VALUES (");
        for (int i = 0; i < values.length; i++) {
            sql.append("?");
            if (i != values.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(");");

        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            for (int i = 0; i < values.length; i++) {
                if (types[i] == Types.INTEGER) {
                    ps.setInt(i, (int) values[i]);
                }
                else if (types[i] == Types.VARCHAR) {
                    ps.setString(i, (String) values[i]);
                }
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not insert entry into " +
                            tableName + " because " + e.getCause()
            );
            return null;
        }
    }

    public static ResultSet read(String tableName) {
        String sql = "SELECT * FROM " + tableName + ";";

        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not read from " + tableName + " because " + e.getCause()
            );
            return null;
        }
    }

    public static ResultSet readById(String tableName, int id) {
        return readByFields(tableName, new String[]{"id"}, new Object[]{id}, new int[]{Types.INTEGER});
    }

    public static ResultSet readByFields(String tableName, String[] columnNames, Object[] values, int[] types) {
        StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
        for (int i = 0; i < columnNames.length; i++) {
            sql.append(columnNames[i]);
            sql.append(" = ?");
            if (i != columnNames.length - 1) {
                sql.append(" AND ");
            }
        }
        sql.append(";");
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            for (int i = 0; i < values.length; i++) {
                if (types[i] == Types.INTEGER) {
                    ps.setInt(i, (int) values[i]);
                }
                else if (types[i] == Types.VARCHAR) {
                    ps.setString(i, (String) values[i]);
                }
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not read entries from " + tableName +
                            " because " + e.getCause()
            );
            return null;
        }
    }

    public static void update(String tableName, int id, String[] columnNames, Object[] values, int[] types) {
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
        for (int i = 0; i < columnNames.length; i++) {
            sql.append(columnNames[i]);
            sql.append(" = ?");
            if (i != columnNames.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE id = ?;");

        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            for (int i = 0; i < values.length; i++) {
                if (types[i] == Types.INTEGER) {
                    ps.setInt(i, (int) values[i]);
                }
                else if (types[i] == Types.VARCHAR) {
                    ps.setString(i, (String) values[i]);
                }
            }
            ps.setInt(values.length, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not update entry: " + id + " in " +
                            tableName + " because " + e.getCause()
            );
        }
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
