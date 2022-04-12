package com.techelevator.controller;

import com.techelevator.dao.FoodIntakeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FoodIntake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/foodIntake")
public class FoodIntakeController {

    @Autowired
    private FoodIntakeDao foodIntakeDao;

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/getAll")
    public List<FoodIntake> getAll(Principal principal){
        return foodIntakeDao.getAll(userDao.findIdByUsername(principal.getName()));
    }

    @GetMapping(path = "/get/{id}")
    public FoodIntake getFoodIntakeId(@PathVariable int id){
        return foodIntakeDao.getFoodIntakeById(id);
    }

    @GetMapping(path = "/getByDate/{date}")
    public List<FoodIntake> getByDate(@PathVariable Date date){
        return foodIntakeDao.getByDate(date);
    }

    @GetMapping(path = "/getByMealType/{type}")
    public List<FoodIntake> getByMealType (@PathVariable String type){
        return foodIntakeDao.getByMealType(type);
    }

    @PostMapping(path = "")
    public FoodIntake createFoodIntake(@RequestBody FoodIntake foodIntake, Principal principal){
        foodIntake.setUser_id(userDao.findIdByUsername(principal.getName()));
        return foodIntakeDao.createFoodIntake(foodIntake);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFoodIntakeById(@PathVariable int id){
        foodIntakeDao.deleteFoodIntakeById(id);
    }


}