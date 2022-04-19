<template>
  <div id="weight">
    <form @submit.prevent="submitWeight" >
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
import WeightInputService from "@/services/WeightInputService";
export default {
   props: {
    weightInputID: {
      type: Number,
      default: 0
    }
  },
  components: {},
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
    },

    submitForm() {

      if (this.weightInputID === 0) {
        WeightInputService
          .createWeightInput(this.weight)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/weight`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        WeightInputService
          .editWeight(this.weight)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/weight`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
  
  }
}
</script>

<style>
#weight{
 position: absolute;
  top: 350%;
  left: 54%;
  transform: translate(-50%, -50%);
  text-align: center;

  border-radius: 25px;
  background: #dfe5ff;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  width: 600px;
  height: 900px;
  padding-top: 50px;
  
}
</style>