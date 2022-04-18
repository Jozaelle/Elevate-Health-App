<template>
  <div>
    <form @submit.prevent="createHydration">
      <p>Daily Recommended Water Intake: {{recommended_hydration}} ounces</p>
      <label for="hydration">How Many 8 oz. Glasses of Water Did You Drink Today?</label>
      <br>
      <br>
      <input v-model="hydration.amount_drank" type="number" id="hydration" name="hydration"
       min="0" max="100" />&nbsp;
      <input v-model="hydration.curr_date" type="date" />&nbsp;
      <br>
      <br>
       <button type="submit">Submit</button>
      </form>
  </div>
</template>

<script>
import hydrationService from "@/services/HydrationService";
import ProfileService from "@/services/ProfileService";

export default {
  components: {},
  data() {
        return {
            hydration: {
              hydration_id: "",
              user_id: "",
              curr_date: "",
              amount_drank: ""
            },
            current_weight: "",
            recommended_hydration: ""
        }
    },
  created() {
    ProfileService.getProfile()
        .then( response => {
          this.current_weight = response.data.current_weight
          this.getRecommendedHydration(this.current_weight);
        })
  },
  methods: {
    createHydration() {
      hydrationService.createHydration(this.hydration)
      this.hydration = {
        hydration_id: "",
        user_id: "",
        curr_date: "",
        amount_drank: ""
      }
    },
    getRecommendedHydration(currentWeight){
      this.recommended_hydration = ((currentWeight * .5) * .8)
    }
  }
}
</script>

<style>

</style>