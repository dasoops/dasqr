// store.ts
import {InjectionKey} from 'vue'
import {createStore, useStore as baseUseStore, Store} from 'vuex'

// 为 store state 声明类型
export interface State {
    isLogin: boolean
}

// 定义 injection key
export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
    state: {
        isLogin: true
    },
    mutations: {
        refresh(state) {
            state.isLogin = !!localStorage.getItem("token");
        }
    }
})

// 定义自己的 `useStore` 组合式函数
export function useStore () {
    return baseUseStore(key)
}