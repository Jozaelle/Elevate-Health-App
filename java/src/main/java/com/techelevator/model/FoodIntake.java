package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FoodIntake {

    private int food_intake_id;
    private int user_id;
    private String food_type;
    private float serving_size;
    private float number_of_servings;
    private String meal_type;

    //@JsonFormat(pattern = "yyyy/MM/dd")
    private Date day_of_meal;

    public FoodIntake(){

    }

    public int getFood_intake_id() {
        return food_intake_id;
    }

    public void setFood_intake_id(int food_intake_id) {
        this.food_intake_id = food_intake_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public float getServing_size() {
        return serving_size;
    }

    public void setServing_size(float serving_size) {
        this.serving_size = serving_size;
    }

    public float getNumber_of_servings() {
        return number_of_servings;
    }

    public void setNumber_of_servings(float number_of_servings) {
        this.number_of_servings = number_of_servings;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public Date getDay_of_meal() {
        return day_of_meal;
    }

    public void setDay_of_meal(Date day_of_meal) {
        this.day_of_meal = day_of_meal;
    }
}
