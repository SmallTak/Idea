package com.kaishengit.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String username,String emain,String password) {
        String sql = "insert into t_studen(name,password,email) values(?,?,?)";
        jdbcTemplate.update(sql,username,password,emain);
    }

}
