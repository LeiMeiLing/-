import {createRouter,createWebHashHistory} from "vue-router";

const routes=[
    {
        path:'/login',
        name:'login',
        component:()=>import('../views1/login/Index.vue')
    },{
        path: '/',
        name:'home',
        component:()=>import('../views1/layout/Index.vue'),
        redirect:'/petInfo',
        children:[
            {
                path:'/petInfo',
                name:'petInfo',
                component:()=>import('../views1/petInfo/Index.vue'),
            },{
                path:'/petstore',
                name:'petstore',
                component:()=>import('../views1/petstore/Index.vue')
            },{
                path:'/order',
                name:'order',
                component:()=>import('../views1/order/Index.vue')
            },{
                path:'/personalInformation',
                name:'personalInformation',
                component:()=>import('../views1/personalInformation/Index.vue')
            }
        ]
    }
]

const router=createRouter({
    history:createWebHashHistory(),
    routes
})

/*router.beforeEach((to,from)=>{
    const token=sessionStorage.getItem('hm-token')
    if(!token){
        //判断要去哪里
        if(to.name === 'login' || to.name === 'register'){
            return true
        }
        //如果没有登录跳转到登录页
        return {name:'login'}
    }
})*/

export default router