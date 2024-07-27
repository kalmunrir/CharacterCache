package com.kalmunrir.charactercache.Database.DAOs.Primary;

import com.kalmunrir.charactercache.Database.DAOs.CRUDHelper;
import com.kalmunrir.charactercache.Database.Models.Primary.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JobDAO {
    private static final String tableName = "Jobs";

    public static Job createJob(String name, int hitDie, String spellCastingAbility) {
        int id = CRUDHelper.create(tableName,
                new String[]{"name", "hitDie", "spellCastingAbility"},
                new Object[]{name, hitDie, spellCastingAbility},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        if (id > 0) {
            return new Job(id, name, hitDie, spellCastingAbility);
        }
        return null;
    }

    public static ArrayList<Job> getJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet rs = CRUDHelper.read(tableName);
        try {
            while (rs.next()) {
                jobs.add(new Job(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hitDie"),
                        rs.getString("spellCastingAbility")
                ));
            }
            return jobs;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze jobs because " + e.getCause()
            );
            return null;
        }
    }

    public static Job getJobById(int id) {
        ResultSet rs = CRUDHelper.readById(tableName, id);
        try {
            if (rs.next()){
                return new Job(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hitDie"),
                        rs.getString("spellCastingAbility")
                );
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": could not analyze job because " + e.getCause()
            );
            return null;
        }
        return null;
    }
}
