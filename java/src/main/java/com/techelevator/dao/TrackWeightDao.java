package com.techelevator.dao;

import com.techelevator.model.TrackWeight;

import java.util.List;

public interface TrackWeightDao {

    // get all weight by id
    List<TrackWeight> getAllWeight(int user_id);

    // create weight
    void createTrackWeight(TrackWeight weight);

    List<TrackWeight> WeightByMonth (int user_id);
}

