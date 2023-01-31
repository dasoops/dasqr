import {createRouter, createWebHashHistory, RouteRecordRaw, useRouter} from 'vue-router'
import {getRegisterRouteKeywordList} from "@/request/pluginRequest";
import {getBaseUrl, setBaseUrl} from "@/conf/application";
import {initConfiguration} from "@/request/initRequest";

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        redirect: '/system/config',
        meta: {
            isMenuRoute: false,
        }
    },
    {
        path: '/login',
        name: 'login',
        meta: {
            title: 'Login',
            isMenuRoute: false,
        },
        component: () => import('../view/loginView.vue')
    },
    {
        path: '/system',
        name: 'system',
        meta: {
            isMenuRoute: true
        },
        children: [
            {
                path: 'config',
                name: 'config',
                meta: {
                    title: 'Config',
                    show: false,
                    showOnRegister: 'config',
                },
                component: () => import('@/view/configView.vue')
            },
            {
                path: 'register',
                name: 'register',
                meta: {
                    title: 'Register',
                    show: false,
                    showOnRegister: 'register',
                },
                component: () => import('@/view/registerView.vue')
            },
            {
                path: 'plugin',
                name: 'plugin',
                meta: {
                    title: 'Plugin',
                    show: false,
                    showOnRegister: 'plugin',
                },
                component: () => import('@/view/pluginView.vue')
            },
        ]
    },
    {
        path: '/plugin-sys',
        name: 'plugin-sys',
        meta: {
            isMenuRoute: true
        },
        children: [
            {
                path: 'shell',
                name: 'shell',
                meta: {
                    title: 'Shell',
                    show: false,
                    showOnRegister: 'shell',
                },
                component: () => import('@/view/shellView.vue')
            },
            {
                path: 'schedule',
                name: 'schedule',
                meta: {
                    title: 'schedule',
                    show: false,
                    showOnRegister: 'schedule',
                },
                component: () => import('@/view/scheduleView.vue')
            },
        ],
    },
    {
        path: '/plugin-normal',
        name: 'plugin-normal',
        meta: {
            isMenuRoute: true
        },
        children: [
            {
                path: 'image',
                name: 'image',
                meta: {
                    title: 'Image',
                    show: false,
                    showOnRegister: 'image',
                },
                component: () => import('../view/imageView.vue')
            },
            {
                path: 'reply',
                name: 'reply',
                meta: {
                    title: 'reply',
                    show: false,
                    showOnRegister: 'reply',
                },
                component: () => import('@/view/replyView.vue')
            },
        ]
    },
]

const filterRoutes = await getRegisterRouteKeywordList().then(vo => {
    const loadPluginList = vo.data.registerRouteKeywordList;
    const checkLoadRoutes = routes.map(route => {
        route.children?.map(childrenRoute => {
            //没meta不管
            const meta = childrenRoute.meta;
            if (!meta) {
                return childrenRoute;
            }
            const show = meta.show;
            //本来就显示不用管
            if (show) {
                return childrenRoute;
            }
            //没有条件不用管
            const showOnLoad = meta.showOnRegister;
            if (!showOnLoad) {
                return childrenRoute;
            }
            //没加载不管
            if (loadPluginList.indexOf(showOnLoad) == -1) {
                return childrenRoute;
            }
            //加载
            meta.show = true;
            return childrenRoute;
        });
        return route;
    });
    //过滤无显示子导航的menu导航
    return checkLoadRoutes.filter(route => {
        //非导航菜单路由放行
        if (!route.meta?.isMenuRoute) {
            return true;
        }
        //无children屏蔽
        if (!route.children) {
            return false;
        }
        //children无显示屏蔽
        const noneShowChild = route.children.filter(childrenRoute => childrenRoute.meta?.show).length <= 0;
        if (noneShowChild) {
            return false;
        }
        return true;
    });
});

const router = createRouter({
    history: createWebHashHistory(getBaseUrl()),
    routes: filterRoutes
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
        next('/');
    } else {
        next();
    }
})

export default router
