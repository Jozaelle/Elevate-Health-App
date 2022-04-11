package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    Profile addProfile(Profile data);

    Profile getProfileById(int profile_id);

    Profile deleteProfile(int profile_id);

    Profile updateProfile(int profile_id);
}
