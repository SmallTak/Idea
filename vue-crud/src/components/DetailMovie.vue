<template>
  <div id="detailMovie">
      <i id="text" @click="backList" class="el-icon-back grid-content"></i>
        <el-form style="margin-top:20px" ref="form" :model="movie" label-width="80px">
            <el-form-item label="电影名称">
                <el-input v-model="movie.title"></el-input>
            </el-form-item>
            <el-form-item label="评分">
                <el-input v-model="movie.rate"></el-input>
            </el-form-item>
            <el-form-item label="导演">
                <el-input v-model="movie.director"></el-input>
            </el-form-item>
            <el-form-item label="发行日期" prop="travelStartTime">
                <el-date-picker
                    v-model="movie.releaseYear"
                    type="date"
                    placeholder="发行日期">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="上映时间">
                <el-date-picker
                    v-model="movie.sendTime"
                    type="date"
                    placeholder="上映时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="简介">
                <el-input v-model="movie.description"></el-input>
            </el-form-item>
        </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  name:'', 
  data() {
    return {
        movie:{}
    }
  },
  methods:{
      backList: function() {
      this.$router.push("/");
    }
  },
   mounted:function(){
      var id = this.$route.params.id;
      this.$http.get("/movie/"+id).then(response => {
         this.movie = response.data.result;   
      }).catch(error => {
        this.$message.error("系统提示:" + error.message);
      });
  }
}
</script>

<style scoped lang="less">
</style>
