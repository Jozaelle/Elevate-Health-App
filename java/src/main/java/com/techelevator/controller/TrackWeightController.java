package com.techelevator.controller;


import com.techelevator.dao.HydrationDao;
import com.techelevator.dao.TrackWeightDao;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/weight")

public class TrackWeightController {

    @Autowired
    private TrackWeightDao trackWeightDao;

    @Autowired
    private UserDao userDao;
}
