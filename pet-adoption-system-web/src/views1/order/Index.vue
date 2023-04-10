<template>
  <lay-table :columns="columns"
             :data-source="data"
             :page="page"
             @change="onPagechange"
  >
  </lay-table>
</template>

<script setup>
import {reactive} from "vue";
import {add} from "../petInfo/api.js";
import {layer} from "@layui/layui-vue";

const columns=reactive([
  {
    title:'用户ID',
    key:"id",
    width:80,
    align: "center",
  },{
    title: '用户名',
    key:"userName",
    width: 80,
    align: "center"
  },{
    title: '昵称',
    key:"nickName",
    width: 80,
    align: "center"
  },
  {
    title: "邮箱",
    key: "email",
    width: 100,
    align: "center"
  },
  {
    title: "注册时间",
    key:"createTime",
    width: 100,
    align: "center"
  },{
    title: "最后修改时间",
    key:"updateTime",
    width: 100,
    align: "center"
  },{
    title: "操作",
    align: "center",
    width: 100,
    customSlot:'action',
  }
])
const userInfoAdd=reactive({
  usrName:'',
  password:'',
  email:'',
  nickName:''
})
function onAdd(){
  add(userInfoAdd).then(()=>{
    layer.msg('新增成功')
    reload()
  }).catch(err=>{
    if(err.data){
      let message='';
      for (let name in err.data) {
        message +=err.data[name].join("\n")
      }
      layer.msg(message,{icon:3,time:3000})
    }else {
      layer.msg(err?.msg)
    }

  })
}

//定义表格数据
const data=reactive([])
//查询条件对象
const query = reactive({
  userName:'',
  nickName:'',
  email:'',
  createTime:[],
  updateTime:[]
})
//分页
const page = reactive({
  total:11,
  limit:10,
  current:1,
  showRefresh:true,
})
function onPagechange({ current,limit }){
  page.current = current
  page.limit = limit
  reload()
}
</script>

<style scoped>

</style>