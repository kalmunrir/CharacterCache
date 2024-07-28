package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Proficiency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProficiencyDAO {
    private static final String tableName = "Proficiencies";

    public static Proficiency createProficiency(String name, String type) {
        int id = CRUDHelper.create(tableName,
                new String[]{"name", "type"},
                new Object[]{name, type},
                new int[]{Types.VARCHAR, Types.VARCHAR}
        );
        if (id > 0) {
            return new Proficiency(id, name, type);
        }
        return null;
    }

    public static ArrayList<Proficiency> getProficiencies(int id) {
        ArrayList<Proficiency> proficiencies = new ArrayList<Proficiency>();
        ResultSet rs = CRUDHelper.read(tableName);
        try {
            while(rs.next()) {
                proficiencies.add(new Proficiency(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                ));
            }
            return proficiencies;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze proficiencies because " + e.getCause()
            );
            return null;
        }
    }

    public static Proficiency getProficiencyById(int id) {
        ResultSet rs = CRUDHelper.readById(tableName, id);
        try {
            if (rs.next()){
                return new Proficiency(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                );
            }
            return null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze proficiency because " + e.getCause()
            );
            return null;
        }
    }

    public static Proficiency getProficiencyByName(String name) {
        ResultSet rs = CRUDHelper.readByFields(tableName,
                new String[]{"name"},
                new Object[]{name},
                new int[]{Types.VARCHAR}
        );
        try {
            if (rs.next()){
                return new Proficiency(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                );
            }
            return null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze proficiency because " + e.getCause()
            );
            return null;
        }
    }
}
