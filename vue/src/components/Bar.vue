<template>
  <Bar
      :chart-options="chartOptions"
      :chart-data="chartData"
      :chart-id="chartId"
      :dataset-id-key="datasetIdKey"
      :plugins="plugins"
      :css-classes="cssClasses"
      :styles="styles"
      :width="width"
      :height="height"
      :barGraphData="barGraphData"
      :barGraphRecommended="barGraphRecommended"
      :barGraphDates="barGraphDates"
  />
</template>

<script>
import { Bar } from 'vue-chartjs/legacy'

import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale
} from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
  name: 'BarChart',
  components: {
    Bar
  },
  props: {
    chartId: {
      type: String,
      default: 'bar-chart'
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
    barGraphData: {
      type: Array
    },
    barGraphRecommended: {
      type: Array
    },
    barGraphDates: {
      type: Array
    }
  },
  data() {
    return {

      profile: {},
      chartData: {
        labels: this.barGraphDates,
        datasets: [
          {
            label: 'Current Hydration',
            backgroundColor: '#f87979',
            data: this.barGraphData
          },
          {
            label: 'Recommended Hydration',
            backgroundColor: 'rgba(132,169,255,0.62)',
            data: this.barGraphRecommended,
          },
        ]
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
      }
    }
  },
}
</script>
