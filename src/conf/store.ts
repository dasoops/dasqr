// store.ts
import {InjectionKey} from 'vue'
import {createStore, useStore as baseUseStore, Store} from 'vuex'

// 为 store state 声明类型
export interface State {
    token?: string,
    loginUserName?: string,
    loginRegisterId?: string,
}

// 定义 injection key
export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
    state: {},
    mutations: {
        refresh(state) {
            const token = localStorage.getItem("token");
            state.token = token ? token : undefined;
        },
    }
})

// 定义自己的 `useStore` 组合式函数
export function getStore() {
    return baseUseStore(key)
}