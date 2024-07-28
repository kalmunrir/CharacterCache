package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LanguageDAO {
    private static final String tableName = "Languages";

    public static Language createLanguage(String name, String type) {
        int id = CRUDHelper.create(tableName,
                new String[]{"name", "type"},
                new Object[]{name, type},
                new int[]{Types.VARCHAR, Types.VARCHAR}
        );
        if (id > 0) {
            return new Language(id, name, type);
        }
        return null;
    }

    public static ArrayList<Language> getLanguages(int id) {
        ArrayList<Language> languages = new ArrayList<>();
        ResultSet rs = CRUDHelper.read(tableName);
        try {
            while(rs.next()) {
                languages.add(new Language(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                ));
            }
            return languages;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze languages because " + e.getCause()
            );
            return null;
        }
    }

    public static Language getLanguageById(int id) {
        ResultSet rs = CRUDHelper.readById(tableName, id);
        try {
            if (rs.next()){
                return new Language(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                );
            }
            return null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze language because " + e.getCause()
            );
            return null;
        }
    }

    public static Language getLanguageByName(String name) {
        ResultSet rs = CRUDHelper.readByFields(tableName,
                new String[]{"name"},
                new Object[]{name},
                new int[]{Types.VARCHAR}
        );
        try {
            if (rs.next()){
                return new Language(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                );
            }
            return null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze language because " + e.getCause()
            );
            return null;
        }
    }
}
