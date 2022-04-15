import axios from 'axios';

export default {

  createFoodIntake(foodIntake){
    return axios.post('/foodIntake', foodIntake)
  },
  getAllFoodIntakes(){
    return axios.get(`/foodIntake/getAll`)
  },
  deleteFoodIntake(id){
    return axios.delete(`foodIntake/${id}`)
  },

  editFoodIntake(id){
    return axios.put(`/foodIntake/edit/${id}`)
  }

}
