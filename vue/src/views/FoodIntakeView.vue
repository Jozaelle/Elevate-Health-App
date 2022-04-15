<template>
  <div>
    <track-food-intake v-bind:foodIntakeID="parseInt($route.params.foodIntakeID)"/>
    <br>
    <br>
    <br>
    <hydration-input />
  </div>
</template>

<script>
import TrackFoodIntake from '../components/TrackFoodIntake.vue'
import HydrationInput from "@/components/HydrationInput";
export default {
  components: {HydrationInput, TrackFoodIntake },
}
</script>

<style>

</style>