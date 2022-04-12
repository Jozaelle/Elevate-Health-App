<template>
  <div>
    <form @submit.prevent="createFoodIntake">
      <h2>Food Intake Form</h2>
      <label for="food-type">Type of Food</label>
      <br />
      <input type="text" id="food-type" placeholder="Type of Food" v-model="foodIntake.food_type" />
      <br />
      <br />
      <label for="serving-size">Serving Size</label>
      <br />
      <input type="text" id="serving-size" placeholder="Serving Size" v-model="foodIntake.serving_size" />
      <br />
      <br />

      <label for="number-of-servings">Number of Servings</label>
      <br />
      <input
        type="text"
        id="number-of-servings"
        placeholder="Number of Servings"
        v-model="foodIntake.number_of_servings"
      />
      <br />
      <br />

      <label for="meal-type">Meal Breakfast/Lunch/Dinner/Snack</label>
      <br />
      <select name="meal-type" id="meal-type" v-model="foodIntake.meal_type">
        <option value="breakfast">Breakfast</option>
        <option value="lunch">Lunch</option>
        <option value="dinner">Dinner</option>
        <option value="snack">Snack</option>
      </select>
      <br />
      <br />
      <label>
        Enter the Date:
        <input type="date" name="meal-day" v-model="foodIntake.day_of_meal" />
      </label>
      <br />
      <br />
      <button type="submit" >Submit</button>
    </form>
  </div>
</template>

<script>

import foodIntakeService from '../services/FoodIntakeService'

export default {

data() {
  return {
    foodIntake: {
      user_id: "1",
      food_type: "",
      serving_size: "",
      number_of_servings: "",
      meal_type: "",
      day_of_meal: "",
    },
  }
},

methods: {

   createFoodIntake() {

    foodIntakeService.createFoodIntake(this.foodIntake)
  }
}

};
</script>

<style>
#meal-type {
  padding: 0.25rem 3rem 0.25rem 3rem;
}
</style>