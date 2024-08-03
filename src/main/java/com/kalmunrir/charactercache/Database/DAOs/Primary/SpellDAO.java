package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Spell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpellDAO {
    private static final String tableName = "Spells";

    public static Spell createSpell(String name, int level, boolean ritualBool, boolean concentrationBool,
                                    String castingTime, String distance, String duration, String materials, String description) {
        int ritual = ritualBool ? 1 : 0;
        int concentration = concentrationBool ? 1 : 0;

        int id = CRUDHelper.create(
                tableName,
                new String[]{"name", "level", "ritual", "concentration", "castingTime", "distance", "duration",
                        "materials", "description"},
                new Object[]{name, level, ritual, concentration, castingTime, distance, duration, materials,
                        description},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR}
        );
        if(id > 0) {
            return new Spell(id, name, level, ritualBool, concentrationBool, castingTime, distance, duration, materials,
                    description);
        }
        return null;
    }

    public static ArrayList<Spell> getAllSpells() {
        ArrayList<Spell> spells = new ArrayList<>();
        ResultSet rs = CRUDHelper.read(tableName);
        try {
            while (rs.next()) {
                spells.add(new Spell(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("level"),
                        rs.getBoolean("ritual"),
                        rs.getBoolean("concentration"),
                        rs.getString("castingTime"),
                        rs.getString("distance"),
                        rs.getString("duration"),
                        rs.getString("materials"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze spells because " + e.getCause()
            );
        }
        return spells;
    }
}
