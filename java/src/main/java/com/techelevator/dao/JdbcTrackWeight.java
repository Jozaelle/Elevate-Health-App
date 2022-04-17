package com.techelevator.dao;

import com.techelevator.model.TrackWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcTrackWeight implements TrackWeightDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<TrackWeight> getAllWeight(int user_id) {

        List<TrackWeight> trackWeightList = new ArrayList<>();
        String sql = "SELECT * FROM weight WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,user_id);
        while (results.next()){
            trackWeightList.add(mapRowToWeight(results));
        }
        return trackWeightList;
    }

    @Override
    public void createTrackWeight(TrackWeight trackWeight) {

        String sql = "INSERT INTO (user_id, curr_date, curr_weight " +
                "VALUES (?, ?, ?)";
                jdbcTemplate.queryForRowSet(sql, trackWeight.getUser_id(), trackWeight.getCurr_date(),
                        trackWeight.getCurr_weight());

    }

    private TrackWeight mapRowToWeight(SqlRowSet results) {
        TrackWeight trackWeight = new TrackWeight();
        trackWeight.setWeight_id(results.getInt("weight_id"));
        trackWeight.setCurr_weight(results.getFloat("curr_weight"));
        trackWeight.setCurr_date(results.getDate("curr_date"));
        trackWeight.setUser_id(results.getInt("user_id"));
        return trackWeight;
    }
}
