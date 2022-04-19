<template>
  <div class="home loading" v-if="isLoading">
    <div id="emptyLeftSpace"></div>
    <LineChart class="grid-item" id="weightLineChart" :lineGraphData="weightLineGraphData" :lineGraphDates="weightLineGraphDates" />
    <BarChart class="grid-item" id="hydrationBarChart" :barGraphData="hydrationBarGraphData" :barGraphRecommended="hydrationBarGraphRecommendedData" :barGraphDates="hydrationBarDates" />
    <DoughnutChart class="grid-item" id="nutritionPieChart" :pieGraphData="nutritionPieGraphData" />
  </div>
</template>

<script>
import foodIntakeService from '../services/FoodIntakeService'
import LineChart from '../components/Line.vue'
import DoughnutChart from '../components/Doughnut.vue'
import BarChart from '../components/Bar.vue'
import WeightInputService from "@/services/WeightInputService";
import HydrationService from "@/services/HydrationService";
import Nutrition from "@/services/Nutrition";


export default {
  name: "home",
  components:{
    LineChart,
    DoughnutChart,
    BarChart,
  },

  data() {
    return{
      isLoading: false,
      foodIntake: [],

      // this is inputted as prop for the weight line graph
      weightObject: [],
      weightLineGraphData: [],
      weightLineGraphDates: [],

      //TODO pie chart graph set this from database
      nutritionObject:[],
      nutritionPieGraphData: [],
          //[33, 20, 80, 10],

      // this is inputted as prop for hydration bar graph
      hydrationObject:[],
      hydrationBarGraphData: [],
      hydrationBarGraphRecommendedData: [],
      hydrationBarDates: [],

       carbs: "",
        proteins: "",
        fats: "",
        number_of_servings: "",
        totalCalories: "",
        percentCarbs: "",
        percentProteins: "",
        percentFats: "",
    }
  },
  created(){
    foodIntakeService.getLastWeek().then(response => {
      this.foodIntake = response.data
      this.isLoading =false;
    });
    WeightInputService.getAllWeight().then(response => {
      this.weightObject = response.data
      this.weightObject.forEach(weight => this.weightLineGraphData.push(weight.curr_weight))
      this.weightObject.forEach(weight => this.weightLineGraphDates.push(weight.curr_date))
    });
    HydrationService.getAllHydrations().then(response => {
      this.hydrationObject = response.data
      this.hydrationObject.forEach(hydration => this.hydrationBarGraphData.push(hydration.amount_drank))
      this.hydrationObject.forEach(hydration => this.hydrationBarGraphRecommendedData.push(hydration.amount_drank))
      this.hydrationObject.forEach(hydration => this.hydrationBarDates.push(hydration.curr_date))
    })
    Nutrition.getNutritionByDate().then(response => {
      this.nutritionObject = response.data;
      this.nutritionPieGraphData.push((this.nutritionObject.carbs*4))
      this.nutritionPieGraphData.push((this.nutritionObject.fats*9))
      this.nutritionPieGraphData.push((this.nutritionObject.proteins*4))
      this.isLoading=true;
    })
    Nutrition.getNutritionByDate()
      .then( response => {
        this.carbs = (response.data.carbs * 4)
        this.proteins = (response.data.proteins * 4)
        this.fats = (response.data.fats * 9)
        this.totalOfCalories(this.carbs, this.proteins, this.fats)
        this.percentOfCarbs()
        this.percentOfProteins()
        this.percentOfFats()
    })
  },
  methods: {
     totalOfCalories(carbs, proteins, fats) {
        this.totalCalories = (carbs + proteins + fats)
     },

    percentOfCarbs() {
        this.percentCarbs = ((this.carbs * 100) / this.totalCalories)
    },

    percentOfProteins() {
      this.percentProteins = ((this.proteins * 100) / this.totalCalories)
    },

    percentOfFats() {
      this.percentFats = ((this.fats * 100) / this.totalCalories)
    },


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
    turnOnLoading(){
      this.isLoading = true
    }
  }
};
</script>

<style scoped>

.home{
  display: grid;
  grid-template-columns: 100px 30% 30% 30%;
  grid-template-areas: "empty weight weight weight"
                        "empty hydration hydration nutrition"
                        "empty tableHolder tableHolder tableHolder";
  padding-top: 20px;
  grid-gap: 10px;

}

.grid-item {
  background-color: rgba(255, 255, 255, .95);
  text-align: center;
}

#tableHolder{
  grid-area: tableHolder;
}
#hydrationBarChart{
  grid-area: hydration;
}
#nutritionPieChart{
  grid-area: nutrition;
}
#weightLineChart{
  grid-area: weight;
}
#emptyLeftSpace{
  grid-area: empty;
}
</style>
