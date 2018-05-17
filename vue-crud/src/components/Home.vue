<template>
  <div id="home">
        <i layout="->" @click="addMovie" class="el-icon-circle-plus grid-content" ></i><br><br>
    <el-table
      :data="movies"
      style="width: 100%">
      <el-table-column
        prop="title"
        label="电影名称"
        width="300">
      </el-table-column>
      <el-table-column
        prop="rate"
        label="评分"
        width="200">
      </el-table-column>
      <el-table-column
        prop="releaseYear"
        label="发行时间">
      </el-table-column>
      <el-table-column
        prop="sendTime"
        label="上映时间">
      </el-table-column>
      <el-table-column
        prop="director"
        label="导演">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
            <i class="el-icon-edit"
                size="mini"
                @click="handleEdit(scope.$index, scope.row)"></i>
            <i class="el-icon-close"
                size="mini"
                @click="handleDelete(scope.$index, scope.row)"></i>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <el-pagination
      background
      layout="->,prev, pager, next,total"
      :total="total"
      :current-Page="currentPage"
      @current-change="pageData">
  </el-pagination>
  </div>
</template>

<script>
import api from "../const/url"
export default {
  name: "Home",
  data() {
    return {
      movies:[],
      total:1,
      currentPage:1
    };
  },
  methods:{
      addMovie:function () {
        this.$router.push("/new");
      },
      handleEdit:function (index, row) {
        var id = row.id;
        this.$router.push("/edit/" + id);
      },
      handleDelete:function (index, row) {
        var id = row.id;
        this.$confirm("确定要删除么？").then(() => {
          this.$http.delete("/movie/" + id).then(response => {
            if (response.data.status == 'success') {
                this.$message.success("删除成功");
                this.movies.splice(index, 1);          
            } else {
              this.$message.error("系统提示:" + error.message);
            }
          }).catch(error => {
            this.$message.error("系统提示:" + error.message);
          })
        }).catch(() => {})
      },
      handleDetail:function () {
        var id = row.id;
        this.$router.push("/detail/" + id);
      },
      pageData:function(pageNo) {
        //console.log(pageNo)
        //this.currentPage=pageNo
        this.loadData(this.currentPage=pageNo)
      
      },
      loadData:function(pageNum) {
        this.$http.get(api.movieHome+"/?p=" + pageNum).then(response => {
          this.movies = response.data.result.list;
          this.total = response.data.result.total;      
        }).catch(error => {
          this.$message.error("系统提示:" + error.message);
        })
      }
  },
  mounted:function() {
    this.loadData(this.currentPage)
  }
};
</script>

<style scoped lang="less">
  
</style>
