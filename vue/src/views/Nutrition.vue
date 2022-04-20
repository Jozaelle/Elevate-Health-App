<template>
  <div class="nutrition-container">

    <!-- <input type="button" onClick="document.getElementById('middle').scrollIntoView();" /> -->

   <!-- <button type="button" v-on:click="toggleShowNutrition">Nutrition</button> -->
    <div id="tableholder" class="grid-item">
      <table>
        <thead>
          <th>Food Type</th>
          <th>Serving Size</th>
          <th>Number Of Servings</th>
          <th>Meal Type</th>
          <th>Date</th>
          <th>Edit</th>
          <th>Delete</th>
        </thead>
        <tbody>
          <tr v-for="intake in foodIntake" v-bind:key="intake.id">
            <td>{{intake.food_type}}</td>
            <td>{{intake.serving_size}}</td>
            <td>{{intake.number_of_servings}}</td>
            <td>{{intake.meal_type}}</td>
            <td>{{intake.day_of_meal}}</td>
            <td>
              <router-link tag="button" :to="{ name: 'food-intake', 
              params: {foodIntakeID: intake.food_intake_id} }">Edit</router-link>
            </td>
            <td>
              <button v-on:click="deleteFood(intake.food_intake_id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
          <router-link :to="{ name: 'food-intake', params: {foodIntakeID: 0}}" id="add-link">Add Food</router-link>
    </div>
     
    
  </div>
  
</template>


<script >

import foodIntakeService from '../services/FoodIntakeService'

export default {
  
  components: { },

   data() {
    return{
      foodIntake: [],
      }

   },

   created(){
    foodIntakeService.getLastWeek().then(response => {
      this.foodIntake = response.data
    });
   },

  methods: {
    
     deleteFood(id) {
      foodIntakeService.deleteFoodIntake(parseInt(id)).then(() => {
        this.reloadTable()
      })
    },
    reloadTable() {
      foodIntakeService.getAllFoodIntakes().then(response => {
        this.foodIntake = response.data
      })
    },
    
  }
};
</script>

<style scoped>

table {
  margin-top: 100px;
  overflow: hidden;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 10%), 0 6px 20px 0 rgb(0 0 0 / 10%);
  padding-bottom: 90px;
 position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /* shadow  */
  opacity: 0.9;
  
  background-color:#e8f7f7;
  
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  width: 450px;
  height: 930px;
  border-radius: 25px;
}

th, td {
  padding: 15px;
  background-color: rgba(255,255,255,0.2);
  color: black;
}

th {
  text-align: left;
  background-color: #ff4658;
}

tr:hover {
       background-color: rgba(255,255,255,0.3);
}

td{
  position: relative;
}

td:hover::before{
        content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
}
#add-link{
  position: absolute;
  top: 2%;
  left: 43%;
  text-align: center;
  font-size: xx-large;
  font-family:Verdana, Geneva, Tahoma, sans-serif, 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  
  background-color: rgb(255, 133, 133);
  color: white;
  padding: 1em 1.5em;
  text-decoration: none;
  text-transform: uppercase;
}

</style>

