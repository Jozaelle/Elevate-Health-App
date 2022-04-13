<template>
  <div class="home">
    <h1>Home</h1>
    <br>
    <br>
    <div id="tableholder">
      <table>
        <thead>
          <th>Food Type</th>
          <th>Serving Size</th>
          <th>Number Of Servings</th>
          <th>Meal Type</th>
          <th>Date</th>
        </thead>
        <tbody>
          <tr v-for="intake in foodIntake" v-bind:key="intake.id">
            <td>{{intake.food_type}}</td>
            <td>{{intake.serving_size}}</td>
            <td>{{intake.number_of_servings}}</td>
            <td>{{intake.meal_type}}</td>
            <td>{{intake.day_of_meal}}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <router-link :to="{ name: 'food-intake' }">Add Food Link</router-link>
  </div>
</template>

<script>
import foodIntakeService from '../services/FoodIntakeService'

export default {
  name: "home",
  data() {
    return{
      foodIntake: []
    }
  },
  created(){
    foodIntakeService.getAllFoodIntakes().then(response => {
      this.foodIntake = response.data
    });
  }
};
</script>

<style scoped>
table {
  width: 800px;
  border-collapse: collapse;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th, td {
  padding: 15px;
  background-color: rgba(255,255,255,0.2);
  color: black;
}

th {
  text-align: left;
  background-color: #55608f;
}



</style>
