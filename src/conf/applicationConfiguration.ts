import {initConfiguration} from "@/request/initRequest";

let BASE_URL: string | undefined;

await initConfiguration().then(res => {
    setBaseUrl(res.data.baseUrl);
});

export function setBaseUrl(baseUrl: string) {
    BASE_URL = baseUrl;
}

export function getBaseUrl() {
    return BASE_URL;
}