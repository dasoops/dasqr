import {createRouter, createWebHashHistory, RouteRecordRaw} from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        redirect: 'image',
        meta: {
            title: 'index',
        },
    },
    {
        path: '/config',
        name: 'configManager',
        meta: {
            title: 'config',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "configManager" */ '../view/configManagerView.vue')
    },
    {
        path: '/register',
        name: 'registerManager',
        meta: {
            title: 'register',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "registerManager" */ '../view/registerManagerView.vue')
    },
    {
        path: '/plugin',
        name: 'pluginManager',
        meta: {
            title: '',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "pluginManager" */ '../view/pluginManagerView.vue')
    },
    {
        path: '/role',
        name: 'roleManager',
        meta: {
            title: 'role',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "roleManager" */ '../view/roleManagerView.vue')
    },
    {
        path: '/image',
        name: 'imageManager',
        meta: {
            title: 'image',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "imageManager" */ '../view/imageManagerView.vue')
    },
    {
        path: '/login',
        name: 'login',
        meta: {
            title: 'login',
        },
        // route level code-splitting
        // this generates dasDrag.vue separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "loginNav" */ '../view/loginView.vue')
    }
]

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
})

router.beforeEach((to, form, next) => {
    const token: string | null = localStorage.getItem("token");
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = String(to.meta.title);
    }
    if (!token && to.path != '/login') {
        next('/login');
    } else if (token && to.path == '/login') {
        next('/image');
    } else {
        next();
    }
})

export default router
