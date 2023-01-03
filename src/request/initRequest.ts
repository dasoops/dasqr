import axios from "axios";

let BASE_URL = "http://127.0.0.1:49012";

export function setBaseUrl(baseUrl: string) {
    BASE_URL = baseUrl;
}

export function getBaseUrl() {
    return BASE_URL;
}

export function initConfig() {
    axios({
        url: './application.json',
        method: 'GET',
    }).then(res => {
        BASE_URL = res.data.baseUrl;
    }).catch(error => {
        console.log(error);
    })
}