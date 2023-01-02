import axios from "axios";
import {ElMessage} from "element-plus";
import {useRouter} from "vue-router";

export const baseUrl = "http://127.0.0.1:4901";

const client = axios.create({
    baseURL: baseUrl,
    timeout: 5000,
    headers: {
        "content-type": "application/json;charset=utf-8"
    }
});

client.interceptors.request.use((config) => {
    config.headers = config.headers ? config.headers : {};
    const token = localStorage.getItem("token");
    if (token) {
        config.headers['Authorization'] = "Bearer " + token;
    }
    return config;
})

client.interceptors.response.use(
    (res) => {
        if (res.headers['content-type'] != "application/json;charset=UTF-8") {
            return res;
        }
        const code: number = res.data.code;
        if (code != 200) {
            ElMessage.error(res.data.msg);
            if (code == 10101) {
                localStorage.removeItem("token");
                const router = useRouter();
                router.push("/login");
            }
            return Promise.reject(res.data);
        }
        // ElMessage.success(res.data.msg);
        return res.data;
    },
    (err) => {
        ElMessage.error(err);
    }
);

export default client;