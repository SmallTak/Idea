package com.kaishengit.service;

import com.kaishengit.Application;
import com.kaishengit.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring.xml")
@ContextConfiguration(classes = Application.class)
public class ServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findByIdTest(){

        Product product = productService.findById(2177);
        System.out.println(product);
    }
    @Test
    public void fingByLike(){
        List<Product> productList = productService.findByLike("%MDR-XB550%");
        for (Product product : productList){
            System.out.println(product);
        }
    }
    @Test
    public void insertTest(){

        Product product = new Product();
        product.setProductName("卡西欧G-SHOCK");
        BigDecimal bigDecimal = new BigDecimal(990);
        product.setPrice(bigDecimal);
        product.setMarketPrice(bigDecimal);
        product.setPlace("Japan");
        product.setCommentNum(100);
        product.setTypeId(2);
        productService.insertTest(product);

    }

}
