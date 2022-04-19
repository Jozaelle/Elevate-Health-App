<template>
  <div class="home loading">
    <div id="emptyLeftSpace"></div>
    <div id="weightLineChart" v-if="isLoadingLineGraph">
      <h1 id="graphTitle">Weight</h1>
      <LineChart class="grid-item" :lineGraphData="weightLineGraphData" :lineGraphDates="weightLineGraphDates" />
      <button type="button" v-on:click="weightWeek">Week View</button>
      <button type="button" v-on:click="weightMonth">Month View</button>
      <button type="button" v-on:click="weightYear">Year View</button>
    </div>
    <div id="hydrationBarChart" v-if="isLoadingBarGraph">
      <h1 id="graphTitle">Hydration Bar Graph</h1>
      <BarChart class="grid-item" :barGraphData="hydrationBarGraphData" :barGraphRecommended="hydrationBarGraphRecommendedData" :barGraphDates="hydrationBarDates" />
      <button type="button" v-on:click="hydrationWeek">Week View</button>
      <button type="button" v-on:click="hydrationMonth">Month View</button>
      <button type="button" v-on:click="hydrationYear">Year View</button>
    </div>
    <div id="nutritionPieChart" v-if="isLoadingPieChart">
      <h1 id="graphTitle">Nutrition Pie Graph</h1>
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
      isLoadingLineGraph: false,
      isLoadingBarGraph: false,
      isLoadingPieChart: false,
      foodIntake: [],

      // this is inputted as prop for the weight line graph
      weightObject: [],
      weightLineGraphData: [],
      weightLineGraphDates: [],

      // this is inputted as prop for the pie/doughnut
      nutritionObject:[],
      nutritionPieGraphData: [],

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
    });
    WeightInputService.getAllWeight().then(response => {
      this.weightObject = response.data
      this.weightObject.forEach(weight => this.weightLineGraphData.push(weight.curr_weight))
      this.weightObject.forEach(weight => this.weightLineGraphDates.push(weight.curr_date))
      this.isLoadingLineGraph = true;
    });
    HydrationService.getAllHydrations().then(response => {
      this.hydrationObject = response.data
      this.hydrationObject.forEach(hydration => this.hydrationBarGraphData.push(hydration.amount_drank))
      this.hydrationObject.forEach(hydration => this.hydrationBarGraphRecommendedData.push(hydration.amount_drank))
      this.hydrationObject.forEach(hydration => this.hydrationBarDates.push(hydration.curr_date))
      this.isLoadingBarGraph = true;
    })
    Nutrition.getNutritionByDate().then(response => {
      this.nutritionObject = response.data;
      this.nutritionPieGraphData.push(this.nutritionObject.calories)
      this.nutritionPieGraphData.push((this.nutritionObject.carbs))
      this.nutritionPieGraphData.push(this.nutritionObject.fats)
      this.nutritionPieGraphData.push(this.nutritionObject.proteins)
      this.isLoadingPieChart = true;
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
    weightWeek() {
      this.isLoadingLineGraph = false;
      WeightInputService.getWeightLastWeek().then(response => {
        this.weightObject = response.data
        this.weightLineGraphData = []
        this.weightLineGraphDates = []
        this.weightObject.forEach(weight => this.weightLineGraphData.push(weight.curr_weight))
        this.weightObject.forEach(weight => this.weightLineGraphDates.push(weight.curr_date))
        this.isLoadingLineGraph = true;
      })
    },
    weightMonth() {
      this.isLoadingLineGraph = false;
      WeightInputService.getWeightByMonth().then(response => {
        this.weightObject = response.data
        this.weightLineGraphData = []
        this.weightLineGraphDates = []
        this.weightObject.forEach(weight => this.weightLineGraphData.push(weight.curr_weight))
        this.weightObject.forEach(weight => this.weightLineGraphDates.push(weight.curr_date))
        this.isLoadingLineGraph = true;
      })

    },
    weightYear() {
      this.isLoadingLineGraph = false;
      WeightInputService.getWeightLastYear().then(response => {
        this.weightObject = response.data
        this.weightLineGraphData = []
        this.weightLineGraphDates = []
        this.weightObject.forEach(weight => this.weightLineGraphData.push(weight.curr_weight))
        this.weightObject.forEach(weight => this.weightLineGraphDates.push(weight.curr_date))
        this.isLoadingLineGraph = true;
      })
    },
     hydrationWeek() {
       this.isLoadingBarGraph = false
      HydrationService.getHydrationByWeek().then(response => {
        this.hydrationObject = response.data
        this.hydrationBarGraphData = []
        this.hydrationBarGraphRecommendedData = []
        this.hydrationBarDates = []
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphData.push(hydration.amount_drank))
        // TODO need to add recommended
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphRecommendedData.push(hydration.amount_drank))
        this.hydrationObject.forEach(hydration => this.hydrationBarDates.push(hydration.curr_date))
        this.isLoadingBarGraph = true
      })
    },
    hydrationMonth() {
      this.isLoadingBarGraph = false
      HydrationService.getHydrationLastMonth().then(response => {
        this.hydrationObject = response.data
        this.hydrationBarGraphData = []
        this.hydrationBarGraphRecommendedData = []
        this.hydrationBarDates = []
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphData.push(hydration.amount_drank))
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphRecommendedData.push(hydration.amount_drank))
        this.hydrationObject.forEach(hydration => this.hydrationBarDates.push(hydration.curr_date))
        this.isLoadingBarGraph = true
      })
    },
    hydrationYear() {
      this.isLoadingBarGraph = false
      HydrationService.getHydrationLastYear().then(response => {
        this.hydrationObject = response.data
        this.hydrationBarGraphData = []
        this.hydrationBarGraphRecommendedData = []
        this.hydrationBarDates = []
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphData.push(hydration.amount_drank))
        this.hydrationObject.forEach(hydration => this.hydrationBarGraphRecommendedData.push(hydration.amount_drank))
        this.hydrationObject.forEach(hydration => this.hydrationBarDates.push(hydration.curr_date))
        this.isLoadingBarGraph = true

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
