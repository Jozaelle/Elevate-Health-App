<template>
  
  <div id="app">
     <div id="mySidenav" class="sidenav">
       <img src="../public/elevate-logo.png" id="logo" >
       <router-link tag="button" class="btn" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
       <router-link tag="button" class="btn" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
      <div class="drop-down">
       <button class="dropbtn" v-on:click="nutritionDropDown" >Nutrition</button>
    
    <div id="myDropdown" v-if="showDropDown">
    <router-link  v-bind:to="{ name: 'water' }" class="btn1">Water</router-link>
    <br>
    <br>
    <router-link  v-bind:to="{ name: 'nutrition' }" class="btn2" >Food
    </router-link>
    <br>
    <br>
    <router-link  v-bind:to="{ name: 'weight' }" class="btn3" >Weight
      <br>
      <br>
    </router-link>
    
    </div>
      </div>
       <br>

       <router-link tag="button" class="btn-log" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;
     </div>
    <div id="contents">
      <router-view />
    </div>
  </div>

</template>

<script>
export default {
  name: "app",
  data(){
    return {
      showDropDown:false
    }
  },
  methods: {
    nutritionDropDown(){
      this.showDropDown = !this.showDropDown;
      
    }
  }
}
</script>

<style scoped>

  #app {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
}

 .btn{
    border-radius: 50%;
    height: 6em;
    width: 6em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
 }
 #logo{
    width: 125px;
    padding-left: 0px;
    padding-bottom: 30px;
    
 }
 
.dropbtn {
    border-radius: 50%;
    height: 6em;
    width: 6em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
}

.btn-log {
    border-radius: 50%;
    height: 6em;
    width: 6em;
    background-color: transparent;
    left: 0;
    margin-top: 200px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
}
.btn1{
    border-radius: 50%;
    height: 6;
    width: 6em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
 }
 .btn2{
    border-radius: 50%;
    height: 6em;
    width: 6em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
 }
 .btn3{
    border-radius: 50%;
    height: 6em;
    width: 6em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 22px; 
    margin-bottom: 15px;
    color:ivory
 }
</style>
 


