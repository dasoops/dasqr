// vuex.d.ts
import { Store } from 'vuex'
import {AxiosRequestConfig} from "axios";

declare module '@vue/runtime-core' {
    // 声明自己的 store state
    interface State {
        isLogin: boolean,
    }

    // 为 `this.$store` 提供类型声明
    interface ComponentCustomProperties {
        $store: Store<State>
    }
}

declare module 'axios' {
    interface AxiosInstance {
        (config: AxiosRequestConfig): Promise<any>
    }
}