<template>
  <div class="container">
    <lay-row space="10">
      <lay-col>
        <lay-table :columns="columns"
                   :data-source="data"
                   :page="page"
                   @change="onPagechange"
        >
        </lay-table>
      </lay-col>
    </lay-row>

  </div>
</template>

<script setup>
import {onMounted, onUpdated, reactive, ref} from "vue";
import {layer} from "@layui/layui-vue";
const columns=reactive([
  {
    title:'商品图片',
    key:"id",
    width:80,
    align: "center",
  },{
    title: '商品分类',
    key:"userName",
    width: 80,
    align: "center"
  },{
    title: '商品品牌',
    key:"nickName",
    width: 80,
    align: "center"
  },
  {
    title: "商品价格",
    key: "email",
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