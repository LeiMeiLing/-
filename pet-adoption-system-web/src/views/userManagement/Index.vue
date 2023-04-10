<template>
 <div class="container">
   <lay-row space="10">
   <lay-row space="10">
     <lay-col md="7">
       <lay-input placeholder="请输入用户名" v-model="query.userName">
         <template #prepend>用户名</template>
       </lay-input>
     </lay-col>
     <lay-col md="7">
       <lay-input placeholder="请输入电话" v-model="query.phoneNumb">
         <template #prepend>电话</template>
       </lay-input>
     </lay-col>
     <lay-col md="7">
       <lay-input placeholder="请输入邮箱" v-model="query.email">
         <template #prepend>邮箱</template>
       </lay-input>
     </lay-col>
   </lay-row>
   <lay-row space="10"  class="form-item">
     <lay-col md="11">
       <lay-row space="10">
         <lay-col md="4">注册时间</lay-col>
         <lay-col md="20">
           <lay-date-picker v-model="query.createTime"
                            formatas="YYYY-MM-DD hh:mm:ss"
                            range :placeholder="['开始日期','结束日期']" allowClear></lay-date-picker>
         </lay-col>
       </lay-row>
     </lay-col>
     <lay-col md="12">
        <lay-row space="10">
          <lay-col md="6">最后修改时间</lay-col>
          <lay-col md="18">
            <lay-date-picker v-model="query.updateTime"
                             formatas="YYYY-MM-DD hh:mm:ss"
                             range :placeholder="['开始日期','结束日期']" allowClear></lay-date-picker>
          </lay-col>
        </lay-row>
     </lay-col>
     <lay-col md="1">
       <lay-button type="normal" @click="reload">
         <lay-icon type="layui-icon-search" size="16px"></lay-icon>
       </lay-button>
     </lay-col>
   </lay-row>
   </lay-row>
   <lay-row space="10">
      <lay-col>
        <lay-table :columns="columns"
                   :data-source="data"
                   :page="page"
                   @change="onPagechange"
        >
        <template #action>
          <lay-button type="danger" size="sm">
            <lay-icon type="layui-icon-edit" size="18"></lay-icon>
          </lay-button>
          <lay-button type="normal" size="sm" @click="onDel">
            <lay-icon type="layui-icon-delete" size="18"></lay-icon>
          </lay-button>
        </template>
          <template #toolbar>
            <lay-tooltip content="新增用户" ref="tooltip">
            <lay-button type="primary" @click="addUserVisible=true">
              <lay-icon type="layui-icon-add-one">
              </lay-icon>
            </lay-button>
            </lay-tooltip>
          </template>
        </lay-table>
      </lay-col>
   </lay-row>
   <lay-layer v-model="addUserVisible" :area="['400px','450px']">
     <lay-form>
       <lay-form-item label="用户名">
         <lay-input v-model="userInfoAdd.userName" placeholder="请输入用户名"></lay-input>
       </lay-form-item>
     </lay-form>
     <lay-form>
       <lay-form-item label="密码">
         <lay-input v-model="userInfoAdd.password" type="password" password placeholder="请输入密码"></lay-input>
       </lay-form-item>
     </lay-form>
     <lay-form>
       <lay-form-item label="邮箱">
         <lay-input v-model="userInfoAdd.email" type="email" placeholder="请输入邮箱"></lay-input>
       </lay-form-item>
     </lay-form>
     <lay-form>
       <lay-form-item label="电话">
         <lay-input v-model="userInfoAdd.phoneNumb" placeholder="请输入电话"></lay-input>
       </lay-form-item>
       <lay-form-item>
         <lay-button type="normal" @click="onAdd ">新增</lay-button>
       </lay-form-item>
     </lay-form>
   </lay-layer>
 </div>
</template>

<script setup>
import {onMounted, onUpdated, reactive, ref} from "vue";
import {list, add, del} from "./api.js";
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
    title: '电话',
    key:"phoneNumb",
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
  phoneNumb:''
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
//获取用户列表
function reload(){
  list(query,page.current,page.limit).then(res=>{
    data.length=0
    data.push(...res.data.list )
    page.current = res.data.current;
    page.total = res.data.total
  })
}
const addUserVisible=ref(false);

onMounted(reload)
onUpdated(reload)
</script>

<style scoped lang="scss">
.container{
  color: #000;
  .form-item{
    height: 50px;
    line-height: 50px;
  }
}
</style>