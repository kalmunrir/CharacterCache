package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkillDAO {
    private static final String tableName = "Skills";

    public static Skill createSkill(String name, String description, String ability) {
        int id = CRUDHelper.create(
                tableName,
                new String[]{"name", "description", "ability"},
                new Object[]{name, description, ability},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR}
        );
        if (id > 0) {
            return new Skill(id, name, description, ability);
        }
        return null;
    }

    public static ArrayList<Skill> getAllSkills() {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        ResultSet rs = CRUDHelper.read(tableName);
        try {
            while(rs.next()) {
                skills.add(new Skill(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("ability")
                ));
            }
            return skills;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze skills because " + e.getCause()
            );
            return null;
        }
    }
}
