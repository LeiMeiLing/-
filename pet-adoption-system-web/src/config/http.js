import axios from "axios";
import router from "./router.js"

const instance = axios.create({
    baseURL:"http://localhost:8000",
    headers:{
        "Content-Type": "application/json",
    }
});

instance.interceptors.request.use(config=>{
    if (sessionStorage.getItem('hm-token')){
        config.headers['hm-token'] = sessionStorage.getItem('hm-token')
    }
    return config
})

instance.interceptors.response.use(response=> {
    return new Promise((resolve, reject) => {
        if (response.status === 200) {
            if (response.data.code === 0) {
                resolve(response.data)
                return;
            }
        }
        reject(response.data)
    });
},error => {
    if (error.response?.status === 400){
        if (error.response.data.code === 10001){
            router.push({name: 'login'})
        }
    }
    return Promise.reject(error.response?.data||error.message)
})

const put = instance.put
const post = instance.post
const get = instance.get
const del = instance.delete
export {put,post,get,del}
export default instance
