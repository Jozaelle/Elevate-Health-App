<template>

  <div>

      <h1>{{profile.display_name}}</h1>
      <h3>Age: {{profile.age}}
      <br>
      <br>
      Height: {{profile.height_feet}}', {{profile.height_inches}}"
      <br>
      <br>
      Current Weight: {{profile.current_weight}} pounds | (Current BMI: {{bmi.toFixed(1)}})
      <br>
      <br>
      Goal Weight: {{profile.goal_weight}} pounds | (Goal BMI: {{bmiGoal.toFixed(1)}})
      <br>
      <br>
      </h3>

      <button @click="$router.push('create-profile')">Update Profile</button>

      
    </div>
</template>

<script >
import ProfileService from '@/services/ProfileService'

export default {
  name: "profile-detail",
  data() {
    return {
      isLoading: true,
      profile: {
         user_id:"",
         display_name: "",
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
      }
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
</style>
