import {createRouter,createWebHashHistory} from "vue-router";
import NProgress from 'nprogress'

const routes=[
    {
        path:'/login',
        name:'login',
        component:()=>import('../views/login/Index.vue'),
        meta: {
            // 标记该路由不需要登录
            noLogin: true
        }
    },{
        path: '/',
        name:'home',
        component:()=>import('../views/layout/Index.vue'),
        redirect:'/userInfo',
        children:[
            {
                path:'/userInfo',
                name:'userInfo',
                component:()=>import('../views/petInfo/Index.vue')
            },
            {
                path: '/petInfo',
                name:'petInfo',
                component:()=>import('../views/petManagement/index.vue')
            }
            ,
            {
                path: '/adoptInfo',
                name:'adoptInfo',
                component:()=>import('../views/adoptManagement/index.vue')
            }
        ]
    },
    {
        path: '/register',
        name:'register',
        component:()=>import('../views/register/Index.vue')
    }
]

const router=createRouter({
    history:createWebHashHistory(),
    routes
})

router.beforeEach((to,from)=>{
    // 如果是目标路由不需要登录,则直接跳转
    NProgress.start()
    if(to.meta.noLogin){
        return true;
    }
    const loginInfo  = useLogin();
    if(loginInfo.isLogin()){
        return true;
    }else{
        // 如果没有登录,则跳转到登录页面
        return {name: "login"};
    }
})
router.afterEach((to, from) => {
    NProgress.done()
})

export default router