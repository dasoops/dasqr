import {createRouter, createWebHashHistory, createWebHistory, RouteRecordRaw} from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        redirect: 'image',
    },
    {
        path: '/config',
        name: 'configManager',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "configManager" */ '../view/configManagerView.vue')
    },
    {
        path: '/register',
        name: 'registerManager',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "registerManager" */ '../view/registerManagerView.vue')
    },
    {
        path: '/plugin',
        name: 'pluginManager',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "pluginManager" */ '../view/pluginManagerView.vue')
    },
    {
        path: '/role',
        name: 'roleManager',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "roleManager" */ '../view/roleManagerView.vue')
    },
    {
        path: '/image',
        name: 'imageManager',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "imageManager" */ '../view/imageManagerView.vue')
    },
    {
        path: '/login',
        name: 'login',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
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
    if (!token && to.path != '/login') {
        next('/login');
    } else if (token && to.path == '/login') {
        next('/image');
    } else {
        next();
    }
})

export default router
