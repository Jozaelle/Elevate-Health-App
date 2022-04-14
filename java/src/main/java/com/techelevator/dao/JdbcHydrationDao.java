package com.techelevator.dao;

import com.techelevator.model.Hydration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcHydrationDao implements HydrationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Hydration> getAllHydration(int user_id) {
        List<Hydration> hydrationList = new ArrayList<>();
        String sql = "SELECT * FROM hydration WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,user_id);
        while (results.next()){
            hydrationList.add(mapRowToHydration(results));
        }
        return hydrationList;
    }

    @Override
    public void createHydration(Hydration hydrationToCreate) {
        String sql = "INSERT INTO hydration (user_id, curr_date, amount_drank)" +
                " VALUES (?,?,?)";
        jdbcTemplate.queryForRowSet(sql, hydrationToCreate.getUser_id(),
                hydrationToCreate.getCurr_date(), hydrationToCreate.getAmount_drank());
    }

    private Hydration mapRowToHydration(SqlRowSet results) {
        Hydration hydration = new Hydration();
        hydration.setHydration_id(results.getInt("hydration_id"));
        hydration.setAmount_drank(results.getFloat("amount_drank"));
        hydration.setCurr_date(results.getDate("curr_date"));
        hydration.setUser_id(results.getInt("user_id"));
        return hydration;
    }
}