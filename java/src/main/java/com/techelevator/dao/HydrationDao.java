package com.techelevator.dao;

import com.techelevator.model.FoodIntake;
import com.techelevator.model.Hydration;

import java.util.List;

public interface HydrationDao {

    // get all hydration by id
    List<Hydration> getAllHydration(int user_id);

    // create hydration
    void createHydration(Hydration hydrationToCreate);

    public List<Hydration> getLastWeekHydration(int user_id);

    public List<Hydration> getLastMonthHydration(int user_id);

    public List<Hydration> getLastYearHydration(int user_id);


}
