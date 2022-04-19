import axios from 'axios';

export default {
    getAllHydrations(){
        return axios.get("/hydration")
    },

    createHydration(hydration){
        return axios.post("/hydration", hydration)
    },

    getHydrationByWeek() {
        return axios.get(`/hydration/lastWeek`)
    },
    
}
