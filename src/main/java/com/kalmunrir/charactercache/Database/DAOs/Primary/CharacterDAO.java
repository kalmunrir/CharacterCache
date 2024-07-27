package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CharacterDAO {
    private static final String tableName = "Characters";

    public static Character insertCharacter(String name, String alignment, String backstory, String background,
                                                  String personalityTraits, String ideals, String bonds, String flaws,
                                                  String physicalDescription, String politics, int proficiencyBonus,
                                                  String playerName, String notes) {
        int id = CRUDHelper.create(tableName,
                new String[]{"name", "alignment", "backstory", "background", "personalityTraits", "ideals", "bonds",
                "flaws", "physicalDescription", "politics", "proficiencyBonus", "playerName", "notes"},
                new Object[]{name, alignment, backstory, background, personalityTraits, ideals, bonds, flaws,
                        physicalDescription, politics, proficiencyBonus, playerName, notes},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                        Types.VARCHAR});

        return new Character(id, name, alignment, backstory, background, personalityTraits, ideals, bonds, flaws,
                physicalDescription, politics, proficiencyBonus, playerName, notes);
    }

    public static ArrayList<Character> getAllCharacters() {
        ArrayList<Character> characters = new ArrayList<Character>();
        try {
            ResultSet rs = CRUDHelper.read(tableName);
            while (rs.next()) {
                characters.add(new Character(
                        rs.getInt("id"),
                        rs.getString("name"), rs.getString("alignment"),
                        rs.getString("backstory"),
                        rs.getString("background"),
                        rs.getString("personalityTraits"),
                        rs.getString("ideals"),
                        rs.getString("bonds"),
                        rs.getString("flaws"),
                        rs.getString("physicalDescription"),
                        rs.getString("politics"),
                        rs.getInt("proficiencyBonus"),
                        rs.getString("playerName"),
                        rs.getString("notes")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not extrapolate character result set because " + e.getCause()
            );
        }

        return characters;
    }

    public static void updateCharacter(int id, String[] colsToUpdate, Object[] updatedVals, int[] updatedValTypes) {
        CRUDHelper.update(tableName, id, colsToUpdate, updatedVals, updatedValTypes);
    }

    public static void deleteCharacter(int id) {
        CRUDHelper.delete(tableName, id);
    }

}
