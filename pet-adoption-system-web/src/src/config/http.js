import axios from "axios";
<<<<<<< HEAD
import router from "./router.js"

const instance = axios.create({
    baseURL:"http://localhost/api",
    headers:{
        "Content-Type": "application/json",
=======
import useLogin from "../stores/LoginStore"
import NProgress from "nprogress";
const http = axios.create({
    baseURL: 'http://localhost/api',
    timeout: 5000,
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
>>>>>>> origin/master
    }
})

http.interceptors.request.use(config=>{
    NProgress.start()
    // TODO: 添加token
    const loginInfo  = useLogin();
    if(loginInfo.isLogin()){
        // 将token添加到请求头中
        config.headers['hm-token'] = loginInfo.token;
    }
    return config;
},error=>{
    return Promise.reject(error)
})

http.interceptors.response.use(response=>{
    return new Promise((resolve,reject)=>{
        NProgress.done()
        if(response.data.code === 200){
            resolve(response.data)
        }else{
            reject(response.data)
        }
    })
})


export default http
