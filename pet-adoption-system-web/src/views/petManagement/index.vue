<template>
  <lay-table :columns="columns" :data-source="petInfoList">


  </lay-table>

</template>

<script setup>
import { ref } from 'vue'
import * as timers from "timers";


    const columns = ref([
      {
        title: "宠物id",
        key: "ID",
        align: "center"
      }, {
        title: "宠物名称",

        key: "pet_name",
        align: "center"

      }, {
        title: "种类",
        key:"variety",
        align: "center",

      },
      {
        title: "性别",
        key:"pet_sex",
        align: "center",

      },{
        title: "图片",
        key:"pet_picture",
        align: "center",

      },{
        title: "状态",
        key:"pet_status",
        align: "center",

      },{
        title: "创建时间",
        key:"create_time",
        align: "center",

      },{
        title: "最后修改时间",
        key:"update_time",
        align: "center",

      },{
        title: "操作",
        align: "center",
        width: 100,
        customSlot:'action',
      }
    ])
const petInfoList=ref([])


</script>

<style scoped>

</style>