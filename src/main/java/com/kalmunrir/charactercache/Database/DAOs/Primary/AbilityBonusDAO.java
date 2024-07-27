package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.AbilityBonus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbilityBonusDAO {
    private static final String tableName = "AbilityBonuses";

    public static AbilityBonus getAbilityBonus(String ability, int bonus) {
        try {
            ResultSet rs = CRUDHelper.readByFields(tableName, new String[]{"ability", "bonus"},
                    new Object[]{ability, bonus}, new int[]{Types.VARCHAR, Types.INTEGER});
            if (rs.next()) {
                return new AbilityBonus(
                        rs.getInt("id"),
                        rs.getString("ability"),
                        rs.getInt("bonus")
                );
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze ability bonus result set because " + e.getCause()
            );
            return null;
        }
        return null;
    }

    public static AbilityBonus getAbilityBonusById(int id) {
        try {
            ResultSet rs = CRUDHelper.readById(tableName, id);
            if (rs.next()) {
                return new AbilityBonus(
                        rs.getInt("id"),
                        rs.getString("ability"),
                        rs.getInt("bonus")
                );
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze ability bonus result set because " + e.getCause()
            );
            return null;
        }
        return null;
    }
}
