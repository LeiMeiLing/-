import {get, put} from "../../config/http.js";
import * as querystring from "querystring";

export const list=(params,page=1,limit=10)=>{
    let queryString = '';
    params = {...params}
    if (params.createTime?.length > 0){
        if(params.createTime[0]){
            queryString += "createTime="+params.createTime[0]+"&"
        }
        if(params.createTime[1]){
            queryString += "createTime="+params.createTime[1]+"&"
        }
        delete params.createTime
    }
    if (params.updateTime?.length){
        if(params.updateTime[0]){
            queryString += "updateTime="+params.updateTime[0]+"&"
        }
        if(params.updateTime[1]){
            queryString += "updateTime="+params.updateTime[1]+"&"
        }
        delete params.updateTime

    }
    return get('/user/list?'+queryString, {
        params:{
            ...params,
            page,
            limit
        }
    })
}

export const add=(params)=>{
    return put('/user/add', params)
}

export const del=(id)=>{
    const a='/role/delete/'+id;
    return del(a);
}