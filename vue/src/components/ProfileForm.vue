<template>
  <div>
    <form v-on: submit.prevent>

      <h1>Create Profile</h1>

    <label for="display-name">Display Name: </label>
    <br>
    <input type="text" placeholder="Display Name" v-model="profile.display_name">
    <br>
    <br>

    <label for="">Age: </label>
    <br>
    <input type="number" id="age" name="age"
       min="18" max="100" v-model="profile.age">
    <br>
    <br>

    <label for="">Height - feet: </label>
    <br>
    <input type="number" id="height-feet" name="height-feet"
       min="0" max="8" v-model="profile.height_feet">
    <br>
    <br>

    <label for="">Height - inches: </label>
    <br>
    <input type="number" id="height-inches" name="height-inches"
       min="0" max="11" v-model="profile.height_inches">
    <br>
    <br>

    <label for="">Current Weight: </label>
    <br>
    <input type="number" id="weight" name="weight"
       min="100" max="1000" v-model="profile.current_weight">
    <br>
    <br>

    <label for="">Goal Weight: </label>
    <br>
    <input type="number" id="goal-weight" name="goal-weight"
       min="100" max="1000" v-model="profile.goal_weight">
    </form>
    <br>

    <button type="submit" v-on:click="saveProfile()">Submit</button>
  </div>
</template>

<script>
import profileService from "@/services/ProfileService.js"
export default {
    data() {
    return {
      profile: {
         user_id:"1",
         display_name: "",
         age:"" ,
         height_feet:"" ,
         height_inches:"" ,
         current_weight:"" ,
         goal_weight: ""
      }
    };
  },
  methods: {
    saveProfile() {
       profileService
        .createProfile(this.profile)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push("/profile");
          }
        })
    }
  }
}
</script>

<style>

</style>