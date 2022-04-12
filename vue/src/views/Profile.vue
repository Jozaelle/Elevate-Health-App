<template>

  <div>
      
      <svg></svg>

      <h1>{{profile.display_name}}</h1>
      <h2>Age: {{profile.age}}
      <br>
      Height: {{profile.height_feet}},{{profile.height_inches}}
      <br>

      Current Weight: {{profile.current_weight}}
      <br>
      Goal Weight: {{profile.goal_weight}}
      <br>
      BMI:
      </h2>
      
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
      }
    }
  },
  created() {
    
    ProfileService.getProfile()
      .then( response => {
        //response responding to http request specifically
        this.profile = response.data;
      })
  },
  methods: {
      calculateBMI(){
         (this.profile.current_weight / (this.profile.height_feet * 12 + this.profile.height_inches) * 703)
      }
  }
};
</script>
