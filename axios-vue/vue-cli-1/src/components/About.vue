<template>
    <div id="about">
        <h3 class="title">关于我们</h3>
        <ul class="item-group">
            <li class="news-title" v-for="item in about" ::key="item.id">{{item.title}}</li>
        </ul>
    </div>
</template>
<script>
    export default {
        name:'',
        data() {
            return {
                about:[
                    {id:1,title:"nan"},
                    {id:2,title:"shan"},
                    {id:3,title:"nan"}
                ]
            }
        },
        methods: {

        }
    }
</script>
<style lang="less" scoped>
    #about{
        .title{
            color:#ff7400;
        }
        .item-group{
            .news-title{
                color:red;
            }
        }
    }
</style>