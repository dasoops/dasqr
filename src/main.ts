//vue
import {createApp} from 'vue';

//element
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import 'element-plus/theme-chalk/dark/css-vars.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue';

//other
import router from './conf/router';
import {store, key} from './conf/store';
import Terminal from 'vue-web-terminal';
import App from './App.vue';

const app = createApp(App);

app.use(router);
app.use(Terminal);
app.use(ElementPlus);
app.use(store, key);

//注册图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
const token = localStorage.getItem("token");
store.state.token = token ? token : undefined;

app.mount('#app');
