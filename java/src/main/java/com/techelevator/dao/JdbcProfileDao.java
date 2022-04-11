package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JdbcProfileDao implements ProfileDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Profile addProfile(Profile data) {
        String sql = "INSERT INTO profile (user_id, display_name, age, height_feet, height_inches, current_weight, goal_weight) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING profile_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, data.getUser_id(), data.getDisplay_name(), data.getAge(), data.getHeight_feet(), data.getHeight_inches(), data.getCurrent_weight(), data.getGoal_weight());
        return getProfileById(id);
    }

    @Override
    public Profile getProfileById(int profile_id) {
        String sql = "SELECT * FROM profile WHERE profile_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, profile_id);

        Profile result = null;
        if (resultSet.next()) {
            result = mapRowToProfile(resultSet);
        }
        return result;
    }

    @Override
    public Profile deleteProfile(int profile_id) {
        return null;
    }

    @Override
    public Profile updateProfile(int profile_id) {
        return null;
    }

    private Profile mapRowToProfile(SqlRowSet resultSet) {
        Profile profile = new Profile();
        profile.setProfile_id(resultSet.getInt("profile_id"));
        profile.setUser_id(resultSet.getInt("user_id"));
        profile.setAge(resultSet.getInt("age"));
        profile.setHeight_feet(resultSet.getInt("height_feet"));
        profile.setHeight_inches(resultSet.getInt("height_inches"));
        profile.setCurrent_weight(resultSet.getInt("current_weight"));
        profile.setGoal_weight(resultSet.getInt("goal_weight"));
        return profile;
    }
}
