<template>
  <div>

   <!-- <button type="button" v-on:click="toggleShowNutrition">Nutrition</button> -->
    <div>
      <table>
        <thead>
          <th>Date</th>
          <th>Weight</th>
          <th>Edit</th>
          <th>Delete</th>
        </thead>
        <tbody>
          <tr v-for="weight in weightArray" v-bind:key="weight.weight_id">
            <td>{{weight.curr_date}}</td>
            <td>{{weight.curr_weight}}</td>
            <td>
              <router-link tag="button" :to="{ name: 'weightID', 
              params: {weightInputID: weight.weight_id} }">Edit</router-link>
            </td>
             <td>
              <button v-on:click="deleteWeight(weight.weight_id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  
</template>


<script >

import WeightInputService from '@/services/WeightInputService'

export default {
  
  components: {  },

   data() {
    return{
      weightArray: {
          weight_id: "",
          user_id: "",
          curr_date: "",
          curr_weight: ""
      }
      }
   },

   created(){
    WeightInputService.getAllWeight().then(response => {
      this.weightArray = response.data
    });
   },

  methods: {
     deleteWeight(id) {
      WeightInputService.deleteWeight(parseInt(id)).then(() => {
        this.reloadTable()
      })
    },
    reloadTable() {
      WeightInputService.getAllWeight().then(response => {
        this.weightArray = response.data
      })
    },
    toggleShowNutrition(){
      this.showNutrition.tableHolder = !this.showNutrition.tableHolder;
      
    }
  }
};
</script>

<style scoped>
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
  background-color: #ff4658;
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
#add-link{
  position: absolute;
  top: 7%;
  left: 46%;
  text-align: center;
  font-size: xx-large;
  font-family:Verdana, Geneva, Tahoma, sans-serif, 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif
  

}

</style>
