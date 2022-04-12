import axios from "axios";

export default {

    createProfile(profile) {
        return axios.post('/profile', profile)
    },
    getProfile(profile_id){
        return axios.get(`/profile/${profile_id}`)
    }
}