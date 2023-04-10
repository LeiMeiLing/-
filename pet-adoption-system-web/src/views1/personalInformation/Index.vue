<template>
  <lay-avatar :src="src" size="lg"></lay-avatar>
  <lay-collapse v-model="openKeys">
    <lay-collapse-item title="用户名" id="1"> 内容1 </lay-collapse-item>
    <lay-collapse-item title="个人爱好" id="2"> 内容2 </lay-collapse-item>
    <lay-collapse-item title="地址" id="3"> 内容3 </lay-collapse-item>
  </lay-collapse>

</template>

<script setup>
import { ref } from 'vue'

const src = "https://foruda.gitee.com/avatar/1677022544584087390/4835367_jmysy_1578975358.png"

const openKeys = ref(["1","2","3"])
</script>

<style scoped>

</style>