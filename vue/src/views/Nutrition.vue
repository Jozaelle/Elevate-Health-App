<template>
  <div class="nutrition-container">
    <p>Food Name: {{nutrition.food_name}}</p>
    <p>Date: {{nutrition.date}}</p>
  </div>
</template>

<script >
// import ProfileService from '@/services/ProfileService'
// import foodIntakeService from '../services/FoodIntakeService'
//import TrackFoodIntake from '../components/TrackFoodIntake.vue'
import FoodIntakeService from '../services/FoodIntakeService';
export default {

  
  methods: {
    log() {
      FoodIntakeService
        .log(this.foodIntake)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/nutrition");
          }
        })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

