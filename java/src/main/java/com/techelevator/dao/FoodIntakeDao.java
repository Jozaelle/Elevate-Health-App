package com.techelevator.dao;

import com.techelevator.model.FoodIntake;

import java.util.Date;
import java.util.List;

public interface FoodIntakeDao {

    // get all food intakes
    List<FoodIntake> getAll (int id);

    // get food by date
    List<FoodIntake> getByDate(Date date);

    // get by meal type
    List<FoodIntake> getByMealType(String mealType);

    // create food intake
    FoodIntake createFoodIntake (FoodIntake foodIntake);

    // get food intake id
    FoodIntake getFoodIntakeById(int id);

    // delete
    void deleteFoodIntakeById(int id);

}
