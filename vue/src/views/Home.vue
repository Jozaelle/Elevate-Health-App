<template>
  <div class="home loading" v-if="isLoading">
    <div id="emptyLeftSpace"></div>
    <div id="weightLineChart">
      <h1 id="graphTitle">Weight Line Graph</h1>
      <LineChart class="grid-item" :lineGraphData="weightLineGraphData" :lineGraphDates="weightLineGraphDates" />
    </div>
    <div id="hydrationBarChart">
      <h1 id="graphTitle">Weight Line Graph</h1>

      <BarChart class="grid-item" :barGraphData="hydrationBarGraphData" :barGraphRecommended="hydrationBarGraphRecommendedData" :barGraphDates="hydrationBarDates" />
    </div>
    <div id="nutritionPieChart">
      <h1 id="graphTitle">Weight Line Graph</h1>
      <DoughnutChart class="grid-item" id="nutritionPieChart" :pieGraphData="nutritionPieGraphData" />
    </div>
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

      // this is inputted as prop for the pie/doaghnut
      nutritionObject:[],
      nutritionPieGraphData: [],

      // this is inputted as prop for hydration bar graph
      hydrationObject:[],
      hydrationBarGraphData: [],
      hydrationBarGraphRecommendedData: [],
      hydrationBarDates: [],
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
      this.nutritionPieGraphData.push(this.nutritionObject.calories)
      this.nutritionPieGraphData.push((this.nutritionObject.carbs))
      this.nutritionPieGraphData.push(this.nutritionObject.fats)
      this.nutritionPieGraphData.push(this.nutritionObject.proteins)
      this.isLoading=true;
    })
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

.home{
  display: grid;
  grid-template-columns: 100px 30% 30% 30%;
  grid-template-areas: "empty weight weight weight"
                        "empty hydration hydration nutrition";
  padding-top: 20px;
  grid-gap: 10px;
}

.grid-item {
  background-color: rgba(255, 255, 255, .95);
  text-align: center;
  margin-bottom: 20px;
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

#graphTitle{
  text-align: center;
  margin: 0;
  padding-top: 10px;
  padding-bottom: 5px;
}
#weightLineChart{
  grid-area: weight;
}
#emptyLeftSpace{
  grid-area: empty;
}
</style>
