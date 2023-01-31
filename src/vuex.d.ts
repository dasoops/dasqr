// vuex.d.ts
import {Store} from 'vuex'
import {BaseResult} from "@/entity/result/BaseResult";

declare module '@vue/runtime-core' {
    // 声明自己的 store state
    interface State {
        token?: string,
        loginUserName?: string,
        loginRegisterId?: number,
    }

    // 为 `this.$store` 提供类型声明
    interface ComponentCustomProperties {
        $store: Store<State>
    }
}

declare module 'axios' {
    // 拓展 axios 的 config 类型
    export interface AxiosRequestConfig {
        validityTime?: number,
        disableCache?: boolean,
        passError?: boolean,
    }

    // 拓展Axios返回值类型
    export interface AxiosInstance {
        (config: AxiosRequestConfig): Promise<any>

        <T extends BaseResult>(config: AxiosRequestConfig): Promise<T>,
    }
}

declare module 'vue-router' {
    export interface RouteMeta {
        show?: boolean,
        isMenuRoute?: boolean,
        title?: string,
        showOnRegister?: string,
    }
}

