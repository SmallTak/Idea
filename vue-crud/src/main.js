// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//导入ElementUI
import ElementUI, { Form } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//导入axios
import axios from 'axios';
import { promises } from 'fs';

Vue.use(ElementUI);

Vue.prototype.$http=axios;

//配置axios的默认属性
axios.defaults.baseURL = "http://localhost:9090"

Vue.config.productionTip = false

//设置路由的前置过滤
//查看当前请求的路径是否需要认证，若需要则从localStorage中获取token
//若有值则跳转
//若token不存在，则跳转到登录页面
router.beforeEach((to, from,next) => {
  if (to.meta.reqiredAuth) {
    //需要认证的路由
    var token = localStorage.getItem("jwtToken");
    if (!token) {
      router.push("/");
      return;
    }
  }
  next();
});

//axios请求拦截器 将token放入到httpheader中发送到服务端
axios.interceptors.request.use(config => {
  var token = localStorage.getItem("jwtToken");
  if (token) {
    //将token放入到请求header中
    config.headers.Authorization=token;
  }
  //给condif设置过新的参数之后 return
  return config;
},error =>{
  return Promise.reject(error);
});

//axios 响应拦截器 为了判断服务端返回的是200 还是401
axios.interceptors.response.use(response => {
    return response;
  },error => {
    if (error.response) {
      if (error.response.status == 401) {
        //删除token
        localStorage.removeItem("jwtToken");
        router.push("/");
      }
    }
    return Promise.reject(error.response.data); 
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
