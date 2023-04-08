import {createRouter,createWebHashHistory} from "vue-router";

const routes=[
    {
        path:'/login',
        name:'login',
        component:()=>import('../views/login/Index.vue')
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
            }
        ]
    }
]

const router=createRouter({
    history:createWebHashHistory(),
    routes
})

router.beforeEach((to,from)=>{
    const token=sessionStorage.getItem('hm-token')
    if(!token){
        //判断要去哪里
        if(to.name === 'login' || to.name === 'register'){
            return true
        }
        //如果没有登录跳转到登录页
        return {name:'login'}
    }
})

export default router