import axios from 'axios';

export default {

  createFoodIntake(foodIntake){
    return axios.post('/foodIntake', foodIntake)
  },

}
