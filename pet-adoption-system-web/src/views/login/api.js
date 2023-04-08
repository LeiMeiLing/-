import {post} from "../../config/http.js"

/**
 * 登录
 * @param userName 用户名
 * @param password 密码
 * @returns {Promise<unknown>}
 */
export const login = ({userName,password})=>{
    return post('/user/login',{userName,password})
        .then(rs=>{
            sessionStorage.setItem('hm-token',rs.data.token)
        })
}