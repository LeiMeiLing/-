import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import layui from '@layui/layui-vue'
import '@layui/layui-vue/lib/index.css'
import router from './config/router.js'
import store from './config/store.js'
import 'nprogress/nprogress.css'

const app=createApp(App)
app.use(router)
app.use(layui)
app.use(store)
app.mount('#app')
