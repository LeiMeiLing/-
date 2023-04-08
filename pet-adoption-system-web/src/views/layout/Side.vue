<template>
  <lay-menu :selected-key="selectedKey" @change-selected-key="onChangeSelected" v-model:openKeys="openKeys" :tree="true">
    <lay-sub-menu id="system-manager">
      <template #title>
        系统管理
      </template>
      <lay-menu-item id="user-manager" to="/userInfo">用户管理</lay-menu-item>
      <lay-menu-item id="role-manager">角色管理</lay-menu-item>
      <lay-menu-item id="permission-manager">权限管理</lay-menu-item>
      <lay-menu-item id="image-manager" to="/home/avatar">图片管理</lay-menu-item>
    </lay-sub-menu>
  </lay-menu>
</template>

<script setup>
import {ref} from "vue";

const selectedKey = ref('user-manager');
const openKeys = ref(['system-manager']);
function onChangeSelected(key){
  selectedKey.value = key;
}
</script>

<style scoped>

</style>