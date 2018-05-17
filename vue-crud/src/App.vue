<template>
    <div id="app">
        <h3>Vue 前后端分离Demo</h3>
        <el-row>
            
        </el-row>
        <router-view/>
    </div>
</template>

<script>
export default {
    name: 'App',
      data(){
        return{

        }
    },
    methods:{
      
    }
}
</script>

<style lang="less" scoped>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #2c3e50;
        margin: 10px auto;
        width: 1100px;
        
        .text{
            text-align: right
        }
    }
</style>
