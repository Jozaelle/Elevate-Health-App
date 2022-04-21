<template>
    <div>
      <router-link :to="{ name: 'weightInputID', params: {weightInputID: 0}}" id="add-link">Add Current Weight</router-link>
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
              <router-link class="btnStyled" tag="button" :to="{ name: 'weightInputID',
              params: {weightInputID: weight.weight_id} }">Edit</router-link>
            </td>
             <td>
              <button class="btnStyled" v-on:click="deleteWeight(weight.weight_id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
</template>


<script >

import WeightInputService from '@/services/WeightInputService'

export default {

  components: {  },

   data() {
    return{
      weightArray: []
    }
   },

   created(){
    WeightInputService.getWeightLastWeek().then(response => {
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
   
  }
};
</script>

<style scoped>
table {
  text-align: center;
  max-height: 50px;
  margin: auto;
  /* shadow  */
  opacity: 0.9;
  background-color:#e8f7f7;
  box-shadow: 0 20px 15px 0 rgb(0 0 0 / 40%), 0 6px 20px 0 rgb(0 0 0 / 40%);
  border-radius: 25px;
}

th, td {
  padding: 15px;
  background-color: rgba(255,255,255,0.3);
  color: black;
}

th {
  text-align: left;
  background-color: #0ba59d;
  color: #e8f7f7
}

tr:hover {
       background-color: rgba(255,255,255,0.4);
}

td{
  position: relative;
}

#add-link{

  display: flex;
  height: 20px;
  width: 200px;
  margin: 20px auto 5px;
  text-align: center;
  opacity: 0.9;
  font-size: small;
  font-weight: bold;
  font-family:Verdana, Geneva, Tahoma, sans-serif, 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  
  background-color: #0ba59d;
  color: #e8f7f7;
  padding: 10px 10px;

  text-decoration: none;
  text-transform: uppercase;
  border-radius: 10px
}


</style>
