import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import AddMovie from '@/components/AddMovie'
import EditMovie from '@/components/EditMovie'
import DetailMovie from '@/components/DetailMovie'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta:{
        reqiredAuth:true
      }
    },
    {
      path:'/new',
      name:'AddMovie',
      component: AddMovie,
      meta: {
        reqiredAuth: true
      }
    },
    {
      path: '/edit/:id',
      name: 'EditMovie',
      component: EditMovie,
      meta: {
        reqiredAuth: true
      }
    },
    {
      path: '/detail/:id',
      name: 'DetailMovie',
      component: DetailMovie,
      meta: {
        reqiredAuth: true
      }
    }
  ]
})
