import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './conf/router'
import {store, key} from './conf/store'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import {initConfig} from "@/request/initRequest";

const app = createApp(App);
app.use(ElementPlus)
app.use(store, key)
app.use(router)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

const token = localStorage.getItem("token");
store.state.token = token ? token : undefined;

initConfig();
app.mount('#app')
