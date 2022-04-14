import axios from 'axios';

export default {
    getAllHydrations(){
        return axios.get("")
    },

    createHydration(hydration){
        return axios.post("", hydration)
    }
}
