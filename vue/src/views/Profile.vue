<template>
  <div class="profile-container">
    <br>
    <br>
     <img :src="profile.photo" id="photo" alt="">
     <br>
    <p>Name: {{profile.display_name}}</p>
    <p>Birthday: {{profile.birthday}}</p>
    <p>Age: {{profile.age}}</p>
    <p>Height: {{profile.height_feet}}', {{profile.height_inches}}"</p>
    <p>Current Weight: {{profile.current_weight}} pounds | (Current BMI: {{bmi.toFixed(1)}})</p>
    <p>Goal Weight: {{profile.goal_weight}} pounds | (Goal BMI: {{bmiGoal.toFixed(1)}})</p>
    <button @click="$router.push('create-profile')">Update Profile</button>
    <weight-input />
    <hydration-input />
  </div>
</template>

<script >
import ProfileService from '@/services/ProfileService'
import FoodIntakeView from '@/views/FoodIntakeView.vue';
import WeightInput from '@/components/WeightInput';
import HydrationInput from '@/components/HydrationInput';

export default {
  components: { WeightInput, HydrationInput },
  name: "profile-detail",
  data() {
    FoodIntakeView
    return {
      isLoading: true,
      profile: {
         user_id:"",
         display_name: "",
         photo: "",
         birthday: "",
         age:"" ,
         height_feet:"" ,
         height_inches:"" ,
         current_weight:"" ,
         goal_weight: ""
      },
      bmi: "",
      bmiGoal: "",
    }
  },
  created() {
    
    ProfileService.getProfile()
      .then( response => {
        //response responding to http request specifically
        this.profile = response.data;
        this.calculateBMI();
        this.calculateGoalBMI();
        
      })
  },
  methods: {
      calculateBMI(){
         this.bmi = (this.profile.current_weight / ((this.profile.height_feet * 12 + this.profile.height_inches) * (this.profile.height_feet * 12 + this.profile.height_inches))) * 703
      },

      calculateGoalBMI() {
        this.bmiGoal = (this.profile.goal_weight / ((this.profile.height_feet * 12 + this.profile.height_inches) * (this.profile.height_feet * 12 + this.profile.height_inches))) * 703
      },
      
  }
};
</script>

<style scoped>
button {
  border: none;
  border-radius: 12px;
  color: black;
  padding: 15px 15px;
  text-align: center;
  box-shadow: 0 3px 3px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
}
.profile-container{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /* shadow  */
  background: #dfe5ff;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  width: 450px;
  height: 625px;
  border-radius: 25px;
}
#photo{
  width: 400px;
  height: 300px;

}
</style>
