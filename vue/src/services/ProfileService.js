import axios from "axios";

export default {

    createProfile(profile) {
        return axios.post('/addProfile', profile)
    }
}