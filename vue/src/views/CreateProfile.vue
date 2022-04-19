<template>
  <div class="profile-container">
      <profile-form v-bind:profile_id="parseInt($route.params.profile_id)"/>
    <br>
    <br>
<!-- TODO need to update passwords -->
    <form>
      <button type="button" v-on:click="toggleShowPassword">Update Password</button>
      <div v-if="showPassword">
        <label>Current Password</label>
        <br>
        <input type="text">
        <br>
        <br>
        <label>New Password</label>
        <br>
        <input type="text">
        <br>
        <br>
        <label>Confirm Password</label>
        <br>
        <input type="text">
        <br>
        <br>
      </div>
    </form>

  </div>
</template>

<script>
import ProfileForm from '../components/ProfileForm.vue'
export default {
  components: { ProfileForm },
  data() {
    return {
      showPassword : false
    }
  },
  methods:{
    toggleShowPassword(){
      this.showPassword = !this.showPassword;
    }
  }

}
</script>
<style scoped>
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
  height: 850px;
  border-radius: 25px;
}
</style>
