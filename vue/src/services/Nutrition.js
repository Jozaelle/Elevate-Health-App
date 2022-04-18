import axios from 'axios';
//import FoodIntakeService from '../services/FoodIntakeService';

export default {

  createFoodIntake(foodIntake){
    return axios.post('/nutrition', foodIntake)
  },
  getAllFoodIntakes(){
    return axios.get(`/nutrition/getAll`)
  },
  deleteFoodIntake(id){
    return axios.delete(`nutrition/${id}`)
  }

}