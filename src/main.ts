import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import {store, key} from './conf/store'


// 传入 injection key


createApp(App)
    .use(router)
    .use(ElementPlus)
    .use(store, key)
    .mount('#app')

