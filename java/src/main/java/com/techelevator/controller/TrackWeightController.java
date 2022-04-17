package com.techelevator.controller;



import com.techelevator.dao.TrackWeightDao;
import com.techelevator.dao.UserDao;

import com.techelevator.model.TrackWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weight")

public class TrackWeightController {

    @Autowired
    private TrackWeightDao trackWeightDao;

    @Autowired
    private UserDao userDao;

    @PostMapping(path = "")
    public void createTrackWeight(@RequestBody TrackWeight trackWeight){
        trackWeightDao.createTrackWeight(trackWeight);
    }

    @GetMapping(path = "")
    public List<TrackWeight> getAllWeight(Principal principal){
        return trackWeightDao.getAllWeight(userDao.findIdByUsername(principal.getName()));
    }
}
