<template>
   <div>
    <div>
      <table>
        <thead>
          <th>Date</th>
          <th>Ounces</th>
          <th>Edit</th>
          <th>Delete</th>
        </thead>
        <tbody>
          <tr v-for="hydration in hydrationArray" v-bind:key="hydration.hydration_id">
            <td>{{hydration.curr_date}}</td>
            <td>{{hydration.amount_drank}}</td>
            <td>
              <router-link tag="button" :to="{ name: 'hydrationID', 
              params: {hydrationID: hydration.hydration_id} }">Edit</router-link>
            </td>
             <td>
              <button v-on:click="deleteHydration(hydration.hydration_id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
       <router-link :to="{ name: 'hydrationID', params: {hydrationID: 0}}" id="add-link">Add Ounces</router-link>
    </div>
  </div>
</template>

<script>

import HydrationService from '@/services/HydrationService'

export default {

data() {

    return{
      hydrationArray: []
    }   
},

created(){
    HydrationService.getHydrationByWeek().then(response => {
      this.hydrationArray = response.data
    });
   },

 methods: {
    deleteHydration(id) {
      HydrationService.deleteHydration(parseInt(id)).then(() => {
        this.reloadTable()
      })
    },
    reloadTable() {
      HydrationService.getAllWeight().then(response => {
        this.hydrationArray = response.data
      })
    }, 
 }  

}

</script>

<style>

table {
  margin-top: 100px;
  overflow: hidden;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 10%), 0 6px 20px 0 rgb(0 0 0 / 10%);
  
 position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /* shadow  */
  opacity: 0.9;
  
  background-color:#e8f7f7;
  
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  width: 450px;
  height: 930px;
  border-radius: 25px;
}

th, td {
  padding: 15px;
  background-color: rgba(255,255,255,0.2);
  color: black;
}

th {
  text-align: left;
  background-color: #0ba59d;
  color: #e8f7f7
}

tr:hover {
       background-color: rgba(255,255,255,0.3);
}

td{
  position: relative;
}

td:hover::before{
        content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
}
/* #add-link{
  position: absolute;
  top: 7%;
  left: 46%;
  text-align: center;
  font-size: small;
  font-weight: bold;
  font-family:Verdana, Geneva, Tahoma, sans-serif, 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif

} */

#add-link{
  position: absolute;
  top: 1%;
  left: 43%;
  text-align: center;
  opacity: 0.9;
  font-size: small;
  font-weight: bold;
  font-family:Verdana, Geneva, Tahoma, sans-serif, 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  
  background-color: #0ba59d;
  color: #e8f7f7;
  padding: 1em 1.5em;
  text-decoration: none;
  text-transform: uppercase;
  border-radius: 10px
}

</style>