<template>
 
  <div id="app">
    <div id="nav">
      
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
    </div>
     
    <router-view />
    
  </div>
</template>
<script>
export default {
  
}
</script>


<style scoped>
  #app {
    font-family: Arial, Helvetica, sans-serif;
}
  #nav{
    
   display: flex;
  flex-direction: row;
  justify-content: center;

  position: absolute;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
    
    
  }
 
  


</style>

