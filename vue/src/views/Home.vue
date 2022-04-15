<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
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
              <button @click="$router.push('Food-Intake')">Edit</button>
            </td>
            <td>
              <button v-on:click="deleteFood(intake.food_intake_id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <br>
    <router-link :to="{ name: 'food-intake' }">Add Food Link</router-link>
    <LineChart :lineGraphData="weightLineGraphData" />
    <DoughnutChart />
    <BarChart />
  </div>
</template>

<script>
import foodIntakeService from '../services/FoodIntakeService'
import LineChart from '../components/Line.vue'
import DoughnutChart from '../components/Doughnut.vue'
import BarChart from '../components/Bar.vue'


export default {
  name: "home",
  components:{
    LineChart,
    DoughnutChart,
    BarChart
  },

  data() {
    return{
      foodIntake: [],
      //TODO weight line graph get this from database
      weightLineGraphData: [175, 182, 180, 178, 175, 177, 173]
    }
  },
  created(){
    foodIntakeService.getAllFoodIntakes().then(response => {
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
  width: 700px;
  border-collapse: collapse;
  overflow: hidden;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 10%), 0 6px 20px 0 rgb(0 0 0 / 10%);
  margin-bottom: 600px;
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
</style>
