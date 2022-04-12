package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Profile addProfile(@RequestBody Profile data, Principal principal) {
        data.setUser_id(userDao.findIdByUsername(principal.getName()));
        return profileDao.addProfile(data);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Profile getProfileById(Principal principal) {
        return profileDao.getProfileById(userDao.findIdByUsername(principal.getName()));
    }
}
