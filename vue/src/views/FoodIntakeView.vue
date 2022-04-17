<template>
  <div>
    <div class="containers">
      <track-food-intake v-bind:foodIntakeID="parseInt($route.params.foodIntakeID)"/>
      <br>
      <br>
      <hydration-input />
      <br>
      <br>
      <weight-input />
    </div>
  </div>
</template>

<script>
import TrackFoodIntake from '../components/TrackFoodIntake.vue'
import HydrationInput from "@/components/HydrationInput";
import WeightInput from '../components/WeightInput.vue';
export default {
  components: {HydrationInput, TrackFoodIntake, WeightInput },
}
</script>

<style>
.containers{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /* shadow  */
  background: #dfe5ff;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  width: 500px;
  height: 800px;
  border-radius: 25px;
}
</style>