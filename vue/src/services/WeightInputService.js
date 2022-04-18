import axios from 'axios';

export default {

  createWeightInput(weightInput){
    return axios.post('/weight', weightInput)
  },

  getAllWeight(){
    return axios.get('/weight')
  }

}
