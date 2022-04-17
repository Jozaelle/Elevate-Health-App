<template>
  <div>
    <form @submit.prevent="createWeight">
      <label for="hydration">How much did you weigh today?</label>
      <br>
      <br>
      <input v-model="weight.weight" type="number" id="weight" name="weight"
       min="0" max="1000" />&nbsp; Pounds
       <br>
       <br>
      <input v-model="weight.curr_date" type="date" />&nbsp;
      <br>
      <br>
       <button type="submit">Submit</button>
      </form>
  </div>
</template>

<script>
import WeightInputService from "@/services/WeightInputService";
export default {
  components: {},
  data() {
        return {
            weight: {
              weight_id: "",
              user_id: "",
              curr_date: "",
              weight: ""
            },
        }
    },
  methods: {
    createWeight() {
      WeightInputService.createWeightInput(this.weight)
      this.weight = {
        weight_id: "",
        user_id: "",
        curr_date: "",
        weight: ""
      }
    }
  }
}
</script>

<style>

</style>