<template>
  <div id="home">
    <el-table-column>
      <el-button id="newMovie" @click="clickOut" class="el-icon-close" type="black" round></el-button>
      <el-button id="newMovie" @click="addMovie" class="el-icon-plus" type="black" round></el-button>
    </el-table-column>
    <el-table
      ref="multipleTable"
      :data="movies"
      style="width: 100%"
      max-height="1100"
      @selection-change="handleSelectionChange">
      <el-table-column
      type="selection"
      width="55">
      </el-table-column>
      <el-table-column
        prop="title"
        label="电影名称"
        width="300">
        <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>电影名称: {{ scope.row.title }}</p>
          <p>发行时间: {{ scope.row.releaseYear }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.title }}</el-tag>
          </div>
        </el-popover>
      </template>
      </el-table-column>
      <el-table-column
        prop="rate"
        label="评分"
        width="200">
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
          <el-button type="primary" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)" circle></el-button>
          <el-button type="danger" icon="el-icon-delete" @click="handleDelete(scope.$index, scope.row)" circle></el-button>
        </template>
      </el-table-column>
    </el-table>
      <el-button @click="toggleSelection()">取消</el-button>
   
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
      clickOut:function () {
        localStorage.removeItem("jwtToken");
        this.$message("你已安全退出");
        this.$router.push("/");
      },
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
      },
      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
        //console.log(this.multipleSelection.id);
      }
  },
  mounted:function() {
    this.loadData(this.currentPage);
  }
};
</script>

<style scoped lang="less">
  #newMovie {
 margin-top: 35px; 
    color: black;
    margin-left: 970px;
    float:left;
  }
  #logout{
 margin-top: 35px; 
    color: black;
    margin-left: 900px;
    float:right;
  }
</style>
