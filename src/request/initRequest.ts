import axios from "axios";

export function initConfiguration() {
    return axios({
        url: './application.json',
        method: 'GET',
    })
}