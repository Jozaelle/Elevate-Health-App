<template>
  <div class="home">
    <div id="emptyLeftSpace"></div>
    <LineChart class="grid-item" id="weightLineChart" :lineGraphData="weightLineGraphData" :lineGraphDates="weightLineGraphDates" />
    <BarChart class="grid-item" id="hydrationBarChart" :barGraphData="hydrationBarGraphData" />
    <DoughnutChart class="grid-item" id="nutritionPieChart" :pieGraphData="nutritionPieGraphData" />
  </div>
</template>

<script>
import foodIntakeService from '../services/FoodIntakeService'
import LineChart from '../components/Line.vue'
import DoughnutChart from '../components/Doughnut.vue'
import BarChart from '../components/Bar.vue'
import WeightInputService from "@/services/WeightInputService";


export default {
  name: "home",
  components:{
    LineChart,
    DoughnutChart,
    BarChart,
  },

  data() {
    return{
      foodIntake: [],
      // this is inputted as prop for the weight line graph
      weightObject: [],
      weightLineGraphData: [],
      weightLineGraphDates: [],

      //TODO pie chart graph set this from database
      nutritionPieGraphData: [33, 20, 80, 10],

      // this is inputted as prop for hydration bar graph
      hydrationBarGraphData: [40, 20, 12, 39, 10, 40, 39, 80, 40, 20, 12]
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
  /*border: 20px solid rgba(0, 0, 0, 0.8);*/
  /*padding: 20px;*/
  text-align: center;
  /*display: flex;*/
  /*justify-content: center;*/

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
