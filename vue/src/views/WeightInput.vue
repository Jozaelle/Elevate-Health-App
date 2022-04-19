<template>
  <div id="weight">
    <form @submit.prevent="createWeight" >
      <label for="weight">Weight Update?</label>
      <br>
      <br>
      <input v-model="weight.curr_weight" type="number"  name="weight"
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
import WeightInputService from "../components/WeightInput.vue";
export default {
  data() {
        return {
            weight: {
              weight_id: "",
              user_id: "",
              curr_date: "",
              curr_weight: ""
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
        curr_weight: ""
      }
    }
  }
}
</script>

<style>
#weight{
  margin-top: 100px;
  overflow: hidden;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 10%), 0 6px 20px 0 rgb(0 0 0 / 10%);
  
 position: absolute;
  top: 35%;
  left: 51%;
  transform: translate(-50%, -50%);
  text-align: center;


  /* shadow  */
  height: 300px;
  opacity: 0.9;
  background-color:rgb(255, 255, 255);
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  border-radius: 25px;


  
}
</style>