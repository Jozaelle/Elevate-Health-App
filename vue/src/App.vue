<template>
  <div id="app">
     <div id="mySidenav" class="sidenav">
       <router-link tag="button" class="btn" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
       <router-link tag="button" class="btn" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
       <router-link tag="button" class="btn" v-bind:to="{ name: 'nutrition' }" v-if="$store.state.token != ''">Nutrition</router-link>&nbsp;&nbsp;
       <router-link tag="button" class="btn" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;
     </div>
    <div id="contents">
      <router-view />
    </div>
  </div>
</template>

<style scoped>
  #app {
    font-family: Arial, Helvetica, sans-serif;
}

 .btn{
    border-radius: 50%;
    height: 5.1em;
    width: 5.1em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 5px; 
    margin-bottom: 15px;
    color:ivory
 }
</style>

