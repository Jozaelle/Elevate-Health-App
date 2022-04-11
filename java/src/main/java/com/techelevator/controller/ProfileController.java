package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Profile addProfile(@RequestBody Profile data) {
        return profileDao.addProfile(data);
    }

    @RequestMapping(path = "/{profile_id}", method = RequestMethod.GET)
    public Profile getProfileById(@PathVariable int profile_id) {
        return profileDao.getProfileById(profile_id);
    }
}
