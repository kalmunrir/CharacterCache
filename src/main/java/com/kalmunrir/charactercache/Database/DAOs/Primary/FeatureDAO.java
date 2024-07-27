package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Feature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeatureDAO {
    private static final String tableName = "Features";

    public static Feature createFeature(String name, int reqLevel, String description) {
        int id = CRUDHelper.create(tableName,
                new String[]{"name", "reqLevel", "description"},
                new Object[]{name, reqLevel, description},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        if (id > 0) {
            return new Feature(id, name, reqLevel, description);
        }
        return null;
    }

    public static Feature getFeature(int id) {
        try {
            ResultSet rs = CRUDHelper.readById(tableName, id);
            if  (rs.next()){
                return new Feature(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("reqLevel"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze feature because " + e.getCause()
            );
            return null;
        }
        return null;
    }

    public static Feature getFeatureByName(String name) {
        try {
            ResultSet rs = CRUDHelper.readByFields(tableName,
                    new String[]{"name"},
                    new Object[]{name},
                    new int[]{Types.VARCHAR}
            );
            if  (rs.next()){
                return new Feature(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("reqLevel"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze feature because " + e.getCause()
            );
            return null;
        }
        return null;
    }
}
