<template>
  <lay-row space="10" class="login">
    <lay-col md="7" md-offset="16" lg="7" lg-offset="16" sm="24" xm="24">
      <lay-row class="title">
        <h1>登&emsp;录</h1>
      </lay-row>

      <lay-row space="10">
        <lay-col md="6" md-offset="1" lg="6" lg-offset="1" xm="24" sm="24">
          用户名：
        </lay-col>
        <lay-col md="16" lg="16" xm="24" sm="24">
          <lay-input v-model="userInfo.username" placeholder="请输入用户名"></lay-input>
        </lay-col>
      </lay-row>

      <lay-row space="10">
        <lay-col md="6" md-offset="1" lg="6" lg-offset="1" xm="24" sm="24">
          密&emsp;码：
        </lay-col>
        <lay-col md="16" lg="16" xm="24" sm="24">
          <lay-input v-model="userInfo.password" placeholder="请输入密码"></lay-input>
        </lay-col>
      </lay-row>
      <lay-row>
        <lay-col md="4" md-offset="19" lg="4" lg-offset="19" xm="8" xm-offset="16" sm="8" sm-offset="16">
          <a href="" >
            忘记密码
          </a>
        </lay-col>
      </lay-row>

      <lay-row space="10">
        <lay-col md="22" md-offset="1"  lg="22" lg-offset="1" sm="24" xm="24">
          <lay-button type="normal" @click="onLogin" fluid>登录</lay-button>
        </lay-col>
      </lay-row>
      <lay-row space="10">
        <lay-col md="22" md-offset="1" lg="22" lg-offset="1" sm="24" xm="24">
          <lay-button border="blue" @click="onRegister" fluid>注册</lay-button>
        </lay-col>
      </lay-row>
    </lay-col>
  </lay-row>
</template>

<script setup>
import {ref} from 'vue'
import {login} from './api'
import router from "../../config/router.js";
import {layer} from "@layui/layui-vue";

const userInfo = ref({
  username: '',
  password: ''
})

function onRegister(){
  router.push('/register')
}
function onLogin(e) {
  login(userInfo.value).then(res => {
    layer.msg(res.msg)
    router.push({name:'main'})
  }).catch(err => {
    console.error(err)
  })
}
</script>

<style scoped lang="scss">
.login{
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  background: url("../../../src/picture/注册.png");
  background-size: cover;
&>.layui-col{
   line-height: 50px;
   background-color: rgba(255,255,255,0.5);
   backdrop-filter: blur(2px);
   border-radius: 5px;
 }
}
.title{
  display: flex;
  justify-content: center;
}
a{
  color: red;
}
</style>
