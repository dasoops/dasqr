import axios, {AxiosInstance} from "axios";
import {ElMessage} from "element-plus";
import {useRouter} from "vue-router";
import {getBaseUrl} from "@/request/initRequest";

// const axiosClient = axios.create({
//     baseURL: getBaseUrl(),
//     timeout: 5000,
//     headers: {
//         "content-type": "application/json;charset=utf-8"
//     },
// });


const instanceMap = new Map<string | undefined, AxiosInstance>();

function setInterceptors(axiosInstance: AxiosInstance) {
    axiosInstance.interceptors.request.use((config) => {
        config.headers = config.headers ? config.headers : {};
        const token = localStorage.getItem("token");
        if (token) {
            config.headers['Authorization'] = "Bearer " + token;
        }
        const method = config.method;
        if (method == 'GET' || method == 'get') {
            config.params = config.data;
        }
        return config;
    })

    axiosInstance.interceptors.response.use(
        (res) => {
            if (res.headers['content-type'] != "application/json;charset=UTF-8") {
                return res;
            }
            const code: number = res.data.code;
            if (code != 200) {
                ElMessage.error(res.data.msg);
                if (code == 10001) {
                    localStorage.removeItem("token");
                    const router = useRouter();
                    router.push("/login").then();
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
}

export function getInstance(module: string | undefined): AxiosInstance {
    const instance = instanceMap.get(module);
    if (!instance) {
        const newInstance = axios.create({
            baseURL: getBaseUrl() + '/' + (module ? module : ''),
            timeout: 5000,
        });
        setInterceptors(newInstance);
        instanceMap.set(module, newInstance);
        return newInstance;
    }
    return instance;
}

// export default axiosClient;