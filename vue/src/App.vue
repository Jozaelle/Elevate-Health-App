<template>
 
  <div id="app">
    <div id="nav">
      
      
    </div>
     <div id="mySidenav" class="sidenav">
       <router-link tag="button" class="btn-2-btn-primary" id="nav-text" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
             <router-link tag="button" class="btn-3-btn-primary" id="nav-text" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
      <router-link tag="button" class="btn-4-btn-primary" id="nav-text" v-bind:to="{ name: 'nutrition' }" v-if="$store.state.token != ''">Nutrition</router-link>&nbsp;&nbsp;
            <router-link tag="button" class="btn-5-btn-primary" id="nav-text" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;

          
  
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
  #nav{
    
   display: flex;
  flex-direction: row;
  justify-content: center;
  position: absolute;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  }
 .btn-2-btn-primary{
   border-radius: 50%;
    height: 5.1em;
    width: 5.1em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 5px; 
    margin-bottom: 15px;
 }
 .btn-3-btn-primary{
   border-radius: 50%;
    height: 5.1em;
    width: 5.1em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 5px; 
    margin-bottom: 15px;
    
 }
 .btn-4-btn-primary{
   border-radius: 50%;
    height: 5.1em;
    width: 5.1em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 5px; 
    margin-bottom: 15px;
 }
 .btn-5-btn-primary{
   border-radius: 50%;
    height: 5.1em;
    width: 5.1em;
    background-color: transparent;
    top: 0;
    left: 0;
    margin-top: 5px;
    margin-left: 5px; 
    
    
 }
 
  
 .contents{
   
 }
 #nav-text{
   color:ivory
 }
  


</style>

