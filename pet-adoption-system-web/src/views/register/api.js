import http from "../../config/http.js";
export function register(userInfo){
    return http.put("/user/register",userInfo)
}