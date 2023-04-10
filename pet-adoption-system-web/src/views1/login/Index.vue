<template>
<div class="login">
  <lay-row space="10">
    <lay-col md="10" md-offset="7"
             lg="6" lg-offset="9"
             xs="24"
             sm="12" sm-offset="6"
              class="login-form">
      <lay-row space="10">
        <lay-col span="24" class="title">
          <h1>登录</h1>
        </lay-col>
      </lay-row>
      <lay-row space="10">
        <lay-col span="24">
          <lay-row space="10" class="form-item">
              <lay-col class="label"
                       lg="6"
                       md="8"
                       sm="24"
                       xs="24"

              >
                用户名
              </lay-col>
              <lay-col lg="18" md="16" sm="24" xs="24">
                <lay-input v-model="userInfo.userName" placeholder="请输入用户名"></lay-input>
              </lay-col>
            </lay-row>
          <lay-row space="10" class="form-item">
            <lay-col class="label"
                     lg="6"
                     md="8"
                     sm="24"
                     xs="24"

            >
              密码
            </lay-col>
            <lay-col lg="18" md="16" sm="24" xs="24">
              <lay-input v-model="userInfo.password" placeholder="请输入密码" type="password"></lay-input>
            </lay-col>
          </lay-row>
          <lay-row space="10" class="form-item">
            <lay-col class="btns">
              <lay-button class="white">注册</lay-button>
              <lay-button type="normal" @click="onLogin">登录</lay-button>
            </lay-col>

          </lay-row>
        </lay-col>
      </lay-row>
    </lay-col>
  </lay-row>
</div>
</template>

<script setup>
import {ref} from "vue"
import {login} from "./api.js";
import {useRouter} from "vue-router"
import {layer} from "@layui/layui-vue";

const userInfo = ref({
  userName: '',
  password: ''
})

const router = useRouter()

function onLogin(){
  login(userInfo.value).then(res=>{
    router.push('/')
  }).catch(err=>{
    layer.msg(typeof err === 'string' ? err : err.msg)
  });
}
</script>

<style scoped lang="scss">
 .login{
   width: 100%;
   height: 100%;
   color: white;
   display: flex;
   align-items: center;
   /*background: url('../../../public/1.png') no-repeat;*/
   background-size: cover;
   &>.layui-row{
     flex: 1 1 auto;
   }
   .login-form{

     background-color: rgba(255,255,255,0.5);
     backdrop-filter: blur(5px);
     padding: 20px;
     border-radius: 5px;
     .title{
       text-align: center;
       h1{
         font-size: 2em;
       }
     }
     .form-item{
       .label{
       font-size: 1.2em;
     }
       .btns{
         text-align: center;
         .white{
           color:#fff;
           border: 2px solid #fff;
         }
       }
       line-height: 50px;
     }
   }
 }

</style>