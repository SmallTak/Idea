package com.kaishengit.dao;

import com.kaishengit.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Product product){
        String sql = "insert into t_account(name,age) values(?,?)";
        jdbcTemplate.update(sql, product.getName(),product.getAge());
    }

    /*批量增加*/
    public void batchInsert(List<Product> productList){
        String sql = "insert into t_account (name,age) values(?,?)";
        List<Object[]> params  = new ArrayList<Object[]>();
        for (Product product : productList){
            Object[] objects = new Object[2];
            objects[0] = product.getName();
            objects[1] = product.getAge();
            params .add(objects);
        }
        jdbcTemplate.batchUpdate(sql,params);
    }

    public Product findById(int id){
        String sql = "select * from t_account where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString("name"));
                product.setAge(resultSet.getInt(3));

                return product;
            }
        },id);
    }

    public Product findByIdAuto(int id){
        String sql = "select * from t_account where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class),id);
    }

    public List<Product> findAll(){
        String sql = "select * from t_account";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public Long countAll(){
        String sql = "select count(*) from t_Account";
        return jdbcTemplate.queryForObject(sql, new SingleColumnRowMapper<>(long.class));
    }

    public void update(Product product){
        String sql = "update t_account set age = ? where id = ?";
        jdbcTemplate.update(sql,product.getAge(),product.getId());
    }

    public List<Map<String, Object>> findAllMap(){
        String sql = "select * from t_Account";
        return jdbcTemplate.query(sql,new ColumnMapRowMapper());
    }

}
