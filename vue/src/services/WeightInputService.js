import axios from 'axios';

export default {

  createWeightInput(weightInput){
    return axios.post('/weight', weightInput)
  },

  getAllWeight(){
    return axios.get('/weight')
  },

  // getLastWeekWeight(){
  //   return axios.get(`/weight/week`)
  // },

  getWeightByMonth() {
    return axios.get(`/weight/month`)
  }

}
