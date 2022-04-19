<template>
<div>
  <h1>Pie Chart</h1>
  <Doughnut
      :chart-options="chartOptions"
      :chart-data="chartData"
      :chart-id="chartId"
      :dataset-id-key="datasetIdKey"
      :plugins="plugins"
      :css-classes="cssClasses"
      :styles="styles"
      :width="width"
      :height="height"
      :pieGraphData="pieGraphData"
  />
  </div>
</template>

<script>
//import Nutrition from "@/services/Nutrition";
import { Doughnut } from 'vue-chartjs/legacy'
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  ArcElement,
  CategoryScale
} from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale)

export default {
  name: 'DoughnutChart',
  components: {
    Doughnut
  },

  props: {
    chartId: {
      type: String,
      default: 'doughnut-chart'
    },
    datasetIdKey: {
      type: String,
      default: 'label'
    },
    width: {
      type: Number,
      default: 400
    },
    height: {
      type: Number,
      default: 400
    },
    cssClasses: {
      default: '',
      type: String
    },
    styles: {
      type: Object,
      default: () => {}
    },
    plugins: {
      type: Array,
      default: () => []
    },
    pieGraphData:{
      type: Array
    }
  },
  data() {
    return {
      chartData: {
        labels: ['Calories', 'Proteins', 'Fats', 'Carbs'],
        datasets: [
          {
            backgroundColor: ['#41B883', '#E46651', '#00D8FF', '#DD1B16'],
            data: this.pieGraphData
          }
        ]
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false
      },

        // carbs: "",
        // proteins: "",
        // fats: "",
        // number_of_servings: "",
        // totalCalories: "",
        // percentCarbs: "",
        // percentProteins: "",
        // percentFats: "",

      
    }
  },

  // methods: {
  //   totalOfCalories(carbs, proteins, fats) {
  //       this.totalCalories = (carbs + proteins + fats)
  //    },

  //   percentOfCarbs() {
  //       this.percentCarbs = (((this.carbs * 100) / this.totalCalories) * this.number_of_servings)
  //   },

  //   percentOfProteins() {
  //     this.percentProteins = ((this.proteins * 100) / this.totalCalories)
  //   },

  //   percentOfFats() {
  //     this.percentFats = ((this.fats * 100) / this.totalCalories)
  //   },

  // }
}
</script>
