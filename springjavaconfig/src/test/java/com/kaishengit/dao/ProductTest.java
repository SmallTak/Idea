package com.kaishengit.dao;

import com.kaishengit.baseTestCase;
import com.kaishengit.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductTest extends baseTestCase {

    @Autowired                                                                          //若报错则使用注解的方式，把base改为注解的方式
    private ProductDao productDao;

    @Test
    public void insert(){
        Product product = new Product("周云飞",17);
        productDao.insert(product);
    }

    /*批量增加*/
    @Test
    public void batchInsert(){

        List<Product> productList = Arrays.asList(
                new Product("云飞扬",17),
                new Product("李狗子",20),
                new Product("周总",28)
        );
        productDao.batchInsert(productList);

    }

    @Test
    public void findByid(){
        Product product = productDao.findById(4);
        System.out.println(product);
    }
    @Test
    public void findByidAuto(){
        Product product = productDao.findByIdAuto(4);
        System.out.println(product);
    }

    @Test
    public void findAll(){
        List<Product> productList = productDao.findAll();
      //  Assert.assertEquals(productList.size(),5);
        for(Product product : productList){
            System.out.println(product);
        }
    }

    @Test
    public void findCount(){
        Long aLong = productDao.countAll();
        System.out.println(aLong);
    }

    @Test
    public void update(){
        Product product = productDao.findById(8);
        product.setAge(19);
        productDao.update(product);
    }

    @Test
    public void findAllMap(){

        List<Map<String, Object>> mapList = productDao.findAllMap();
        for (Map<String,Object> maps : mapList){
            for (Map.Entry entry : maps.entrySet()){
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
            System.out.println("--------------");
        }

    }

}
